package com.example.bp4.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bp4.Model.Cursist;
import com.example.bp4.R;

import java.util.ArrayList;

public class SecondCursist extends AppCompatActivity {
// weergeven van resultaat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_cursist);
        ArrayList<Cursist> arrayList =  getIntent().getParcelableArrayListExtra("VOORNAAM");
        Cursist c = arrayList.get(0);
        TextView tvNaam = findViewById(R.id.tvNaam);
        TextView tvTest = findViewById(R.id.tvTest);
        TextView tvTelefoon = findViewById(R.id.tvTelefoon);

        tvNaam.setText(c.getVOORNAAM());
        tvTest.setText(c.getEMAIL());
        tvTelefoon.setText(c.getTELNR());

    }
}
