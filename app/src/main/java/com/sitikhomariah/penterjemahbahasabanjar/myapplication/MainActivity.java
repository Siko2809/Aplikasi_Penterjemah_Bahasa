package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity.Predikat;
import com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity.Subjek;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    private TextView textViewBahasa1;
    private TextView textViewBahasa2;
    private TextView textViewarti1;
    private EditText editTextkata1;
    private ImageView imageViewpanah1;
    private ImageView imageViewpanah2;
    private ImageView imageViewsuara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        textViewBahasa1 = (TextView) findViewById(R.id.bahasa1);
        textViewBahasa2 = (TextView) findViewById(R.id.bahasa2);
        textViewarti1 = (TextView) findViewById(R.id.arti1);
        editTextkata1 = (EditText) findViewById(R.id.kata1);
        imageViewpanah1 = (ImageView) findViewById(R.id.panah1);
        imageViewpanah2 = (ImageView) findViewById(R.id.panah2);
        imageViewsuara = (ImageView) findViewById(R.id.suara);

        imageViewpanah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewBahasa1.getText().equals("Indonesia")) {
                    textViewBahasa1.setText("Banjar");
                    textViewBahasa2.setText("Indonesia");
                } else {
                    textViewBahasa1.setText("Indonesia");
                    textViewBahasa2.setText("Banjar");
                }
            }
        });

        final EditText inputText = (EditText) findViewById(R.id.kata1);
        imageViewpanah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hasil = "";
                String[] katas = editTextkata1.getText().toString().split(" ");


                if (textViewBahasa1.getText().equals("Indonesia")) {
                    if (katas.length == 2) {

//                        kata ke 1
                        List<Subjek> subjekKata1 = databaseAccess.cekSubjekIndonesia(katas[0]);
                        List<Predikat> predikatKata1 = databaseAccess.cekPredikatIndonesia(katas[0]);
                        if (!subjekKata1.isEmpty()) {
                            hasil = subjekKata1.get(0).getBanjar();
                        } else if (!predikatKata1.isEmpty()) {
                            hasil = predikatKata1.get(0).getBanjar();
                        }


//                        kata ke 2
                        List<Subjek> subjekKata2 = databaseAccess.cekSubjekIndonesia(katas[1]);
                        List<Predikat> predikatKata2 = databaseAccess.cekPredikatIndonesia(katas[1]);
                        if (!subjekKata2.isEmpty()) {
                            hasil = hasil + " " + subjekKata2.get(0).getBanjar();
                        } else if (!predikatKata2.isEmpty()) {
                            hasil = hasil + " " + predikatKata2.get(0).getBanjar();
                        }


                    } else {

//                      kata ke 1
                        List<Subjek> subjekKata1 = databaseAccess.cekSubjekIndonesia(katas[0]);
                        List<Predikat> predikatKata1 = databaseAccess.cekPredikatIndonesia(katas[0]);
                        if (!subjekKata1.isEmpty()) {
                            hasil = subjekKata1.get(0).getBanjar();
                        } else if (!predikatKata1.isEmpty()) {
                            hasil = predikatKata1.get(0).getBanjar();
                        }


                    }
                } else {

                    if (katas.length == 2) {

//                        kata ke 1
                        List<Subjek> subjekKata1 = databaseAccess.cekSubjekBanjar(katas[0]);
                        List<Predikat> predikatKata1 = databaseAccess.cekPredikatBanjar(katas[0]);
                        if (!subjekKata1.isEmpty()) {
                            hasil = subjekKata1.get(0).getBanjar();
                        } else if (!predikatKata1.isEmpty()) {
                            hasil = predikatKata1.get(0).getBanjar();
                        }


//                        kata ke 2
                        List<Subjek> subjekKata2 = databaseAccess.cekSubjekBanjar(katas[1]);
                        List<Predikat> predikatKata2 = databaseAccess.cekPredikatBanjar(katas[1]);
                        if (!subjekKata2.isEmpty()) {
                            hasil = hasil + " " + subjekKata2.get(0).getBanjar();
                        } else if (!predikatKata2.isEmpty()) {
                            hasil = hasil + " " + predikatKata2.get(0).getBanjar();
                        }


                    } else {

//                      kata ke 1
                        List<Subjek> subjekKata1 = databaseAccess.cekSubjekBanjar(katas[0]);
                        List<Predikat> predikatKata1 = databaseAccess.cekPredikatBanjar(katas[0]);
                        if (!subjekKata1.isEmpty()) {
                            hasil = subjekKata1.get(0).getBanjar();
                        } else if (!predikatKata1.isEmpty()) {
                            hasil = predikatKata1.get(0).getBanjar();
                        }


                    }
                }


                textViewarti1.setText(hasil);
            }
        });


        String input = inputText.getText().toString();
    }
}
