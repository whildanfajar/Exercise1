package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama,tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKotak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        switch (nama)
        {
            case "Beni":
                tvnama.setText("Beni");
                tvnomor.setText("082378557815");
                break;
            case "Dita":
                tvnama.setText("Dita");
                tvnomor.setText("082378557815");
                break;
            case "Rubi":
                tvnama.setText("Rubi");
                tvnomor.setText("082378557815");
                break;
            case "Agil":
                tvnama.setText("Agil");
                tvnomor.setText("082378557815");
                break;
            case "Luki":
                tvnama.setText("Luki");
                tvnomor.setText("082378557815");
                break;
            case "Alin":
                tvnama.setText("Alin");
                tvnomor.setText("082378557815");
                break;
            case "Yuzi":
                tvnama.setText("Yuzi");
                tvnomor.setText("082378557815");
                break;
        }
    }
}