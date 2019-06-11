package com.example.bp4.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
import com.example.bp4.Adapter.BuurthuisAdapter;
import com.example.bp4.Adapter.CursistAdapter;
import com.example.bp4.Model.Buurthuis;
import com.example.bp4.Model.Cursist;
import com.example.bp4.R;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class OverzichtBuurthuis extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Buurthuis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht_buurthuis);
        final TextView textView = (TextView) findViewById(R.id.textView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = " http://145.49.75.86:9221/Bp4Webservice/webresources/webservice.buurthuis ";
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
                Buurthuis s = (Buurthuis)parent.getItemAtPosition(position);
                ArrayList<Buurthuis>b = new ArrayList<>();
                b.add(s);
//                System.out.println(s);
//                onItemClicked item = Adapter.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), SecondBuurthuis.class);
                //TextView TextView = (TextView) findViewById(R.id.textView);
                //String message = textView.getText().toString();
                //based on item add info to intent
                intent.putParcelableArrayListExtra("NAAM", b);
                startActivity(intent);

            }
        });
    }

    public void buildItems(String response) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList velden = doc.getElementsByTagName("buurthuiss");
            NodeList alVelden = (velden.item(0)).getChildNodes();
            ArrayList<Buurthuis> deVelden = new ArrayList<>();
            for (int i = 0; i < alVelden.getLength(); i++) {
                Node n = alVelden.item(i);
                Node name = n.getChildNodes().item(1);
                String strName = name.getTextContent();
                Buurthuis nieuweBuurthuis = new Buurthuis();
                // check of er een tussenvoegsel

                // check of er geen null value
                nieuweBuurthuis.setNAAM(n.getChildNodes().item(2).getTextContent());
                nieuweBuurthuis.setADRES(n.getChildNodes().item(5).getTextContent());
//                if()


                nieuweBuurthuis.setCONTACTPERSOON(n.getChildNodes().item(1).getTextContent());
                nieuweBuurthuis.setTELNR(n.getChildNodes().item(4).getTextContent());
                nieuweBuurthuis.setPOSTCODE(n.getChildNodes().item(3).getTextContent());
                nieuweBuurthuis.setPLAATS(n.getChildNodes().item(0).getTextContent());
                deVelden.add(nieuweBuurthuis);
            }
            //ArrayAdapter<Cursist> CursistAdapter = new ArrayAdapter<Cursist>(this, android.R.layout.simple_list_item_1, deVelden);
            ArrayAdapter<Buurthuis> BuurthuisAdapter = new BuurthuisAdapter(this, deVelden);
            ListView lv = (ListView) findViewById(R.id.lv);
            lv.setAdapter(BuurthuisAdapter);

//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        public onItemClicked getItem; ( int position);{
//            return items.get(position);

//        }
    }
    }

