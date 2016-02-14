package com.example.yo_mu_000.signin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void cancelOnClickSignUp(View view){

        if(view.getId()==R.id.cancelButtonSignUp){
            Intent cancelSignUp=new Intent(this,MainActivity.class);
            startActivity(cancelSignUp);
        }

    }

    public void submitOnClickSignUp(View view){

        if(view.getId()==R.id.submitButtonSignUpId){

            EditText nameInput=(EditText) findViewById(R.id.nameInput);
            EditText dobInput=(EditText) findViewById(R.id.dobInput);
            EditText phoneInput=(EditText) findViewById(R.id.phoneInput);
            EditText addressInput=(EditText) findViewById(R.id.addressInput);

            String nameInputStr=nameInput.getText().toString();
            String dobInputStr=dobInput.getText().toString();
            String phoneInputStr=phoneInput.getText().toString();
            String addressInputStr=addressInput.getText().toString();

            if((nameInputStr.isEmpty())){
                Toast.makeText(signUp.this,"Full Name cannot be blank!",Toast.LENGTH_SHORT).show();
            }

            if(dobInputStr.isEmpty()){
                Toast.makeText(signUp.this,"Date of Birth cannot be blank!",Toast.LENGTH_SHORT).show();
            }

            if(phoneInputStr.isEmpty()){
                Toast.makeText(signUp.this,"Phone Number cannot be blank!",Toast.LENGTH_SHORT).show();
            }

            if(addressInputStr.isEmpty()){
                Toast.makeText(signUp.this,"Address cannot be blank!",Toast.LENGTH_SHORT).show();
            }

            if ((!(nameInputStr.isEmpty())&&(!(dobInputStr.isEmpty()))&&(!(phoneInputStr.isEmpty()))&&(!(addressInputStr.isEmpty())))) {
                Intent submitSignUp=new Intent(this,signUpDetails.class);
                submitSignUp.putExtra("Full Name",nameInputStr);
                submitSignUp.putExtra("Date of Birth",dobInputStr);
                submitSignUp.putExtra("PhoneNo",phoneInputStr);
                submitSignUp.putExtra("Address",addressInputStr);
                startActivity(submitSignUp);
            }

            //using extra to pass the information to next activity -> signUpDetails

        }

    }

}