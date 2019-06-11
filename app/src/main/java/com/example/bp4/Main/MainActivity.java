package com.example.bp4.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bp4.View.OverzichtBuurthuis;
import com.example.bp4.View.OverzichtCursist;
import com.example.bp4.R;
import com.example.bp4.View.OverzichtLes;
import com.example.bp4.View.OverzichtVrijwilliger;

public class MainActivity extends AppCompatActivity {
    private Button buttonVrijwilliger, buttonCursist, buttonBuurthuis, buttonLes;
    // button met action event
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonVrijwilliger = (Button) findViewById(R.id.buttonVrijwilliger);
        buttonCursist = (Button) findViewById(R.id.buttonCursist);
        buttonBuurthuis = (Button) findViewById(R.id.buttonBuurthuis);
        buttonLes = (Button) findViewById(R.id.buttonLes);

        buttonVrijwilliger.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
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
        buttonLes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showLes();
            }
        });
    }
    //Selecteren van de vrijwilliger starten
    public void showVrijwilliger(){
        Intent intent = new Intent(this, OverzichtVrijwilliger.class);
        startActivity(intent);
    }
    // Selecteren van de cursist starten
    public void showCursist(){
        Intent intent = new Intent(this, OverzichtCursist.class);
        startActivity(intent);
    }
//     Selecteren van buurthuis
    public void showBuurthuis(){
        Intent intent = new Intent(this, OverzichtBuurthuis.class);
        startActivity(intent);
    }
    //     Selecteren van buurthuis
    public void showLes(){
        Intent intent = new Intent(this, OverzichtLes.class);
        startActivity(intent);
    }
}
