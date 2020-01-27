package myapplication.example.mapinproject.business.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import myapplication.example.mapinproject.R;

public class UserRegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText musernameText;
    private EditText mkomentoText;
    private FirebaseAuth mAuth;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_register);
        musernameText = findViewById(R.id.usernameText3);
        mkomentoText = findViewById(R.id.komentoText6);
        findViewById(R.id.tourokuButton).setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tourokuButton:
                dbsave(musernameText.getText().toString(), mkomentoText.getText().toString());

                break;
        }
    }
        private void dbsave(String email, String password) {
//            if (!validateForm()) {
//                return;
//            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//                                changeActivity();
                            } else {
//                                Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
//}
