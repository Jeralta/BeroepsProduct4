package com.example.bp4.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bp4.Model.Buurthuis;
import com.example.bp4.Model.Cursist;
import com.example.bp4.R;

import java.util.ArrayList;

public class SecondBuurthuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_buurthuis);
        ArrayList<Buurthuis> arrayList =  getIntent().getParcelableArrayListExtra("NAAM");
        Buurthuis b = arrayList.get(0);
        TextView tvNaam = findViewById(R.id.tvNaam);
        TextView tvTest = findViewById(R.id.tvTest);
        TextView tvTelefoon = findViewById(R.id.tvTelefoon);

        tvNaam.setText(b.getNAAM());
        tvTest.setText(b.getADRES());
        tvTelefoon.setText(b.getTELNR());
    }
}
