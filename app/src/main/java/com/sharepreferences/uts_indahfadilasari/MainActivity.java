package com.sharepreferences.uts_indahfadilasari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi Variabel Pendukung
    private TextView Hasil;
    private EditText Masukin;
    private Button Eksekusi;

    //Deklarasi Inisialisasi SharePreferences
    private SharedPreferences preferences;

    //Digunakan untuk konfigurasi sharepreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Masukin = (EditText) findViewById(R.id.Input);
        Hasil = (TextView) findViewById(R.id.output);
        Eksekusi = (Button) findViewById(R.id.save);

        //Membuat File Baru Beserta Modifiernya
        preferences=getSharedPreferences("Belajar_SharePreferences",
                Context.MODE_PRIVATE);

        Eksekusi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData(){
        //Mendapatkan Input dari user
        String getKonten = Masukin.getText().toString();

        //Memasukkan data pada pada editor sharepreferences dengan key(data_saya)
        editor.putString("data_saya",getKonten);

        //menjalankan operasi
        editor.apply();

        //Menampilkan Output
        Hasil.setText("Output Data:"+preferences.getString("data_saya",null));

    }
}