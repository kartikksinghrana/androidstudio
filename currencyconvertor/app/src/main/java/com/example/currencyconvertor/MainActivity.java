package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     public void convert(View view)
        {
            double dollars;
            EditText amount =(EditText) findViewById(R.id.amount);
            String amountinrupees= amount.getText().toString();
            double rupees = Double.parseDouble(amountinrupees);
            dollars = rupees * 0.014;
            Toast.makeText(this ,   dollars+"$$", Toast.LENGTH_SHORT).show();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}