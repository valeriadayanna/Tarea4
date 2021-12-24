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
import com.android.volley.toolbox.JsonObjectRequest;
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

        requestQueue = Volley.newRequestQueue(this);
    }

    private void setAdapter() {
        EvaluadorAdapter adapter = new EvaluadorAdapter(listaEvaluadores, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerEvaluador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void eventoVolley(View v) {
        buscarVolley("https://www.uealecpeterson.net/ws/listadoevaluadores.php");
    }

    private void buscarVolley(String url) {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            listaEvaluadores = new ArrayList<Evaluador>();
                            JSONArray jsonArray = response.getJSONArray("listaaevaluador");

                            int tamanio = jsonArray.length();
                            if (tamanio > 0) {
                                for (int i = 0; i < tamanio; i++) {
                                    JSONObject json = new JSONObject(jsonArray.getString(i));
                                    Evaluador Evaluador = new Evaluador(json.getString("idevaluador"),
                                            json.getString("nombres"), json.getString("area"),
                                            json.getString("imgJPG"), json.getString("imgjpg"));
                                    listaEvaluadores.add(Evaluador);
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Sin resultados", Toast.LENGTH_LONG);
                            }
                            setAdapter();
                        } catch (JSONException ex) {
                            Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG);
                            System.out.println(ex.toString());
                        }
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