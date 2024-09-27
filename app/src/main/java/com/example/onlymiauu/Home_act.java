package com.example.onlymiauu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] image = {R.drawable.gt, R.drawable.gto, R.drawable.gtoo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        vf = (ViewFlipper) findViewById(R.id.slider);

        for(int i=0; i<image.length;i++)
        {
            flip_image(image[i]);
        }

    }
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);
        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}