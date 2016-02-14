package com.example.yo_mu_000.signin;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomAdapterBmw extends ArrayAdapter<String>{

    private final int []imgBmw;

    public CustomAdapterBmw(Context context, String[] bmwDetails,int[]imgBmw) {
        super(context,R.layout.custom_row_bmw,bmwDetails);
        this.imgBmw=imgBmw;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater bmwInflater=LayoutInflater.from(getContext());
        View customViewBmw=bmwInflater.inflate(R.layout.custom_row_bmw, parent, false);

        String singleBmwCar=getItem(position);
        TextView bmwTextView=(TextView) customViewBmw.findViewById(R.id.bmwTextView);
        ImageView bmwCar=(ImageView) customViewBmw.findViewById(R.id.bmwCar);

        bmwTextView.setText(singleBmwCar);
        bmwCar.setImageResource(imgBmw[position]);
        return customViewBmw;
    }
}
