package com.example.yo_mu_000.signin;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterToyota extends ArrayAdapter<String> {

    private final int []imgToyota;

    public CustomAdapterToyota(Context context, String[]toyotaDetails, int[]imgToyota) {
        super(context, R.layout.custom_row_toyota,toyotaDetails);
        this.imgToyota=imgToyota;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater toyotaInflater=LayoutInflater.from(getContext());
        View customViewToyota=toyotaInflater.inflate(R.layout.custom_row_toyota, parent, false);

        String singleToyotaCar=getItem(position);
        TextView toyotaTextView=(TextView) customViewToyota.findViewById(R.id.toyotaTextView);
        ImageView toyotaCar=(ImageView) customViewToyota.findViewById(R.id.toyotaCar);

        toyotaTextView.setText(singleToyotaCar);
        toyotaCar.setImageResource(imgToyota[position]);
        return customViewToyota;
    }
}
