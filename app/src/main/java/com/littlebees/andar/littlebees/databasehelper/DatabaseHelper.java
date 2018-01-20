package com.littlebees.andar.littlebees.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andar on 1/18/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper{


    //Database name
    public static final String dbName = "myDatabase.db";



    // table sholat name and columns
    public static final String tbSholat = "tblSholat";
    public static final String COL_SHOLAT1 = "ID";
    public static final String COL_SHOLAT2 = "NAMA_SHOLAT";
    public static final String COL_SHOLAT3 = "STATUS";
    public static final String COL_SHOLAT4 = "NILAI";
    public static final String COL_SHOLAT5 = "TANGGAL";
    public static final String COL_SHOLAT6 = "PUKUL";
    public static final String COL_SHOLAT7 = "TEMPAT";
    public static final String COL_SHOLAT8 = "KUALITAS";
    public static final String COL_SHOLAT9 = "KETERANGAN";


    public DatabaseHelper(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtbSholat = "CREATE TABLE " + tbSholat + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAMA_SHOLAT TEXT, STATUS TEXT, NILAI INTEGER, TANGGAL TEXT, PUKUL TEXT, TEMPAT TEXT, KUALITAS TEXT, KETERANGAN TEXT)";
        db.execSQL(createtbSholat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + tbSholat);
        onCreate(db);
    }
//Add Data
    public boolean addDataTbSholat(String nama_sholat, String status, int nilai, String tanggal, String pukul, String tempat, String kualitas, String keterangan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_SHOLAT2, nama_sholat);
        contentValues.put(COL_SHOLAT3, status);
        contentValues.put(COL_SHOLAT4, nilai);
        contentValues.put(COL_SHOLAT5, tanggal);
        contentValues.put(COL_SHOLAT6, pukul);
        contentValues.put(COL_SHOLAT7, tempat);
        contentValues.put(COL_SHOLAT8, kualitas);
        contentValues.put(COL_SHOLAT9, keterangan);

        long result  = db.insert(tbSholat, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }



}
