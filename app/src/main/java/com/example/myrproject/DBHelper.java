package com.example.myrproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "냉장고.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //데이터 베이스가 생성될 때 호출
        //데이터 베이스 -> 테이블 -> 컬럼 -> 값
        db.execSQL("CREATE TABLE IF NOT EXISTS refrigerator(id INTEGER PRIMARY KEY AUTOINCREMENT, loc TEXT NOT NULL, type TEXT NOT NULL, name TEXT NOT NULL)");
        //primary key -> 데이터 베이스 안의 값들을 각각 로드할 키값이 있어야 한다 //AUTOINCREMENT 값이 하나하나씩 올라간다 데이터 들어올때마다 알아서 1씩 증가
        //NOT NULL 데이터가 비어있으면 안된다! 안적으면 비어있어도 된다
        //id -> 데이터 베이스 id / loc -> 냉장고 / 냉동실 / 실온 type -> 종류 / name -> 이름

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        onCreate(db);
    }

    // SELECT 문(할일 목록들을 조회)
    public ArrayList<refrigeitem> getrefrigerator(){//메소드로 만든다
        ArrayList<refrigeitem> refrigeItems = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();//조회 다른것과 다르다 읽는 행위
        Cursor cursor = db.rawQuery("SELECT * FROM refrigerator ORDER BY type DESC",null);
        //type을 기준으로 정렬 될까? 이건 해봐야 안다... 원래는 숫자형들이고 다른 수들있을때는 가능
        //*을 넣으면 모든 열들을 다 가지고 오는 조건없이 모든 데이터 가져온다
        //SELECT (조회) ORDER BY(정렬 할때 사용) DESC 내림차순
        if(cursor.getCount()!=0){//반드시 데이터가 있다는 사실
            //조회된 데이터가 있을때 내부 수행
            while(cursor.moveToNext()){
                //다음으로 이동할 데이터가 있을때까지 //cursor은 하나씩 가리킨다
                //다음 커서가 없으면 탈출
                int id = cursor.getInt(cursor.getColumnIndex("id"));//id라는 항목을 실제 sq테이블 id index에 맞춰서 실제 id로 넘겨져온 값을 받아온다
                String loc = cursor.getString(cursor.getColumnIndex("loc"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

                refrigeitem refrigeItem = new refrigeitem();
                refrigeItem.setId(id);
                refrigeItem.setLoc(loc);
                refrigeItem.setName(name);
                refrigeItem.setType(type);
                refrigeItems.add(refrigeItem);
            }
        }
        cursor.close();
        return refrigeItems;//담아놓은 것을 언제 어디든 호출 가능
    }

    //냉장고 물품 추가
    public void InsertItem(String _loc, String _type, String _name) {
        //id는 안넣나? -> 보통 아이디는 생략가능 자동으로 가능 //public은 어디서나 삽입 가능하게
        SQLiteDatabase db = getWritableDatabase();//쓰기 가능한
        db.execSQL("INSERT INTO refrigerator(loc,type,name) VALUES('"+_loc+"','"+_type+"','"+_name+"');");
        //냉장고안에 넣겠다 //id는 자동 증가이므로 insert안해도 된다 //id는 안넣어도 된다는 말을 첫번째 괄호 안에 //VALUES()뒤에 ;있어야 한다
    }
    //UPDATE (냉장고 물품 개수 변경될때)
    public void UpdateItem(String _loc, String _type, String _name, int _id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE refrigerator SET loc='"+_loc+"',type='"+_type+"',name='"+_name+"'WHERE id='"+_id+"'");
        //where은 그냥 막 업데이트가 아니라 조건문을 걸어주는 것
        //id는 자동 증가되는 key값 을 이용해 업데이트 어디에 있는 값이 조건 일치할때 그 값의 위치에다가 그값을 갱신해줘야 한다
    }

    //DELETE (냉장고 물품 삭제)
    public void deleteItem(int _id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM TodoList WHERE id = '"+_id+"'");
    }

}
