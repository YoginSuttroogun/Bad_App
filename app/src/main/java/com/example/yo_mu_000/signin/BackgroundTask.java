package com.example.yo_mu_000.signin;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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

public class BackgroundTask extends AsyncTask<String,Void,String>{
    Context ctx;
    AlertDialog alertDialog;

    BackgroundTask(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Iogin Information");

    }

    @Override
    protected String doInBackground(String... params) {
//        String reg_url="http://10.0.2.2/customer/register.php";
//        String login_url="http://10.0.2.2/customer/login.php";

        String reg_url="http://automationtesting.site88.net/add_info.php";
        String login_url="http://automationtesting.site88.net/test.php";


        String method= params[0];
        if(method.equals("register")){
            String full_name=params[1];
            String date_of_birth=params[2];
            String phone_no=params[3];
            String address=params[4];
            String username=params[5];
            String password=params[6];


            try{
                URL url=new URL(reg_url);
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

        }

        else if(method.equals("login")){
            String log_username=params[1];
            String log_password=params[2];
            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String data=URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(log_username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(log_password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String response="";
                String line="";
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

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration successful...")){
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }
        else {
            alertDialog.setMessage(result);
            alertDialog.show();


        }
    }

}
