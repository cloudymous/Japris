package com.example.cloudymous.kopicloud;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MenuPesanMakanan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pesan_makanan);

        /**
         * Deklarasikan variable checkbox
         */
    }

    public void orderPesanan (View view) {

        CheckBox pesanNasiUdukCB = findViewById(R.id.nasiUduk);
        CheckBox pesanNasiGorengCB = findViewById(R.id.nasiGoreng);
        CheckBox pesanMieKuahCB = findViewById(R.id.mieKuah);
        CheckBox pesanMieGorengCB = findViewById(R.id.mieGoreng);

        Boolean pesanNasiUduk = pesanNasiUdukCB.isChecked();
        Boolean pesanNasiGoreng = pesanNasiGorengCB.isChecked();
        Boolean pesanMieKuah = pesanMieKuahCB.isChecked();
        Boolean pesanMieGoreng = pesanMieGorengCB.isChecked();

        EditText pesananNasiUdukValue = findViewById(R.id.nasiUdukValue);
        EditText pesananNasiGorengValue = findViewById(R.id.nasiGorengValue);
        EditText pesananMieKuahValue = findViewById(R.id.mieKuahValue);
        EditText pesananMieGorengValue = findViewById(R.id.mieGorengValue);

        String orderan = "Halo, Japris saya mau pesan : \n ";

        if (pesanNasiUduk) {
            orderan += "\n" + pesanNasiUdukCB.getText().toString() + "\t \t \t" + pesananNasiUdukValue.getText().toString();
        }

        if (pesanNasiGoreng) {
            orderan += "\n" + pesanNasiGorengCB.getText().toString() + "\t \t \t" + pesananNasiGorengValue.getText().toString();
        }

        if (pesanMieKuah) {
            orderan += "\n" + pesanMieKuahCB.getText().toString() + "\t \t \t" + pesananMieKuahValue.getText().toString();
        }

        if (pesanMieGoreng) {
            orderan += "\n" + pesanMieGorengCB.getText().toString() + "\t \t \t" + pesananMieGorengValue.getText().toString();
        }

        displayHasilOrderan(orderan);

    }

    public void kirimPesanan (View view) {
        TextView hasilOrderan = findViewById(R.id.hasilOrderan);
        String orderan = hasilOrderan.getText().toString();
        orderan += "\n\n\n\nby Bukan Aplikasi Gojek"  ;
        Intent sendToEmail = new Intent(Intent.ACTION_SENDTO);
        sendToEmail.setType("text/html");
        sendToEmail.setData(Uri.parse("mailto:"));
        sendToEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"Pelayan Japris"} );
        sendToEmail.putExtra(Intent.EXTRA_SUBJECT, "Pesanan Makanan");
        sendToEmail.putExtra(Intent.EXTRA_TEXT, orderan);
        if (sendToEmail.resolveActivity(getPackageManager()) != null) {
            startActivity(sendToEmail);
        }

    }

//    public String sendPesananan (String pesanan) {
//        String hasilPesanan = pesanan;
//        return hasilPesanan;
//
//    }
//
    public void displayHasilOrderan (String pesanan) {
        TextView hasilOrderan = findViewById(R.id.hasilOrderan);
        hasilOrderan.setText(pesanan);
    }

    public void resetOrderan (View view) {
        TextView hasilOrderan = findViewById(R.id.hasilOrderan);
        hasilOrderan.setText("");
    }

}
