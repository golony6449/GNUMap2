package com.example.jeon.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


// 내장된 SQLite Helper 상속
public class DBHelper extends SQLiteOpenHelper {

    // 관리할 DB이름, 버전정보를 생성자로 받음
    public DBHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("DB Created!");  // 디버깅용
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    // 디비 내용 전체를 빌딩리스트로 반환 (디버깅용)
    public ArrayList<Building> getResult(){
        System.out.println("getResult 시작");

        ArrayList<Building> buildList = new ArrayList<Building>();

        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        System.out.println("DB 객체 생성");
        Cursor cursor = db.rawQuery("SELECT * FROM building", null);
        while(cursor.moveToNext()){
            buildList.add(new Building(cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getDouble(4),
                    cursor.getString(5), cursor.getInt(6), cursor.getString(7)));

            result += cursor.getString(1) + "  " + cursor.getString(2);
//            System.out.println(result);
            result = "";
        }
        cursor.close();
        return buildList;
    }

    // 이름으로 검색, 해당하는 빌딩리스트를 반환
    public ArrayList<Building> searchName(String str){
        System.out.println("getName 시작");
        System.out.println("키워드: " + str);

        ArrayList<Building> buildList = new ArrayList<Building>();
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // TODO: 예외처리
        Cursor cursor = db.rawQuery("SELECT * FROM building WHERE buildName == \"" + str + "\"" , null);
        while(cursor.moveToNext()){
            buildList.add(new Building(cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getDouble(4),
                    cursor.getString(5), cursor.getInt(6), cursor.getString(7)));

            result += cursor.getString(0) + "  " + cursor.getString(1);
//            System.out.println(result);
            result = "";
        }
        cursor.close();
        return buildList;
    }

    // 건물 번호로 검색, 해당하는 빌딩리스트 반환
    public ArrayList<Building> searchNum(int num){
        System.out.println("searchNum 시작");
        System.out.println("키워드: " + num);

        ArrayList<Building> buildList = new ArrayList<Building>();
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // TODO: 예외처리
        Cursor cursor = db.rawQuery("SELECT * FROM building WHERE buildNum == " + num , null);
        while(cursor.moveToNext()){
            buildList.add(new Building(cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getDouble(4),
                    cursor.getString(5), cursor.getInt(6), cursor.getString(7)));

            result += cursor.getString(0) + "  " + cursor.getString(1);
            System.out.println(result);
            result = "";
        }

        cursor.close();
        return buildList;
    }

    // 위치기반 검색, 해당하는 빌딩리스트 반환
    public ArrayList<Building> searchPos(double X, double Y, double range){
        double Xrange = range;
        double Yrange = range;
        System.out.println("searchPos 시작");
        System.out.println("키워드: X:" + X + " Y: " + Y );

        ArrayList<Building> buildList = new ArrayList<Building>();
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // TODO: 예외처리
        Cursor cursor = db.rawQuery("SELECT * FROM building WHERE X > " + (X-Xrange) + " and X < " + (X+Xrange) + " and Y > " + (Y-Yrange)
                + " and Y < " + (Y+Yrange), null);
        while(cursor.moveToNext()){
            Building temp = new Building(cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getDouble(4),
                    cursor.getString(5), cursor.getInt(6), cursor.getString(7));
            temp.calcDistance(X, Y);

            buildList.add(temp);

            result += cursor.getString(0) + "  " + cursor.getString(1);
//            System.out.println(result);
            result = "";
        }

        cursor.close();
        return buildList;
    }

    public ArrayList<Department> searchDeptByNum(int buildNum){
        Log.d("DBHelper", "searchDept 시작");

        ArrayList<Department> deptList = new ArrayList<Department>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT department.* FROM building, department WHERE building.buildNum == department.buildNum and building.buildNum == " + buildNum, null);

        while(cursor.moveToNext()){
            deptList.add(new Department(
                    cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4)));
        }

        cursor.close();
        return deptList;
    }

    public ArrayList<Department> searchDeptByName(String name){
        Log.d("DBHelper", "searchDeptByName 시작");

        ArrayList<Department> deptList = new ArrayList<Department>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT department.* FROM building, department WHERE building.buildNum == department.buildNum and building.buildName == \"" + name + "\"", null);
        Log.e("SQL query", "SELECT department.* FROM building, department WHERE building.buildNum == department.buildNum and building.buildName == \" " + name + "\"");

        while(cursor.moveToNext()){
            deptList.add(new Department(
                    cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4)));
        }

        cursor.close();
        return deptList;
    }
}

