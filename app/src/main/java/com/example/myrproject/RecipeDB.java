package com.example.myrproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecipeDB extends SQLiteOpenHelper {
    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "data3.db";

    public RecipeDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Cooking (id INTEGER PRIMARY KEY AUTOINCREMENT, food TEXT NOT NULL, info TEXT NOT NULL, type TEXT NOT NULL, name TEXT NOT NULL, cnt TEXT NOT NULL, unit Text NOT NULL, writedate TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        onCreate(db);
    }

    public String getCookItem(String _food) {
        SQLiteDatabase db = getReadableDatabase();//조회 다른것과 다르다 읽는 행위
        Cursor cursor = db.rawQuery("SELECT * FROM Cooking WHERE food = '" + _food + "'", null);
        String type = "없어요";
        if (cursor.getCount() != 0) {
            cursor.moveToNext();
            type = cursor.getString(3);
        }
        cursor.close();
        return type;//담아놓은 것을 언제 어디든 호출 가능
    }

    public ArrayList<MyRItem> getCookItemType(String _type) {
        ArrayList<MyRItem> rItems = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();//조회 다른것과 다르다 읽는 행위
        Cursor cursor = db.rawQuery("SELECT * FROM Cooking WHERE type = '" + _type + "'", null);

        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);//id라는 항목을 실제 sq테이블 id index에 맞춰서 실제 id로 넘겨져온 값을 받아온다
                String food = cursor.getString(1);
                String info = cursor.getString(2);
                String type = cursor.getString(3);
                String name = cursor.getString(4);
                String cnt = cursor.getString(5);
                if((int)Double.parseDouble(cnt)-Double.parseDouble(cnt)==0){
                    cnt = Integer.toString((int)Double.parseDouble(cnt));
                }
                String unit = cursor.getString(6);
                String writedate = cursor.getString(7);

                MyRItem rItem = new MyRItem();
                rItem.setId(id);
                rItem.setFood(food);
                rItem.setInfo(info);
                rItem.setType(type);
                rItem.setName(name);
                rItem.setCnt(cnt);
                rItem.setUnit(unit);
                rItem.setWriteDate(writedate);
                rItems.add(rItem);
            }
        }
        cursor.close();
        return rItems;//담아놓은 것을 언제 어디든 호출 가능
    }


    public ArrayList<String> search(String keyword) {
        ArrayList<String> contacts = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT DISTINCT food from Cooking where food like ?", new String[] { "%" + keyword + "%" });
            if (cursor.moveToFirst()) {
                do {
                    String a = cursor.getString(0);
                    contacts.add(a);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            contacts = null;
        }
        return contacts;
    }

    public ArrayList<String> getCookName() {
        ArrayList<String> rItems = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();//조회 다른것과 다르다 읽는 행위
        Cursor cursor = db.rawQuery("SELECT DISTINCT food FROM Cooking",null);

        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                String food = cursor.getString(0);
                rItems.add(food);
            }
        }
        cursor.close();
        return rItems;//담아놓은 것을 언제 어디든 호출 가능
    }

    public String getCookInfo(String _food) {
        ArrayList<String> rItems = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();//조회 다른것과 다르다 읽는 행위
        Cursor cursor = db.rawQuery("SELECT info FROM Cooking WHERE food = '"+_food+"'",null);
        String x = "레시피 설명을 적어주세요.";

        if (cursor.getCount() != 0) {
            cursor.moveToNext();
            x = cursor.getString(0);
        }
        cursor.close();
        return x;//담아놓은 것을 언제 어디든 호출 가능
    }


    public void InsertCook(String _food, String _info, String _type, String _name, String _cnt, String _unit,String _writedate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Cooking(food, info, type,name,cnt,unit,writedate) VALUES('"+_food+"','"+_info+"','"+_type+"','"+_name+"','"+_cnt+"','"+_unit+"','"+_writedate+"');");
    }

    public void InsertCookItem(String _food, String _info, String _type, String _name, String _cnt, String _unit,String _writedate){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Cooking WHERE type = '"+_type+"' AND name = '"+ _name +"'",null);
        if(cursor.getCount()<=0){
            InsertCook(_food,_info,_type,_name,_cnt,_unit,_writedate);
        }
        else{
            if(cursor.moveToFirst()){
                int id = cursor.getInt(0);
                String itemcnt = cursor.getString(5);
                String itemunit = cursor.getString(6);
                String _beforedate = cursor.getString(7);
                UpdateCook(id, Double.toString(Double.parseDouble(itemcnt)+1),itemunit,_writedate,_beforedate);
            }
        }
        cursor.close();
    }


    public void UpdateCook(int _id, String _cnt, String _unit,String _writedate, String _beforeDate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Cooking SET cnt = '"+_cnt+"',unit = '"+_unit+"',writedate='"+_writedate+"'WHERE writedate='"+_beforeDate+"' AND id = '"+_id+"'");
    }

    public void UpdateOk(String _food, String _info,String _type){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Cooking SET food = '"+_food+"',info = '"+_info+"' WHERE type = '"+_type+"'");
    }

    public void DeleteCook(String _writedate){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Cooking WHERE writedate = '"+_writedate+"'");
    }

    public void DeleteCookName(String _food){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Cooking WHERE food = '"+_food+"'");
    }


    public int getNum(){
        SQLiteDatabase db = getReadableDatabase();//조회 다른것과 다르다 읽는 행위
        Cursor cursor = db.rawQuery("SELECT id FROM Cooking",null);
        cursor.moveToLast();
        int a;
        if(cursor.getCount()!=0){
            a = cursor.getInt(0);
            a+=3;
        }
        else{
            a=-2;
        }
        return a;
    }

}