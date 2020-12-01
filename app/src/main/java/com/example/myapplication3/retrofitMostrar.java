package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication3.Retrofit.Bancos;
import com.example.myapplication3.Retrofit.InterfaceU;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class retrofitMostrar extends AppCompatActivity {
    private TextView txtListBanco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_mostrar);
        txtListBanco = findViewById(R.id.txtmultline);
        getBanco();
    }
    private void getBanco(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-uat.kushkipagos.com/transfer-subscriptions/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceU interfaceU = retrofit.create(InterfaceU.class);

        Call<List<Bancos>> call = interfaceU.getBancos();

        call.enqueue(new Callback<List<Bancos>>() {
            @Override
            public void onResponse(Call<List<Bancos>> call, Response<List<Bancos>> response) {

                if(!response.isSuccessful()){
                    txtListBanco.setText("Codigo: "+response.code());
                    return;
                }

                List<Bancos> bancosList = response.body();
                String content = "";
                for(Bancos post: bancosList){
                    content=content+post.getName() +"\n";
                }
                txtListBanco.setText(content);

            }

            @Override
            public void onFailure(Call<List<Bancos>> call, Throwable t) {
                txtListBanco.setText(t.getMessage());

            }
        });

    }
}