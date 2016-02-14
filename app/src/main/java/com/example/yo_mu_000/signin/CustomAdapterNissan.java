package com.example.yo_mu_000.signin;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterNissan extends ArrayAdapter<String>{

    private final int []imgNissan;

    public CustomAdapterNissan(Context context, String[]nissanDetails,int []imgNissan) {
        super(context, R.layout.custom_row_nissan,nissanDetails);
        this.imgNissan=imgNissan;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater nissanInflater=LayoutInflater.from(getContext());
        View customViewNissan=nissanInflater.inflate(R.layout.custom_row_nissan, parent, false);

        String singleNissanItem=getItem(position);
        TextView nissanTextView=(TextView) customViewNissan.findViewById(R.id.nissanTextView);
        ImageView nissanCar=(ImageView) customViewNissan.findViewById(R.id.nissanCar);

        nissanTextView.setText(singleNissanItem);
        nissanCar.setImageResource(imgNissan[position]);
        return customViewNissan;
    }
}
