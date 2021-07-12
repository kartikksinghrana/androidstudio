package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void guessbutton (View view){

        EditText number  = (EditText) findViewById(R.id.guessed);
        int guessednumber =Integer.parseInt(number.getText().toString());


        if (randomNumber>guessednumber)
        {
            Toast.makeText(this, "try higher", Toast.LENGTH_SHORT).show();
        }
        else if (randomNumber<guessednumber)
        {
            Toast.makeText(this, "try lower", Toast.LENGTH_SHORT).show();
        }
        else if(randomNumber==guessednumber) {
            Toast.makeText(this, "you guessed the right number " + randomNumber, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, " TRY AGAIN", Toast.LENGTH_SHORT).show();
            randomnumbergenerator();
        }


    }

    private void randomnumbergenerator() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}