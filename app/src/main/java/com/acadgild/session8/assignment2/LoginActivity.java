package com.acadgild.session8.assignment2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    EditText etPassword1, etPassword2;
    Button btnSave;

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPassword1 = (EditText) findViewById(R.id.etPassword1);
        etPassword2 = (EditText) findViewById(R.id.etPassword2);
        btnSave = (Button) findViewById(R.id.buttonSave);



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        btnSave.setOnClickListener(this);

        LoadPreferences();

        etPassword2.setOnFocusChangeListener(this);

    }


    private void LoadPreferences() {
        //String retv_UserName = mSharedPreferences.getString("USER_NAME", "Default value");
        String retv_Password = mSharedPreferences.getString("PASSWORD", "Default value");

        etPassword1.setText(retv_Password);
        etPassword2.setText(retv_Password);

    }


    private void saveMyPreferences(String KEY, String VALUE) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY, VALUE);
        editor.apply();
    }

    private void saveMyPreferences(String KEY, boolean VALUE) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(KEY, VALUE);
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        if (etPassword1.getText().equals(etPassword2.getText())) {
            String password = etPassword1.getText().toString();

            saveMyPreferences("PASSWORD", password);
            finish();
        }else{
            Toast.makeText(LoginActivity.this, "Please retype the password correctly.. ... ", Toast.LENGTH_SHORT).show();
            etPassword2.setText("");
            etPassword2.requestFocus();

        }

    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.etPassword2) {
            if (!hasFocus) {
                if (!etPassword1.getText().toString().trim().equals(etPassword2.getText().toString().trim())) {
                    etPassword2.setError("Re-type correct password");
                    etPassword2.requestFocus();
                }
            }
        }
    }

}
