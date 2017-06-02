package com.example.nkta_.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.example.nkta_.mascotas.R.id.rvMascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> datos;
    ArrayList<Mascotas> favoritos;
    private RecyclerView vMascota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miaction_bar= (Toolbar)findViewById(R.id.miaction_bar);
        setSupportActionBar(miaction_bar);

        //accedemos a nuestro activity main para usar nuestro recicleview
        vMascota=(RecyclerView)findViewById(rvMascota);

        //queremos un contexto en forma de lista para nuestros datos
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //mi lista de contactos(recicleview) con el metodo setlayoutmanager hara que se comporte como una lista linelayout
        //funciona tanto para el modo linear como para un grid, ""solo cambia la variable llm a glm
        vMascota.setLayoutManager(llm);

        InicializaListaContacto();
        InicializarlistaAdaptador();
    }

    public Adaptador_Mascotas adaptador;
    private void InicializarlistaAdaptador(){
        adaptador=new Adaptador_Mascotas(datos,this);

        /*el recilceview ya contiene el adaptador el cual estara llamando al layout cardview y le pasara los datos de la lista a todos los view
        que el viewholder estara decarando*/

        vMascota.setAdapter(adaptador);
    }

    public void InicializaListaContacto (){

        datos=new ArrayList<Mascotas>();

        datos.add(new Mascotas(R.drawable.masc1,"GoodFriends",0,0));
        datos.add(new Mascotas(R.drawable.masc2,"Slepper",0,0));
        datos.add(new Mascotas(R.drawable.masc3,"excentricos",0,0));
        datos.add(new Mascotas(R.drawable.masc4,"FunnyPlay",0,0));
        datos.add(new Mascotas(R.drawable.masc5,"Rabbit_ft_Dog",0,0));
    }

    public void miestrella (View v){
        favoritos = new ArrayList<Mascotas>();
        Intent intent = new Intent(MainActivity.this, DetalleMascota.class);

        for (Mascotas mascotas: datos){
            if(mascotas.getContador()>0){
                favoritos.add(mascotas);
            }
        }
        intent.putExtra(getResources().getString(R.string.Favoritos),favoritos);
        startActivity(intent);
    }
}
