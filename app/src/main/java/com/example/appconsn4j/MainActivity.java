package com.example.appconsn4j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appconsn4j.logica.RetrofitClient;
import com.example.appconsn4j.model.Filme;
import com.example.appconsn4j.services.FilmeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAll(null);
    }

    public void getAll(View view){
        FilmeService service = RetrofitClient.getRetrofitInstance()
                .create(FilmeService.class);
        Call<List<Filme>> call = service.getFilmes();
        call.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                //Toast.makeText(MainActivity.this, "filmes = " + response.body().size(), Toast.LENGTH_LONG).show();
                List<Filme> listafilme = response.body();
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listafilme);
                ((ListView)findViewById(R.id.lista)).setAdapter(arrayAdapter);
                ((ListView)findViewById(R.id.lista)).setOnItemClickListener((parent, view1, position, id) -> {
                    Toast.makeText(MainActivity.this, "-> " + listafilme.get(position), Toast.LENGTH_LONG).show();
                });
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERRO " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getPage(View view){
        FilmeService service = RetrofitClient.getRetrofitInstance()
                .create(FilmeService.class);
        Call<HashMap> call = service.getFilmes(1,1);
        call.enqueue(new Callback<HashMap>() {
            @Override
            public void onResponse(Call<HashMap> call, Response<HashMap> response) {
                Toast.makeText(MainActivity.this, "filme = " +
                                ((Map)((List)response.body().get("content")).get(0)).get("nome")
                        , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<HashMap> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERRO " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}