package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void login(View view) {
        username = editTextUsername.getText().toString();
        password = editTextPassword.getText().toString();
        checkUsernamePassword(username, password);
    }

    public void register(View view) {
        Toast.makeText(this, "Do you have an email address?", Toast.LENGTH_LONG).show();
    }

    private void checkUsernamePassword(String username, String password) {
        if (username.equals("admin") && password.equals("123")) {
            Toast.makeText(this, "Login success!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Login failed!", Toast.LENGTH_LONG).show();
        }
    }
}