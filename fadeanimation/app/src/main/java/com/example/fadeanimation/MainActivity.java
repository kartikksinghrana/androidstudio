package com.example.fadeanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int m=0,n=1,t;
    public void fade (View view)
    {

        ImageView img1= (ImageView)findViewById(R.id.dance);
        ImageView img2= (ImageView)findViewById(R.id.classic);
        t=m;
        m=n;
        n=t;
        img1.animate().alpha(m).setDuration(2000);
        img2.animate().alpha(n).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}