package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        textViewBahasa1 = (TextView)findViewById(R.id.bahasa1);
        textViewBahasa2 = (TextView)findViewById(R.id.bahasa2);
        textViewarti1 = (TextView)findViewById(R.id.arti1);
        editTextkata1 = (EditText)findViewById(R.id.kata1);
        imageViewpanah1 = (ImageView)findViewById(R.id.panah1);
        imageViewpanah2 = (ImageView)findViewById(R.id.panah2);
        imageViewsuara = (ImageView)findViewById(R.id.suara);

        imageViewpanah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textViewBahasa1.getText().equals("Indonesia")){
                    textViewBahasa1.setText("Banjar");
                    textViewBahasa2.setText("Indonesia");
                }else  {
                    textViewBahasa1.setText("Indonesia");
                    textViewBahasa2.setText("Banjar");
                }
            }
        });

        final EditText inputText = (EditText) findViewById(R.id.kata1);
        imageViewpanah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               textViewarti1.setText(editTextkata1.getText());
            }
        });
        String input = inputText.getText().toString();


    }
}
