package com.example.thales.listacarro;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thales on 26/10/2017.
 */

public class CarroAdapter extends BaseAdapter {

    private List<Carro> carros;
    private Activity activity;

    public CarroAdapter(List<Carro> tarefas, Activity activity) {
        this.carros = tarefas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        if(v == null) {
            v = this.activity.getLayoutInflater().inflate(R.layout.visualizacao, null);
        }
        Carro carro = carros.get(position);

        ImageView imagem = (ImageView) v.findViewById(R.id.imageView);
        Bitmap bitmap = buscaImagem(carro.getUrlFoto());
        imagem.setImageBitmap(bitmap);

        TextView nome = (TextView)v.findViewById(R.id.txtNomeCarro);
        nome.setText(carro.getNome());

        TextView latitude = (TextView)v.findViewById(R.id.txtLatitude);
        latitude.setText(carro.getLatitude());

        TextView longitude = (TextView)v.findViewById(R.id.txtLongitude);
        longitude.setText(carro.getLongitude());

        return v;
    }

    Bitmap buscaImagem(String ender){
        return null;
    }

   public class BuscaDadosRede extends AsyncTask<URL, Void, ArrayList>{

        //Método que executa a Thread em segundo plano
        public ArrayList<Carro> doInBackground(URL... urls) {
            return null;
        }
    }
    //Método que executa após a conclusão da Thread
    //Código chamado já na Thread principal
    public void onPostExecute (ArrayList<Carro> Carro){

    }
}