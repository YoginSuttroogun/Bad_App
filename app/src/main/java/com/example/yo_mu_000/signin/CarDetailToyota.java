package com.example.yo_mu_000.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CarDetailToyota extends AppCompatActivity {

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

}
