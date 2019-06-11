package com.example.bp4.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bp4.Adapter.CursistAdapter;
import com.example.bp4.Model.Cursist;
import com.example.bp4.R;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class OverzichtCursist extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Cursist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht_cursist);
        final TextView textView = (TextView) findViewById(R.id.textView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = " http://145.49.75.86:9221/Bp4Webservice/webresources/webservice.cursist ";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        buildItems(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);

        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursist s = (Cursist)parent.getItemAtPosition(position);
                ArrayList<Cursist>c = new ArrayList<>();
                c.add(s);
//                System.out.println(s);
//                onItemClicked item = Adapter.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), SecondCursist.class);
                //TextView TextView = (TextView) findViewById(R.id.textView);
                //String message = textView.getText().toString();
                //based on item add info to intent
                intent.putParcelableArrayListExtra("VOORNAAM", c);
                startActivity(intent);

            }
        });
    }

    public void buildItems(String response) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList velden = doc.getElementsByTagName("cursists");
            NodeList alVelden = (velden.item(0)).getChildNodes();
            ArrayList<Cursist> deVelden = new ArrayList<>();
            for (int i = 0; i < alVelden.getLength(); i++) {
                Node n = alVelden.item(i);
                Node name = n.getChildNodes().item(1);
                String strName = name.getTextContent();
                Cursist nieuweCursist = new Cursist();
                // check of er een tussenvoegsel

                // check of er geen null value
                nieuweCursist.setVOORNAAM(n.getChildNodes().item(5).getTextContent());
                nieuweCursist.setACHTERNAAM(n.getChildNodes().item(0).getTextContent());
//                if()

                nieuweCursist.setTUSSENVOEGSEL(n.getChildNodes().item(0).getTextContent());
                nieuweCursist.setEMAIL(n.getChildNodes().item(1).getTextContent());
                nieuweCursist.setTELNR(n.getChildNodes().item(4).getTextContent());
                nieuweCursist.setLANDVHERKOMST(n.getChildNodes().item(3).getTextContent());
                nieuweCursist.setWOONPLAATS(n.getChildNodes().item(0).getTextContent());
                deVelden.add(nieuweCursist);
            }
            //ArrayAdapter<Cursist> CursistAdapter = new ArrayAdapter<Cursist>(this, android.R.layout.simple_list_item_1, deVelden);
            ArrayAdapter<Cursist> CursistAdapter = new CursistAdapter(this, deVelden);
            ListView lv = (ListView) findViewById(R.id.lv);
            lv.setAdapter(CursistAdapter);

//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        public onItemClicked getItem; ( int position);{
//            return items.get(position);

//        }
    }
}