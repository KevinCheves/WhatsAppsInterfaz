package com.appmovil.whatsappsinterfaz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.appmovil.whatsappsinterfaz.WebService.Asynchtask;

import org.json.JSONException;

public class MainActivityAjustes extends AppCompatActivity implements Asynchtask {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ajustes);

    }
    public void btnBack(View view){
        Intent intent = new Intent(MainActivityAjustes.this, MainActivity2.class);
        startActivity(intent);
    }
    @Override
    public void processFinish(String result) throws JSONException {


    }
}