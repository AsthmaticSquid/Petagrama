package com.calamarasmtic.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.adapter.PageAdapter;
import com.calamarasmtic.petagram.fragments.PerFragment;
import com.calamarasmtic.petagram.fragments.RecyclerViewFragment;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

//import static com.calamarasmtic.petagram.R.id.rvMascotas;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaPets;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miToolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }



        /*listaPets = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent a = new Intent(this, ActivityAbout.class);
                startActivity(a);
                break;

            case R.id.mContacto:
                Intent b = new Intent(this, ActivityContact.class);
                startActivity(b);
                break;

            case R.id.mFavoritos:
                Intent c = new Intent(this, ActivityFavoritoMascotas.class);
                startActivity(c);
                break;

            case R.id.mCuenta:
                Intent d = new Intent(this,  ActivityCrearCuenta.class);
                startActivity(d);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public MascotAdaptor adaptador;



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pethouse);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_petprofile);
    }

    /*public void goToFavs(View v){
        Intent i = new Intent(this, ActivityFavoritoMascotas.class);
        startActivity(i);
    }*/

}
