package com.example.ejemplocardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

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

import adaptador.EvaluadoAdapter;
import adaptador.EvaluadorAdapter;
import modelo.Evaluado;
import modelo.Evaluador;

public class EvaluadosActivity extends AppCompatActivity {

    List<Evaluado> listaEvaluados;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluados);
        Bundle bundle = getIntent().getExtras();
        Evaluador evaluador = (Evaluador) bundle.getSerializable("Evaluador");

        String id = evaluador.getIdEvaluador();
        requestQueue= Volley.newRequestQueue(this);
        buscarVolley("https://uealecpeterson.net/ws/listadoaevaluar.php", id);
    }

    private void buscarVolley(String url, String id) {
        url = url + "?e=" +id;
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            listaEvaluados = new ArrayList<Evaluado>();
                            JSONArray jsonArray = response.getJSONArray("listaaevaluador");

                            int tamanio = jsonArray.length();
                            if (tamanio > 0) {
                                for (int i = 0; i < tamanio; i++) {
                                    JSONObject json = new JSONObject(jsonArray.getString(i));
                                    //(String id, String idEvaluado, String nombres, String genero, String situacion,
                                    //                    String cargo, String fechaInicio, String fechaFin, String imgJPG, String imgJpg)
                                    Evaluado evaluado = new Evaluado(json.getString("id"),
                                            json.getString("idevaluado"),
                                            json.getString("Nombres"),
                                            json.getString("genero"),
                                            json.getString("situacion"),
                                            json.getString("fechainicio"),
                                            json.getString("fechainicio"),
                                            json.getString("fechafin"),
                                            json.getString("imgJPG"), json.getString("imgjpg"));
                                    listaEvaluados.add(evaluado);
                                }
                            } else {
                                Toast.makeText(EvaluadosActivity.this, "Sin resultados", Toast.LENGTH_LONG);
                            }
                            setAdapter();
                        } catch (JSONException ex) {
                            Toast.makeText(EvaluadosActivity.this, ex.getMessage(), Toast.LENGTH_LONG);
                            System.out.println(ex.toString());
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError ex) {
                Toast.makeText(EvaluadosActivity.this, ex.getMessage(), Toast.LENGTH_LONG);
                System.out.println(ex.toString());
            }
        });
        requestQueue.add(jsonRequest);
    }

    private void setAdapter() {
        EvaluadoAdapter adapter = new EvaluadoAdapter(listaEvaluados, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerEvaluado);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}