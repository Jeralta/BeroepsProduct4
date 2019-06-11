package com.example.bp4.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bp4.Model.Cursist;
import com.example.bp4.Model.Vrijwilliger;
import com.example.bp4.R;

import java.util.ArrayList;

public class SecondVrijwilliger extends AppCompatActivity {
    // weergeven van resultaat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_vrijwilliger);
        ArrayList<Vrijwilliger> arrayList =  getIntent().getParcelableArrayListExtra("VOORNAAM");
        Vrijwilliger v = arrayList.get(0);
        TextView tvNaam = findViewById(R.id.tvNaam);
        TextView tvTest = findViewById(R.id.tvTest);
        TextView tvTelefoon = findViewById(R.id.tvTelefoon);

        tvNaam.setText(v.getVOORNAAM());
        tvTest.setText(v.getEMAIL());
        tvTelefoon.setText(v.getTELNR());
    }
}
