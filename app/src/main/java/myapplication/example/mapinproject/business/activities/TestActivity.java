package myapplication.example.mapinproject.business.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.fragment.app.FragmentActivity;
import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.data.entities.Test;
import myapplication.example.mapinproject.data.entities.User;

public class TestActivity extends FragmentActivity implements View.OnClickListener {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
        findViewById(R.id.test_create).setOnClickListener(this);
        findViewById(R.id.test_read).setOnClickListener(this);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
    }

    private void read() {
        DatabaseReference ref = database.getReference("/test/testid");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Test text = dataSnapshot.getValue(Test.class);
                    textView.setText(text.getText());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                textView.setText("error");
            }
        });
    }

    private void create(String text) {
        DatabaseReference ref = database.getReference("/test/testid");
        Test test = new Test(text);
        ref.setValue(test);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.test_create) {
            create(editText.getText().toString());
        } else if (i == R.id.test_read) {
            read();
        }
    }
}