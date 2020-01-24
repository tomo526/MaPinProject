package myapplication.example.mapinproject.business.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import myapplication.example.mapinproject.R;

public class UserRegisterActivity extends AppCompatActivity {
    private EditText musernameText;
    private EditText mkomentoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        musernameText = findViewById(R.id.usernameText3);
        mkomentoText = findViewById(R.id.komentoText6);
    }
}
