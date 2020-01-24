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

import myapplication.example.mapinproject.R;

public class UserRegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText musernameText;
    private EditText mkomentoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        musernameText = findViewById(R.id.usernameText3);
        mkomentoText = findViewById(R.id.komentoText6);
        findViewById(R.id.tourokuButton).setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tourokuButton:
            //    signIn(musernameText.getText().toString(), mkomentoText.getText().toString());
                break;
        }
    }
}
