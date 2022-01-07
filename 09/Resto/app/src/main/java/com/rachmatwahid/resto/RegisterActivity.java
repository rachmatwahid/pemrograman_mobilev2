package com.rachmatwahid.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public final static String EXTRA_USERNAME =
            "com.rachmatwahid.resto.USERNAME";

    public final static String EXTRA_PASSWORD =
            "com.rachmatwahid.resto.PASSWORD";

    public final static String EXTRA_GENDER =
            "com.rachmatwahid.resto.GENDER";

    public final static String EXTRA_PHONE =
            "com.rachmatwahid.resto.GENDER";

    EditText editTextUsername, editTextPassword;
    Spinner spinnerPhone;
    String username, password, gender, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        spinnerPhone = findViewById(R.id.spinnerPhone);
        if (spinnerPhone != null) {
            spinnerPhone.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.phone_type, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPhone.setAdapter(arrayAdapter);

    }

    public void register(View view) {

        if (((CheckBox) findViewById(R.id.checkboxAgree)).isChecked()) {

            username = editTextUsername.getText().toString();
            password = editTextPassword.getText().toString();

            Intent returnRegisterIntent = new Intent();
            returnRegisterIntent.putExtra(EXTRA_USERNAME, username);
            returnRegisterIntent.putExtra(EXTRA_PASSWORD, password);
            returnRegisterIntent.putExtra(EXTRA_GENDER, gender);
            returnRegisterIntent.putExtra(EXTRA_PHONE, phone);
            setResult(RESULT_OK, returnRegisterIntent);
            finish();
        }
    }

    public void selectGender(View view) {
        if (((RadioButton) view).isChecked()) {
            switch (view.getId()) {
                case R.id.radioMale:
                    gender = "Male";
                    break;
                case R.id.radioFemale:
                    gender = "Female";
                    break;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        phone = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}