package com.example.cloudymous.kopicloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeScreen extends Activity {

    private EditText namaCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        namaCost = findViewById(R.id.namaCostumerEt);

    }

    public void submitNama(View view) {
        String costumer =namaCost.getText().toString();
        if (costumer.isEmpty()) {
            Toast.makeText(HomeScreen.this, getString(R.string.warn_insert_name), Toast.LENGTH_SHORT).show();
        } else {
            Intent orderHomeIntent = new Intent(HomeScreen.this, MenuUtamaActivity.class);
            orderHomeIntent.putExtra("Nama Costumer", costumer);
            startActivity(orderHomeIntent);
        }

    }
}
