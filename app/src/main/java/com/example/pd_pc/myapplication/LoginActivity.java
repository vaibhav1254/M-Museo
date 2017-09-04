package com.example.pd_pc.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText lpet,useret;
    Button logBtn,rgstBtn;
    TravellerDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        dbHelper = new TravellerDBHelper(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lpet = (EditText) findViewById(R.id.lpET);
         useret = (EditText) findViewById(R.id.userET);
        logBtn = (Button) findViewById(R.id.logbtn);
        rgstBtn = (Button) findViewById(R.id.rgstbtn);



        logBtn.setOnClickListener(this);
        rgstBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.exit_dialog).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.logbtn:
                submit();
                break;
            case R.id.rgstbtn:
                redirect();
                break;
    }
}
public void submit()
    {

        if (useret.getText().toString().length() != 0 && lpet.getText().toString().length() != 0) {
            String name = useret.getText().toString();
            String password = lpet.getText().toString();
            String Confipassword = dbHelper.getPassword(name);

            if (password.equals(Confipassword)) {
                Intent intent = new Intent(LoginActivity.this, FullscreenActivity.class);
                startActivity(intent);
            } else {
                Snackbar.make(lpet, "Enter Correct Password", Snackbar.LENGTH_SHORT).show();
            }
        }
        else {
            Snackbar.make(getCurrentFocus(),"Enter username and password",Snackbar.LENGTH_SHORT).show();
        }

    }

    private void redirect()
    {

        Intent i = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(i);
        finish();

    }

    }
