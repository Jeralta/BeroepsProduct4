package com.example.bp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonVrijwilliger, buttonCursist, buttonBuurthuis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonVrijwilliger= (Button) findViewById(R.id.buttonVrijwilliger);
        buttonCursist = (Button) findViewById(R.id.buttonCursist);
        buttonBuurthuis = (Button) findViewById(R.id.buttonBuurthuis);

        buttonVrijwilliger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVrijwilliger();
            }
        });

        buttonCursist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showCursist();
            }
        });

        buttonBuurthuis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showBuurthuis();
            }
        });
    }
    //Inschrijven van de vrijwilliger starten
    public void showVrijwilliger(){
        Intent intent = new Intent(this, InschrijvenVrijwilliger.class);
        startActivity(intent);
    }
    // Inschrijven van de cursist starten
    public void showCursist(){
        Intent intent = new Intent(this, InschrijvenCursist.class);
        startActivity(intent);
    }
    // Toevoegen buurthuis
    public void showBuurthuis(){
        Intent intent = new Intent(this, ToevoegenBuurthuis.class);
        startActivity(intent);
    }
}
