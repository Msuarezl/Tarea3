package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnEnviar(View view){
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        // Iniciamos la nueva actividad
        startActivity(intent);
    }
    public void btnEnviar2(View view){
        //Creamos el Intent

        Intent intent = new Intent(MainActivity.this, retrofitMostrar.class);
        // Iniciamos la nueva actividad


        startActivity(intent);
    }
}