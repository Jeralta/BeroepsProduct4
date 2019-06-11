package com.example.bp4.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.example.bp4.Model.Les;
import com.example.bp4.R;

import java.util.ArrayList;

public class SecondLes extends AppCompatActivity {
    // weergeven van resultaat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_les);
        ArrayList<Les> arrayList =  getIntent().getParcelableArrayListExtra("LES");
        Les l = arrayList.get(0);
        TextView tvNaam = findViewById(R.id.tvNaam);
        TextView tvTest = findViewById(R.id.tvTest);
        TextView tvTelefoon = findViewById(R.id.tvTelefoon);

        tvNaam.setText(l.getIDLES());
        tvTest.setText(l.getWEEK());
        tvTelefoon.setText(l.getDAG());

    }
}

