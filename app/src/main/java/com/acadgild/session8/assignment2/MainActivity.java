package com.acadgild.session8.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPassword = (TextView) findViewById(R.id.tvPassword);

        txtPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvPassword) {
            Intent intent =new  Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
