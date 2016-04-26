package br.com.ufpb.rivanildo.meuabc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Rivanildo on 26/04/16.
 */
public class ManagerDB {


    private static Database db = null;


    public ManagerDB(Context context) {
        if(db == null){
            db = new Database(context);
        }
    }

    public void addPath(String titulo, String path){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("titulo", titulo);
        values.put("path", path);

        database.insert("paths", null, values);
        Log.e("lol", "Adicionou");
    }

    public String getPath(String titulo){
        String path = null;
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor cursor = database.query("paths", new String[]{"path"}, "titulo=?", new String[]{titulo}, null, null, null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            path = cursor.getString(0);
        }
        return path;
    }
}
