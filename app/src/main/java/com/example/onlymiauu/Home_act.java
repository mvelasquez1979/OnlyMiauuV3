package com.example.onlymiauu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Home_act extends AppCompatActivity {


    Button btnAdopt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        //Animacion del gato en caja de la activity home
        LottieAnimationView animationView = findViewById(R.id.animationView);
        animationView.setAnimation(R.raw.animation);
        animationView.setSpeed(0.3f); //Control de velocidad-cambia 0.3 por el factor que desees (menor a 1 es más lento)

        btnAdopt = findViewById(R.id.btnAdopt);

        btnAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Home_act.this,Adopta_act.class);
                startActivity(intent);
                overridePendingTransition(R.anim.derechaanima, R.anim.izquierdaanima);
            }




        });










    }

}