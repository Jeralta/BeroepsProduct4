package com.example.bp4.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.bp4.Model.Cursist;
import com.example.bp4.Model.Vrijwilliger;
import com.example.bp4.R;
import com.example.bp4.Adapter.VrijwilligerAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

public class OverzichtVrijwilliger extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Vrijwilliger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht_vrijwilliger);
        final TextView textView = (TextView) findViewById(R.id.textView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = " http://145.49.75.86:9221/Bp4Webservice/webresources/webservice.vrijwilliger ";
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
                Vrijwilliger s = (Vrijwilliger) parent.getItemAtPosition(position);
                ArrayList<Vrijwilliger>v = new ArrayList<>();
                v.add(s);
//                System.out.println(s);
//                onItemClicked item = Adapter.getItemAtPosition(position);
                Intent intent = new Intent(view.getContext(), SecondVrijwilliger.class);
                //TextView TextView = (TextView) findViewById(R.id.textView);
                //String message = textView.getText().toString();
                //based on item add info to intent
                intent.putParcelableArrayListExtra("VOORNAAM", v);
                startActivity(intent);

            }
        });
    }
    public void buildItems(String response) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));
            NodeList velden = doc.getElementsByTagName("vrijwilligers");
            NodeList alVelden = (velden.item(0)).getChildNodes();
            ArrayList<Vrijwilliger> deVelden = new ArrayList<>();
            for (int i = 0; i < alVelden.getLength(); i++) {
                Node n = alVelden.item(i);
                Node name = n.getChildNodes().item(1);
                String strName = name.getTextContent();
                Vrijwilliger nieuweVrijwilliger = new Vrijwilliger();
                // check of er een tussenvoegsel

                // check of er geen null value
                nieuweVrijwilliger.setVOORNAAM(n.getChildNodes().item(0).getTextContent());
                nieuweVrijwilliger.setACHTERNAAM(n.getChildNodes().item(1).getTextContent());
//                if()

//                nieuweVrijwilliger.setTUSSENVOEGSEL(n.getChildNodes().item(5).getTextContent());
                nieuweVrijwilliger.setEMAIL(n.getChildNodes().item(2).getTextContent());
                nieuweVrijwilliger.setTELNR(n.getChildNodes().item(3).getTextContent());

                nieuweVrijwilliger.setWOONPLAATS(n.getChildNodes().item(4).getTextContent());

                deVelden.add(nieuweVrijwilliger);
            }
            //ArrayAdapter<Cursist> CursistAdapter = new ArrayAdapter<Cursist>(this, android.R.layout.simple_list_item_1, deVelden);
            ArrayAdapter<Vrijwilliger> VrijwilligerAdapter = new VrijwilligerAdapter(this, deVelden);
            ListView lv = (ListView) findViewById(R.id.lv);
            lv.setAdapter(VrijwilligerAdapter);

//            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        public onItemClicked getItem; ( int position);{
//            return items.get(position);

//        }
    }
}

