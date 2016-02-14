package com.example.yo_mu_000.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
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

public class Gallery extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        String [] cars={"Toyota","Alfa Romeo","Audi","BMW","Chevrolet","Citoen","Honda","Hyundai",
        "Jaguar","Kia","Land Rover","Mazda","Mercedes","Mini","Mitsubishi",
        "Nissan","Opel","Peugeot","Renault"};

        final int []imgs={R.drawable.toyota,R.drawable.alfaromeo,R.drawable.audi,R.drawable.bmw,
        R.drawable.chevrolet,R.drawable.citroen,R.drawable.honda,R.drawable.hyundai,R.drawable.jaguar,
        R.drawable.kia,R.drawable.landrover,R.drawable.mazda,R.drawable.mercedes,R.drawable.mini,
        R.drawable.mitsubshi,R.drawable.nissan,R.drawable.opel,R.drawable.peugeot,R.drawable.renault};

        ListAdapter carAdapter=new CustomAdapter(this,cars,imgs);
        ListView galleryListView=(ListView) findViewById(R.id.galleryListView);
        galleryListView.setAdapter(carAdapter);

        galleryListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String cars = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Gallery.this, cars, Toast.LENGTH_SHORT).show();

                        if(position==0){
                            Intent toyota=new Intent(view.getContext(),toyotaCars.class);
                            startActivity(toyota);
                        }

                        if(position==3){
                            Intent bmw=new Intent(view.getContext(),bmwCars.class);
                            startActivity(bmw);
                        }

                        if(position==15){
                            Intent nissan=new Intent(view.getContext(),nissanCars.class);
                            startActivity(nissan);
                        }
                    }
                }
        );
    }

}
