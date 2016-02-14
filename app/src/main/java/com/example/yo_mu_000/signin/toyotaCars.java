package com.example.yo_mu_000.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;


public class toyotaCars extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota_cars);

        String [] toyotaDetails={"Corolla","Avalon Hybrid","Camry","Yaris"};

        final int []imgToyota={R.drawable.toyotacorolla,R.drawable.avalonhybrid,R.drawable.camry,R.drawable.yaris};

        ListAdapter toyotaCarAdapter=new CustomAdapterToyota(this,toyotaDetails,imgToyota);
        ListView toyotaCarListView=(ListView) findViewById(R.id.toyotaCarsListView);
        toyotaCarListView.setAdapter(toyotaCarAdapter);

        toyotaCarListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String toyotaCar = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(toyotaCars.this, toyotaCar, Toast.LENGTH_SHORT).show();

                        if(position==0){
                            Intent corolla=new Intent(view.getContext(),CarDetailToyota.class);
                            startActivity(corolla);
                        }
                        if(position==1){
                            Intent avalon=new Intent(view.getContext(),CarDetailToyota.class);
                            startActivity(avalon);
                        }
                        if(position==2){
                            Intent camry=new Intent(view.getContext(),CarDetailToyota.class);
                            startActivity(camry);
                        }
                    }
                }
        );

    }





}
