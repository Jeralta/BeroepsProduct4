package com.example.bp4.Adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bp4.Model.Buurthuis;
import com.example.bp4.R;

import java.util.ArrayList;

public class BuurthuisAdapter extends ArrayAdapter<Buurthuis> {

    public BuurthuisAdapter(Context context, ArrayList<Buurthuis> Buurthuis){
        super(context,android.R.layout.simple_list_item_1, Buurthuis);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Buurthuis buurthuis = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvNaam = (TextView) convertView.findViewById(R.id.lvNaam);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.lvEmail);
        // Populate the data into the template view using the data object
        tvNaam.setText(buurthuis.getNAAM());
        tvEmail.setText(buurthuis.getADRES());
        // Return the completed view to render on screen
        return convertView;
    }
}
