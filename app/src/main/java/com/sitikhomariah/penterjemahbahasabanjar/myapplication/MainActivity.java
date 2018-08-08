package com.sitikhomariah.penterjemahbahasabanjar.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonKAMUS;
    private Button buttontentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halamanutama);

        buttonKAMUS = (Button) findViewById(R.id.kamus);
        buttonKAMUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HalamanUtama2Activity.class);
                startActivity(intent);
            }
        });

        buttontentang = (Button) findViewById(R.id.tentang);
        buttontentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TentangActivity.class);
                startActivity(intent);
            }
        });

    }
    }


