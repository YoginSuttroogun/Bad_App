package com.example.yo_mu_000.signin;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomAdapter extends ArrayAdapter<String>{

    private final int []imgs;

    public CustomAdapter(Context context, String[]cars, int []imgs) {
        super(context, R.layout.custom_row,cars);
        this.imgs=imgs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater carsInflater=LayoutInflater.from(getContext());
        View customView=carsInflater.inflate(R.layout.custom_row, parent, false);

        String singleCarsItem=getItem(position);
        TextView carsTextView=(TextView) customView.findViewById(R.id.carsTextView);
        ImageView carsImage=(ImageView) customView.findViewById(R.id.carsImage);

        carsTextView.setText(singleCarsItem);
        carsImage.setImageResource(imgs[position]);
        return customView;
    }
}
