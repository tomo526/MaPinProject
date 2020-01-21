package myapplication.example.mapinproject.business.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.OAuthProvider;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.data.entities.Test;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private EditText mEmailField;
    private EditText mPassField;
    OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mEmailField = findViewById(R.id.emailField);
        mPassField = findViewById(R.id.passwdField);

        findViewById(R.id.emailLoginButton).setOnClickListener(this);
        findViewById(R.id.emailSignUpButton).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.emailLoginButton:
                signIn(mEmailField.getText().toString(), mPassField.getText().toString());
                break;
            case R.id.emailSignUpButton:
                createAccount(mEmailField.getText().toString(), mPassField.getText().toString());
                break;
            case R.id.Facebookbutton:

                changeActivity();

                break;
            case R.id.nbutton2:
                checklogin();
                loginfllor();
                loginlink();
                changeActivity();

                break;
        }
    }


    private void createAccount(String email, String password) {
        if (!validateForm()) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            changeActivity();
                        } else {
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signIn(String email, String password) {
        if (!validateForm()) {
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            changeActivity();
                        } else {
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPassField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassField.setError("Required.");
            valid = false;
        } else {
            mPassField.setError(null);
        }

        return valid;
    }

    private void changeActivity() {
        Intent intent = new Intent(LoginActivity.this, TestActivity.class);
        startActivity(intent);
    }

    private void checklogin() {
        Task<AuthResult> pendingResultTask = mAuth.getPendingAuthResult();
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                    .addOnSuccessListener(
                            new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    // User is signed in.
                                    // IdP data available in
                                    // authResult.getAdditionalUserInfo().getProfile().
                                    // The OAuth access token can also be retrieved:
                                    // authResult.getCredential().getAccessToken().
                                    // The OAuth secret can be retrieved by calling:
                                    // authResult.getCredential().getSecret().
                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Handle failure.
                                }
                            });
        } else {
            // There's no pending result so you need to start the sign-in flow.
            // See below.
        }

    }

    private void loginfllor() {
        mAuth
                .startActivityForSignInWithProvider(/* activity= */ this, provider.build())
                .addOnSuccessListener(
                        new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                // User is signed in.
                                // IdP data available in
                                // authResult.getAdditionalUserInfo().getProfile().
                                // The OAuth access token can also be retrieved:
                                // authResult.getCredential().getAccessToken().
                                // The OAuth secret can be retrieved by calling:
                                // authResult.getCredential().getSecret().
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle failure.
                            }
                        });
    }

    private void loginlink() {
        // The user is already signed-in.
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        firebaseUser
                .startActivityForLinkWithProvider(/* activity= */ this, provider.build())
                .addOnSuccessListener(
                        new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                // Twitter credential is linked to the current user.
                                // IdP data available in
                                // authResult.getAdditionalUserInfo().getProfile().
                                // The OAuth access token can also be retrieved:
                                // authResult.getCredential().getAccessToken().
                                // The OAuth secret can be retrieved by calling:
                                // authResult.getCredential().getSecret().
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle failure.
                            }
                        });


    }
}