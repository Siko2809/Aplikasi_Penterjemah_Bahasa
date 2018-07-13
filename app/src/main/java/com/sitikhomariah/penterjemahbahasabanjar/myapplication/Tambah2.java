package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity.Predikat;

public class Tambah2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah2);

        public boolean insertPredikat(Predikat predikat){
            String sql = "INSERT INTO PREDIKAT('Banjar','Indonesia')VALUES(?,?)";
            Cursor cursor = database.rawQuery(sql, new String[]{predikat.getBanjar(), predikat.getIndonesia()});
            if (cursor.moveToFirst()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
