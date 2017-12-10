package com.example.cloudymous.kopicloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MenuEditNomorKeluarga extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nomor_keluarga);
    }

    public void editNomorKeluarga (View view) {
        EditText namaKeluarga = (EditText) findViewById(R.id.newFamilyName);
        EditText nomorKeluarga = (EditText) findViewById(R.id.newPhoneNumber);

        String newNamaKeluarga = namaKeluarga.getText().toString();
        String newNomorKeluarga = nomorKeluarga.getText().toString();

        if (newNamaKeluarga.isEmpty() || newNomorKeluarga.isEmpty()) {
            Toast.makeText(MenuEditNomorKeluarga.this, getString(R.string.warn_insert_name), Toast.LENGTH_SHORT).show();
        } else {

            Intent newKeluarga = new Intent(MenuEditNomorKeluarga.this, MenuTeleponKeluarga.class);
            newKeluarga.putExtra("New Nama Keluarga", newNamaKeluarga);
            newKeluarga.putExtra("New Nomor Keluarga", newNomorKeluarga);

            startActivity(newKeluarga);
        }
    }
}
