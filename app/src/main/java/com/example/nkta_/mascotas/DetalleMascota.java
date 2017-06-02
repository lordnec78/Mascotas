package com.example.nkta_.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by nkta_ on 31/05/2017.
 */
public class DetalleMascota extends AppCompatActivity {

    ArrayList<Mascotas> mascotasselect;
    private RecyclerView favoritos;


    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.mascota_detalle);

        Toolbar miaction_bar= (Toolbar)findViewById(R.id.miaction_bar);
        setSupportActionBar(miaction_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        favoritos=(RecyclerView)findViewById(R.id.mascotalike);

        LinearLayoutManager ll=new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        favoritos.setLayoutManager(ll);

        Bundle parametros = getIntent().getExtras();

        mascotasselect=(ArrayList<Mascotas>) parametros.get(getResources().getString(R.string.Favoritos));
        Adaptador_Mascotas adaptador= new Adaptador_Mascotas(mascotasselect,this);
        favoritos.setAdapter(adaptador);


    }

}
