package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        Admin admin = new Admin(this);
        Log.d("test", admin.getDbStatus1()+"");
        if (admin.getDbStatus1() == 0 || admin.getDbStatus2() == 0){
            admin.setDbStatus1(DatabaseAccess.sqlSubjek.length());
            admin.setDbStatus2(DatabaseAccess.sqlPredikat.length());

            databaseAccess.insertSubjek();
            databaseAccess.insertPredikat();
            Log.d("test", "test");


        }
        Log.d("test", admin.getDbStatus1()+"");



        if (admin.getDbStatus1() != DatabaseAccess.sqlSubjek.length()){
            admin.setDbStatus1(DatabaseAccess.sqlSubjek.length());
            databaseAccess.insertSubjek();
            Log.d("test1", "test1");
        }

        if (admin.getDbStatus2() != DatabaseAccess.sqlPredikat.length()){
            admin.setDbStatus2(DatabaseAccess.sqlPredikat.length());
            databaseAccess.insertPredikat();
            Log.d("test2", "test2");
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}
