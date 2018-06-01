package com.example.jeon.myapplication;

import android.util.Log;

public class Department {
    private int buildNum;
    private String deptName;
    private int roomNum;
    private String description;
    private String web;

    Department(int buildNum, String dept, int roomNum, String description, String web){
        this.buildNum = buildNum;
        this.deptName = dept;
        this.roomNum = roomNum;
        this.description = description;
        this.web = web;
    }

    public int getBuildNum(){
        return this.buildNum;
    }

    public String getDeptName(){
        return this.deptName;
    }

    public int getRoomNum(){
        return this.roomNum;
    }

    public String getResult(){
        return Integer.toString(buildNum) + deptName + Integer.toString(roomNum);
    }

    public String getDescription(){
        String output = "";
        output = Integer.toString(this.buildNum) + "동 " + Integer.toString(this.roomNum) + "호 " + this.deptName + " ";

//        return this.description;
        return output;
    }

    public String getWeb(){
        return this.web;
    }

    public void getResultForDebug(){
        Log.e("DepartmentInfo", Integer.toString(buildNum) + deptName + Integer.toString(roomNum));
    }
}
