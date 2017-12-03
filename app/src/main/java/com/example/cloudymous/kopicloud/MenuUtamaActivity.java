package com.example.cloudymous.kopicloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuUtamaActivity extends Activity {

    private String namaCostumer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_utama);

        namaCostumer = getIntent().getExtras().getString("Nama Costumer"));
        TextView costumer = findViewById(R.id.namaCostumerPesan);

        costumer.setText("Halo, " + namaCostumer + "! Mau ngapain?");

    }

    public void teleponKeluarga (View view) {
        Intent teleponKeluarga = new Intent();
    }


}
