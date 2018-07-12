package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tambah extends AppCompatActivity {

    private Button buttonSubjek;
    private Button buttonPredikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        buttonSubjek = (Button)findViewById(R.id.subjek1);
        buttonSubjek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tambah.this, Tambah1.class);
                startActivity((intent));
            }
        });

        buttonPredikat = (Button)findViewById(R.id.predikat);
        buttonPredikat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tambah.this, Tambah2.class);
                startActivity((intent));
            }
        });
    }
}
