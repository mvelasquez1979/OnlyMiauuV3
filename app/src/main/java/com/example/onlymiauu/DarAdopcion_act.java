package com.example.onlymiauu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.airbnb.lottie.LottieAnimationView;

public class DarAdopcion_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dar_adopcion);


        LottieAnimationView animationView = findViewById(R.id.animationView);
        animationView.setAnimation(R.raw.animation);






    }
}