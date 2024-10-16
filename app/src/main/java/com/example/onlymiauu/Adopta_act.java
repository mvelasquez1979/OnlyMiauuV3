package com.example.onlymiauu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Adopta_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adopta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gran), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Metodo para Evaluar adopciones de gatos
    public String adoptar(Integer cantidad, Integer edad, Boolean trabaja, Float sueldo) {
        String criterio = "";
        switch (cantidad){
            case 1:
                if(edad >= 18 && trabaja){
                    criterio = "Cumple, válido para adoptar 1 gatito";
                }else{
                    criterio = "No cumple, vuelve cuando tengas 18 años y/o cuentes con un trabajo";
                }
                break;
            case 2:
                if(edad >= 18 && trabaja && sueldo >= 600000){
                    criterio = "Cumple, válido para adoptar 2 gatitos";
                }else{
                    criterio = "No cumple, se puede evaluar para adoptar 1 gatito ";
                }
                break;
            default:
                if(edad >= 18 && trabaja && sueldo >= 1800000){
                    criterio = "Cumple, válido para adoptar varios gatitos";
                }else{
                    criterio = "No cumple, se puede evaluar para adoptar menos gatito ";
                }
                break;
        }
        return criterio;
    }

}