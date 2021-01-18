package com.appmovil.whatsappsinterfaz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;
    Button btnchats;
    Button btnestados;
    Button btnllamadas;
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        btnchats = (Button) findViewById(R.id.btnChats);
        btnestados = (Button) findViewById(R.id.btnEstados);
        btnllamadas = (Button) findViewById(R.id.btnLlamadas);
        setSupportActionBar(toolbar);
        Fragment fragment = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        n=0;
       /* getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconmenu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);*/
    }
    public void btnChats(View view)
    {
        Menu menu = toolbar.getMenu();
        menu.clear();
        getMenuInflater().inflate(R.menu.mnutoolbar , menu);
        Fragment fragment = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
         btnchats.setTextColor(getResources().getColor(R.color.white));
         btnestados.setTextColor(getResources().getColor(R.color.white2));
         btnllamadas.setTextColor(getResources().getColor(R.color.white2));
    }
    public void btnEstados(View view)
    {
        Menu menu = toolbar.getMenu();
        menu.clear();
        getMenuInflater().inflate(R.menu.menufrag2 , menu);
        Fragment fragment = new Fragment2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        btnchats.setTextColor(getResources().getColor(R.color.white2));
        btnestados.setTextColor(getResources().getColor(R.color.white));
        btnllamadas.setTextColor(getResources().getColor(R.color.white2));
    }
    public void btnLlamadas(View view)
    {
        Menu menu = toolbar.getMenu();
        menu.clear();
        getMenuInflater().inflate(R.menu.menufrag3 , menu);
        Fragment fragment = new Fragment3();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        btnchats.setTextColor(getResources().getColor(R.color.white2));
        btnestados.setTextColor(getResources().getColor(R.color.white2));
        btnllamadas.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.mnutoolbar , menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity2.this, MainActivityAjustes.class);
        if(item.getItemId()==R.id.mnuAjustes || item.getItemId()==R.id.mnuAjustesf2 || item.getItemId()==R.id.mnuAjustesf3){
            startActivity(intent);
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }

      /*  switch (item.getItemId()) {
            case R.id.mnuAjustes:

                return true;
            case R.id.mnuAjustesf2:

                return true;
            case R.id.mnuAjustesf3:

                return true;
            default:

                return super.onOptionsItemSelected(item);
        }*/
    }
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
          }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_seccion_1:
                fragment = new Fragment1();
               fragmentTransaction = true;
                break;
            case R.id.menu_seccion_2:
                fragment = new Fragment2();
                fragmentTransaction = true;
                break;
            case R.id.menu_seccion_3:
                fragment = new Fragment3();
                fragmentTransaction = true;
                break;

        }

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit();
        }



        drawerLayout.closeDrawers();
        return true;

    }

    */

}