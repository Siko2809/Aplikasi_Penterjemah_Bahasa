package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity.Subjek;

public class Tambah1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah1);

        final EditText indonesia = (EditText) findViewById(R.id.editText_indonesia);
        final EditText banjar = (EditText) findViewById(R.id.editText_banjar);
        Button buttonSave = (Button) findViewById(R.id.button);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(indonesia.getText()) || TextUtils.isEmpty(banjar.getText())) {
                    Toast.makeText(getApplicationContext(), "field tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Subjek subjek = new Subjek();
                    subjek.setBanjar(banjar.getText().toString());
                    subjek.setIndonesia(indonesia.getText().toString());

                    boolean result = DatabaseAccess.getInstance(getApplicationContext()).insertSubjek(subjek);
                    if (result) {
                        Toast.makeText(getApplicationContext(), "Berhasil disimpan!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Gagal disimpan!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
