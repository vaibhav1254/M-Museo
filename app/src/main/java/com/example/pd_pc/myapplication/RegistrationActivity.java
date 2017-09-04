package com.example.pd_pc.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;



public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgTag;
    EditText nameet, mailet, cellet, passet, repasset;
    Button sbtBtn, rstBtn;
    private AwesomeValidation awesomeValidation;
    TravellerDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dbHelper = new TravellerDBHelper(this);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);



        nameet = (EditText) findViewById(R.id.nameET);
        mailet = (EditText) findViewById(R.id.mailET);
        cellet = (EditText) findViewById(R.id.cellET);
        passet = (EditText) findViewById(R.id.passET);
        repasset = (EditText) findViewById(R.id.repassET);
        sbtBtn = (Button) findViewById(R.id.sbtbtn);
        rstBtn = (Button) findViewById(R.id.rstbtn);
        awesomeValidation.addValidation(this, R.id.nameET, "^[a-zA-Z0-9._]+$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.mailET, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.passET, "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$", R.string.passworderror);
        awesomeValidation.addValidation(this, R.id.cellET, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);





        rstBtn.setOnClickListener(this);
        sbtBtn.setOnClickListener(this);



    }

    @Override

    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.rstbtn:
                resetALL();
                break;
            case R.id.sbtbtn:
                submit();
                break;
        }
    }

    void resetALL() {
        nameet.setText("");
        mailet.setText("");
        passet.setText("");
        repasset.setText("");
        cellet.setText("");

    }

    void submit() {

        String email=mailet.getText().toString();
        String number=cellet.getText().toString();
        String paset=passet.getText().toString();
        String name = nameet.getText().toString();
        String repaset=repasset.getText().toString();

        if(name.length()==0 && number.length()==0 && email.length()==0 && paset.length()==0 && repaset.length()==0)
        {
            Snackbar.make(getCurrentFocus(),"All fields are empty",Snackbar.LENGTH_SHORT);
        }
        if(paset.length()==0 && repaset.length()==0) {
            if (name.length() < 5) {
                nameet.setError("Name not valid");
            }

            if (number.length() == 0) {
                cellet.setError("Cell Number is not valid");
            }
            if (email.length() == 0) {
                mailet.setError("Email is not valid");
            }
            if (paset.length() == 0) {
                passet.setError("Password required");
            }
            if (repaset.length() == 0) {
                repasset.setError("Password confirmation required");
            }

        }


        else {
            if (!paset.equals(repaset)) {
                Snackbar.make(getCurrentFocus(),"Password Mismatch",Snackbar.LENGTH_SHORT).show();
            }
        }

        dbHelper.addTraveller(new Traveller(name, number, email, paset, repaset));

          if(awesomeValidation.validate())
          {
              Toast.makeText(this,"Registration Succesful..redirecting",Toast.LENGTH_LONG).show();
              new Handler().postDelayed(new Runnable() {
                  @Override

                  public void run() {
                      Intent mainIntent = new Intent(RegistrationActivity.this, LoginActivity.class);
                      startActivity(mainIntent);
                      finish();


                  }
              },3000);




          }


        }

    }







