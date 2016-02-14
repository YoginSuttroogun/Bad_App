package com.example.yo_mu_000.signin;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class signUpDetails extends Activity {

    //DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_details);
    }


    public void signUpButtonSignUpDetails(View view){

        if(view.getId()==R.id.signUpButtonSignUpDetailsId){

            EditText usernameInput=(EditText) findViewById(R.id.usernameInputSignUpDetails);
            EditText passwordInput=(EditText) findViewById(R.id.passwordInputSignUpDetails);
            EditText confirmpassInput=(EditText) findViewById(R.id.confirmpassInputSignUpDetails);

            String usernameInputStr=usernameInput.getText().toString();
            String passwordInputStr=passwordInput.getText().toString();
            String confirmpassInputStr=confirmpassInput.getText().toString();

            //sign up ->needed to store information in database
           /* EditText nameInput=(EditText) findViewById(R.id.nameInput);
            EditText dobInput=(EditText) findViewById(R.id.dobInput);
            EditText phoneInput=(EditText) findViewById(R.id.phoneInput);
            EditText addressInput=(EditText) findViewById(R.id.addressInput);

            String nameInputStr=nameInput.getText().toString();
            String dobInputStr=dobInput.getText().toString();
            String phoneInputStr=phoneInput.getText().toString();
            String addressInputStr=addressInput.getText().toString();*/


            if((usernameInputStr.isEmpty())){
                Toast.makeText(signUpDetails.this,"Username cannot be blank!",Toast.LENGTH_SHORT).show();
            }
            if((passwordInputStr.isEmpty())){
                Toast.makeText(signUpDetails.this,"Password cannot be blank!",Toast.LENGTH_SHORT).show();
            }
            if((confirmpassInputStr.isEmpty())){
                Toast.makeText(signUpDetails.this,"Confirm password cannot be blank!",Toast.LENGTH_SHORT).show();
            }

            if(!((passwordInputStr.isEmpty()) && (confirmpassInputStr.isEmpty()))){
                if(!(passwordInputStr.equals(confirmpassInputStr))){
                    Toast.makeText(signUpDetails.this,"Password not matching!",Toast.LENGTH_SHORT).show();
                }
               else{
                    //insert the details in the database
                    CustomerDB cdb=new CustomerDB();

                    //Using bundle to access information from previous activity

                    Bundle bundle=getIntent().getExtras();
                    String nameInputEx=bundle.getString("Full Name");

                    Bundle bundleDob=getIntent().getExtras();
                    String dobInputEx=bundleDob.getString("Date of Birth");

                    Bundle bundlePhoneNo=getIntent().getExtras();
                    String phoneInputEx=bundlePhoneNo.getString("PhoneNo");

                    Bundle bundleAddress=getIntent().getExtras();
                    String addressInputEx=bundleAddress.getString("Address");

                    /*cdb.setFname(nameInputEx);
                    cdb.setDob(dobInputEx);
                    cdb.setPhoneNo(phoneInputEx);
                    cdb.setAddress(addressInputEx);
                    cdb.setUname(usernameInputStr);
                    cdb.setPassword(passwordInputStr);

                    helper.insertCustomer(cdb);*/


                    //Web Server
                    /*String method="register";
                    BackgroundTask backgroundTask=new BackgroundTask(this);
                    backgroundTask.execute(method,nameInputEx,dobInputEx,phoneInputEx,addressInputEx,usernameInputStr,passwordInputStr);*/

                    BackgroundTask backgroundTask=new BackgroundTask();
                    backgroundTask.execute(nameInputEx,dobInputEx,phoneInputEx,addressInputEx,usernameInputStr,passwordInputStr);
                    //finish();

                    Intent signIn=new Intent(this,MainActivity.class);
                    startActivity(signIn);
                }
            }
        }

    }

    class BackgroundTask extends AsyncTask<String,Void,String>{

        String add_info_url="http://automationtesting.site88.net/add_info.php";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        String response="";
        String line="";

        @Override
        protected String doInBackground(String... args) {
            String full_name=args[0];
            String date_of_birth=args[1];
            String phone_no=args[2];
            String address=args[3];
            String username=args[4];
            String password=args[5];


                try{
                    URL url=new URL(add_info_url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream OS=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                    String data= URLEncoder.encode("full_name","UTF-8")+"="+URLEncoder.encode(full_name,"UTF-8")+"&"+
                            URLEncoder.encode("date_of_birth","UTF-8")+"="+URLEncoder.encode(date_of_birth,"UTF-8")+"&"+
                            URLEncoder.encode("phone_no","UTF-8")+"="+URLEncoder.encode(phone_no,"UTF-8")+"&"+
                            URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"+
                            URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                            URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();

                    InputStream IS=httpURLConnection.getInputStream();
                    IS.close();
                    return "Registration successful...";
                }
                catch(MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            if(result.equalsIgnoreCase("Registration successful...")){
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            }

        }
    }


    public void cancelButtonSignUpDetails(View view){

        if(view.getId()==R.id.cancelButtonSignUpDetails){
            Intent cancelButtonSignUpDetails=new Intent(this,signUp.class);
            startActivity(cancelButtonSignUpDetails);
        }

    }
}
