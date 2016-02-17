package com.example.yo_mu_000.signin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    private EditText passwordInput;
    private EditText usernameInput;

    public static final String USER_NAME = "USERNAME";

    String usernameInputStr;
    String passwordInputStr;

    //DatabaseHelper helper=new DatabaseHelper(this);

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignUp(View view) {
        if (view.getId() == R.id.signUpButton) {
            Intent i = new Intent(this, signUp.class);
            startActivity(i);
        }

    }

    //testing code for list view after need to be amended later
    //when clicking on the sign in button it loads the gallery section, assuming successful sign in
    public void gallery(View view) {

        if (view.getId() == R.id.signInButton) {
            usernameInput = (EditText) findViewById(R.id.usernameInput);
            passwordInput = (EditText) findViewById(R.id.passwordInput);

            usernameInputStr = usernameInput.getText().toString();
            passwordInputStr = passwordInput.getText().toString();

            if ((usernameInputStr.isEmpty())) {
                Toast.makeText(MainActivity.this, "Username cannot be blank!", Toast.LENGTH_SHORT).show();
            }

            if ((passwordInputStr.isEmpty())) {
                Toast.makeText(MainActivity.this, "Password cannot be blank!", Toast.LENGTH_SHORT).show();
            }

            /*String password=helper.searchPass(usernameInputStr);

                if(passwordInputStr.equals(password)){
                    Toast.makeText(MainActivity.this,"Welcome "+usernameInputStr+" !",Toast.LENGTH_SHORT).show();
                    Intent m=new Intent(this,Gallery.class);
                    startActivity(m);
                }
                else{
                    Toast.makeText(MainActivity.this,"Incorrect Username and Password!",Toast.LENGTH_SHORT).show();
                }
            */
            /*String method="login";
            BackgroundTask backgroundTask=new BackgroundTask(this);
            backgroundTask.execute(method, usernameInputStr, passwordInputStr);*/

            BackgroundTask backgroundTask=new BackgroundTask();
            backgroundTask.execute(usernameInputStr, passwordInputStr);
            //finish();*/

            //userLogin(usernameInputStr, passwordInputStr);
        }

    }

    /*private void userLogin(final String usernameInputStr, final String passwordInputStr) {
        class UserLoginClass extends AsyncTask<String, Void, String> {

            String login_info_url="http://automationtesting.site88.net/test.php";

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                if (s.equalsIgnoreCase("success")) {
                    Intent gal = new Intent(getApplicationContext(), Gallery.class);
                    startActivity(gal);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }
            }


            String response = "";
            String line = "";

            @Override
            protected String doInBackground(String... args) {
                String username = args[0];
                String password = args[1];

                try {
                    URL url = new URL(login_info_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                    while ((line = bufferedReader.readLine()) != null) {
                        response += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                HashMap<String,String>data=new HashMap<>();
                data.put("username",args[0]);
                data.put("password",args[1]);


                return null;
            }


        }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(usernameInputStr,passwordInputStr);

         */

    class BackgroundTask extends AsyncTask<String,Void,String>{

        String login_info_url="http://automationtesting.site88.net/login_info.php";
        //ProgressDialog loading;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //loading = ProgressDialog.show(MainActivity.this,"Please Wait",null,true,true);
        }

        String response="";
        String line="";

        @Override
        protected String doInBackground(String... args) {
            String username=args[0];
            String password=args[1];

            try {
                URL url=new URL(login_info_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));


                while ((line=bufferedReader.readLine())!=null){
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;


            }
            catch (MalformedURLException e) {
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

            if(response.contains("failure")){
                Toast.makeText(MainActivity.this,"Incorrect username and password",Toast.LENGTH_LONG).show();
            }
            else{
                Intent g=new Intent(getApplicationContext(),Gallery.class);
                Toast.makeText(MainActivity.this,"Welcome "+usernameInputStr+"!",Toast.LENGTH_LONG).show();
                startActivity(g);
            }

        }
    }

}


