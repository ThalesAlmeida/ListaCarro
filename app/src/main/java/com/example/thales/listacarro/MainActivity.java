package com.example.thales.listacarro;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuscaDadosRede buscaDadosRede = new BuscaDadosRede();
        try{
            buscaDadosRede.execute(new URL("http://www.livroandroid.com.br/livro/carros/v2/carros_classicos.json"));
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }

}

class BuscaDadosRede extends AsyncTask<URL, Void, ArrayList> {

    //Método que executa a Thread em segundo plano
    public ArrayList<Carro> doInBackground(URL... urls) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(urls[0]).build();

        try{
            Response response = client.newCall(request).execute();
            String teste = response.body().string();
            teste += "";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void onPostExecute (ArrayList<Carro> Carro){

    }
}
