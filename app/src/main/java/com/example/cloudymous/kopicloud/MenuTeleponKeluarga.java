package com.example.cloudymous.kopicloud;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuTeleponKeluarga extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_telepon_keluarga);

        Boolean checkEditableText = getIntent().hasExtra("New Nama Keluarga");
        if (checkEditableText) {
            String namaKeluarga = getIntent().getExtras().getString("New Nama Keluarga");
            String nomorKeluarga = getIntent().getExtras().getString("New Nomor Keluarga");

            TextView namaTV = findViewById(R.id.nama);
            TextView nomorTV = findViewById(R.id.nomor);

            namaTV.setText(namaKeluarga);
            nomorTV.setText(nomorKeluarga);
        }
    }

    public void telepon(View view) {
        TextView nomorTV = findViewById(R.id.nomor);
        String nomor = nomorTV.getText().toString();

        if (nomor.isEmpty()) {
            Toast.makeText(MenuTeleponKeluarga.this, getString(R.string.warn_insert_name), Toast.LENGTH_SHORT).show();
        } else {
            Intent teleponAyah = new Intent(Intent.ACTION_DIAL);
            teleponAyah.setData(Uri.parse("tel:" + nomor));
            if (teleponAyah.resolveActivity(getPackageManager()) != null) {
                startActivity(teleponAyah);
            }
        }
    }

    public void editNomorButton(View view) {
        Intent EditNomorIntent = new Intent(MenuTeleponKeluarga.this, MenuEditNomorKeluarga.class);
        startActivity(EditNomorIntent);
    }
}
