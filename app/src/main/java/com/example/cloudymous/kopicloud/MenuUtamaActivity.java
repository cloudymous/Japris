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

        namaCostumer = getIntent().getExtras().getString("Nama Costumer");
        TextView costumer = findViewById(R.id.namaCostumerPesan);

        costumer.setText("Halo, " + namaCostumer + "!");

    }

    public void teleponKeluarga (View view) {
        Intent teleponKeluarga = new Intent(MenuUtamaActivity.this, MenuTeleponKeluarga.class);
        startActivity(teleponKeluarga);
    }

    public void pesanMakanan (View view) {
        Intent pesanMakanan = new Intent(MenuUtamaActivity.this, MenuPesanMakanan.class);
        startActivity(pesanMakanan);

    }

    public void tentangAplikasi (View view) {
        Intent aboutAplikasi = new Intent(MenuUtamaActivity.this, MenuTentangAplikasi.class);
        startActivity(aboutAplikasi);
    }


}
