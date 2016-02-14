package com.example.yo_mu_000.signin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class nissanCars extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nissan_cars);

        String[] nissanDetails={"Qashqai","Murano","Juke","Maxima"};

        final int[]imgNissan={R.drawable.qashqai,R.drawable.murano,R.drawable.juke,R.drawable.maxima};

        ListAdapter nissanCarAdapter=new CustomAdapterNissan(this,nissanDetails,imgNissan);
        ListView nissanCarListView=(ListView) findViewById(R.id.nissanCarsListView);
        nissanCarListView.setAdapter(nissanCarAdapter);

        nissanCarListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String nissanCar=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(nissanCars.this,nissanCar,Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}
