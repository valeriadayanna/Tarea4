package com.example.ejemplocardview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adaptador.EvaluadorAdapter;
import modelo.Evaluador;

public class MainActivity extends AppCompatActivity {

    List<Evaluador> listaEvaluadores;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setAdapter() {
        EvaluadorAdapter adapter = new EvaluadorAdapter(listaEvaluadores, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerEvaluador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void eventoVolley(View v) {
        buscarVolley("https://evaladmin.uteq.edu.ec/ws/listadoevaluadores.php");
    }

    private void buscarVolley(String url) {
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listaEvaluadores = new ArrayList<Evaluador>();

                        int tamanio = response.length();
                        if (tamanio > 0) {
                            try {
                                JSONArray jsonArray = response.getJSONArray(0);

                                for (int i = 0; i < tamanio; i++) {
                                    JSONObject json = new JSONObject(response.get(i).toString());
                                    Evaluador Evaluador = new Evaluador(json.getString("idevaluador"),
                                            json.getString("nombres"), json.getString("area"),
                                            json.getString("imgJPG"), json.getString("imgjpg"));
                                    listaEvaluadores.add(Evaluador);
                                }
                            } catch (JSONException ex) {
                                Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG);
                                System.out.println(ex.toString());
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Sin resultados", Toast.LENGTH_LONG);

                        }
                        setAdapter();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError ex) {
                Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG);
                System.out.println(ex.toString());
            }
        });
        requestQueue.add(jsonRequest);
    }

}