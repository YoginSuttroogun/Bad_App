package com.example.yo_mu_000.signin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import java.util.List;

public class bmwCars extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmw_cars);

        String[] bmwDetails = {"BMW i", "BMW Coupé", "BMW X6"};
        final int[] imgBmw = {R.drawable.bmwi, R.drawable.bmwcoupe, R.drawable.bmwx};

        ListAdapter bmwCarAdapter = new CustomAdapterBmw(this,bmwDetails,imgBmw);
        ListView bmwCarListView=(ListView) findViewById(R.id.bmwCarsListView);
        bmwCarListView.setAdapter(bmwCarAdapter);

        bmwCarListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String bmwCar=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(bmwCars.this,bmwCar,Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}