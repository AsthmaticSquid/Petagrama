package com.calamarasmtic.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.calamarasmtic.petagram.adapter.MascotFavAdaptor;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.calamarasmtic.petagram.presentador.ActivityFavoritoMascotasPresenter;
import com.calamarasmtic.petagram.presentador.IActivityFavoritoMascotasPresenter;

import java.util.ArrayList;

public class ActivityFavoritoMascotas extends AppCompatActivity implements IActivityFavoritoMascotas{

    ArrayList<Mascota> m;
    private RecyclerView lm;
    private IActivityFavoritoMascotasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_mascotas);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        if(miToolBar != null){
            setSupportActionBar(miToolBar);
        }

        lm = (RecyclerView) findViewById(R.id.rvFavMascotas);
        presenter = new ActivityFavoritoMascotasPresenter(this, this);


    }

    /*public void inicializarListaMascotas(){
        m = new ArrayList<Mascota>();
        m.add(new Mascota(R.drawable.ca, "Duff", 1));
        m.add(new Mascota(R.drawable.gat, "Nermal", 1));
        m.add(new Mascota(R.drawable.lloro, "Wings", 1));
        m.add(new Mascota(R.drawable.zoid, "Mister Zoid", 5));
        m.add(new Mascota(R.drawable.pandaaligator, "Bear", 4));
    }*/


    public void goToMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lm.setLayoutManager(llm);
    }

    @Override
    public MascotFavAdaptor crearAdaptador(ArrayList<Mascota> pets) {
        MascotFavAdaptor adaptador = new MascotFavAdaptor (pets, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotFavAdaptor adaptador) {
        lm.setAdapter(adaptador);
    }
}
