package com.rachmatwahid.resto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_REQUEST = 1;
    private static final String STATE_USERNAME = "USERNAME";
    private static final String STATE_PASSWORD = "PASSWORD";
    EditText editTextUsername, editTextPassword;
    String username, password, registerUsername, registerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        if (savedInstanceState != null) {
            registerUsername = savedInstanceState.getString(STATE_USERNAME);
            registerPassword = savedInstanceState.getString(STATE_PASSWORD);
        }
    }

    public void login(View view) {
        username = editTextUsername.getText().toString();
        password = editTextPassword.getText().toString();
        checkUsernamePassword(username, password);
    }

    public void register(View view) {
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivityForResult(registerIntent, REGISTER_REQUEST);
    }

    private void checkUsernamePassword(String username, String password) {

        if (registerUsername == null && registerPassword == null) {
            Toast.makeText(this, "You have to register!", Toast.LENGTH_LONG).show();
        } else {
            if (username.equals(registerUsername) && password.equals(registerPassword)) {
                Toast.makeText(this, "Login success!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login failed!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REGISTER_REQUEST) {
            if (resultCode == RESULT_OK) {
                registerUsername = data.getStringExtra(RegisterActivity.EXTRA_USERNAME);
                registerPassword = data.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_USERNAME, registerUsername);
        outState.putString(STATE_PASSWORD, registerPassword);
    }
}