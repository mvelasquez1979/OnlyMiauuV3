package com.example.onlymiauu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DarAdopcion_act extends AppCompatActivity {

    private Spinner spnSexo, spnEsteril; // INCLUIMOS LAS CLASES DE SPINNER Y TEXTVIEW
    String[] sexos = {"Hembra", "Macho"};
    String[] esteril = {"Sí", "No"};

    private static final int PICK_IMAGE = 50;// Para la carga de la foto
    Uri imageUri;
    ImageView foto_gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dar_adopcion);

        // Iniciar los spinner
        spnSexo = findViewById(R.id.spnSexo);
        spnEsteril = findViewById(R.id.spnEsteril);

        // Crear un ArrayAdapter usando el array de sexos y un layout predeterminado
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, sexos);

        // Crear un ArrayAdapter usando el array de Sí/No y un layout predeterminado
        ArrayAdapter<String> adapterEsteril = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, esteril);

        // Aplicar el adaptador al Spinner de sexo
        spnSexo.setAdapter(adapterSexo);

        // Aplicar el adaptador al Spinner de esteril
        spnEsteril.setAdapter(adapterEsteril);

        // Configurar un Listener para el Spinner de sexo
        spnSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSexo = parent.getItemAtPosition(position).toString();

                // Usando switch para manejar la selección
                switch (selectedSexo) {
                    case "Hembra":
                        Toast.makeText(DarAdopcion_act.this, "Hembra", Toast.LENGTH_SHORT).show();
                        break;
                    case "Macho":
                        Toast.makeText(DarAdopcion_act.this, "Macho", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // Configurar un Listener para el Spinner de Esteril
        spnEsteril.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedEsteril = parent.getItemAtPosition(position).toString();

                // Usando switch para manejar la selección
                switch (selectedEsteril) {
                    case "Sí":
                        Toast.makeText(DarAdopcion_act.this, "Sí", Toast.LENGTH_SHORT).show();
                        break;
                    case "No":
                        Toast.makeText(DarAdopcion_act.this, "No", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        /*super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);*/

        foto_gallery = (ImageView)findViewById(R.id.foto_gallery);

        foto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
        }
    }
}


