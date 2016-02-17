package com.example.yo_mu_000.signin;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CarDetailToyota extends Activity {

    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail_toyota);


    }

    public void rent(View view){
        if(view.getId()==R.id.rentButton){
            Intent r=new Intent(this,Gallery.class);
            startActivity(r);
            Toast.makeText(CarDetailToyota.this,"Rent successful",Toast.LENGTH_SHORT).show();
        }
    }
    //Retrieving information from db
    class BackgroundTask extends AsyncTask<Void,Void,String>{

        String json_url;
        @Override
        protected void onPreExecute() {
            json_url="http://automationtesting.site88.net/json_corolla.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder =new StringBuilder();
                while((json_string=bufferedReader.readLine())!=null){
                    stringBuilder.append(json_string+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
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
            TextView plateNoDetailsTextView=(TextView) findViewById(R.id.plateNoDetailsTextView);

        }
    }

}
