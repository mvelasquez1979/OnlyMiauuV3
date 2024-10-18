package com.example.onlymiauu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Adopta_act extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adopta); // Asegúrate de establecer el contenido correcto

        // Inicializar dataList y ListView
        dataList = new ArrayList<>();
        listView = findViewById(R.id.listView); // ListView en el Activity
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // URL del JSON
        String url = "http://192.168.1.104/onlymiauu/consultar.php"; // Reemplaza con tu URL local

        // Crear una cola de solicitudes
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Hacer una solicitud JSON Array
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) { //Instancia el JSONArray en el objeto response
                        try {
                            // Iterar por cada objeto en el JSONArray
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String nombre = jsonObject.getString("nombre");
                                String color = jsonObject.getString("color");
                                String raza = jsonObject.getString("raza");

                                // Construir la cadena y agregarla al ArrayList
                                //String item = nombre + " - " + raza + " - " + color;
                                dataList.add(nombre + " - " + raza + " - " + color);
                            }
                            // Notificar al adapter que los datos han cambiado
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Mostrar un mensaje en caso de error
                        Toast.makeText(Adopta_act.this, "Error al obtener datos: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Agregar la solicitud a la cola
        requestQueue.add(jsonArrayRequest);
    }

    // Método para evaluar adopciones de gatos (sin cambios)
    public String adoptar(Integer cantidad, Integer edad, Boolean trabaja, Float sueldo) {
        String criterio = "";
        switch (cantidad) {
            case 1:
                if (edad >= 18 && trabaja) {
                    criterio = "Cumple, válido para adoptar 1 gatito";
                } else {
                    criterio = "No cumple, vuelve cuando tengas 18 años y/o cuentes con un trabajo";
                }
                break;
            case 2:
                if (edad >= 18 && trabaja && sueldo >= 600000) {
                    criterio = "Cumple, válido para adoptar 2 gatitos";
                } else {
                    criterio = "No cumple, se puede evaluar para adoptar 1 gatito ";
                }
                break;
            default:
                if (edad >= 18 && trabaja && sueldo >= 1800000) {
                    criterio = "Cumple, válido para adoptar varios gatitos";
                } else {
                    criterio = "No cumple, se puede evaluar para adoptar menos gatito ";
                }
                break;
        }
        return criterio;
    }
}
