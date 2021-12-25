package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    public final static String EXTRA_USERNAME =
            "com.rachmatwahid.resto.USERNAME";

    public final static String EXTRA_PASSWORD =
            "com.rachmatwahid.resto.PASSWORD";

    EditText editTextUsername, editTextPassword;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void register(View view) {

        username = editTextUsername.getText().toString();
        password = editTextPassword.getText().toString();

        Intent returnRegisterIntent = new Intent();
        returnRegisterIntent.putExtra(EXTRA_USERNAME, username);
        returnRegisterIntent.putExtra(EXTRA_PASSWORD, password);
        setResult(RESULT_OK, returnRegisterIntent);
        finish();
    }
}