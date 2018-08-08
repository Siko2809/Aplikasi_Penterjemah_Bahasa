package com.sitikhomariah.penterjemahbahasabanjar.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Admin {
    public static final String SP_ANTRIAN_APP = "spAntrianApp";

    public static final String DB1 = "db1";
    public static final String DB2 = "db2";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public Admin(Context context){
        sp = context.getSharedPreferences(SP_ANTRIAN_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }


    public int getDbStatus1(){
        return sp.getInt(DB1, 0);
    }

    public void setDbStatus1(int value){
        spEditor.putInt(DB1, value);
        spEditor.commit();
    }

    public int getDbStatus2(){
        return sp.getInt(DB2, 0);
    }

    public void setDbStatus2(int value){
        spEditor.putInt(DB2, value);
        spEditor.commit();
    }
}
