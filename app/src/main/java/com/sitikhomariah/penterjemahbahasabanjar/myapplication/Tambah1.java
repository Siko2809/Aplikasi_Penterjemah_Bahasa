package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sitikhomariah.penterjemahbahasabanjar.myapplication.entity.Subjek;

public class Tambah1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah1);

        public boolean insertSubjek(Subjek subjek) {
            String sql = "INSERT INTO SUBJEK('Banjar','Indonesia')VALUES(?,?)";
            Cursor cursor = database.rawQuery(sql, new String[]{subjek.getBanjar(), subjek.getIndonesia()});
            if (cursor.moveToFirst()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
