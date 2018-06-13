package com.example.jeon.myapplication;

import android.graphics.Color;
import android.location.Location;

public class Building {
    private String buildName;
    private int buildNum;
    public double X;
    public double Y;
    private String imgPath;
    private int wifi;
    private double xDiff;
    private double yDiff;
    private int color;
    private double distance;
    private String college;

    Building(int buildNum, String buildName, double X, double Y, String imgPath, int wifi, String College){
        this.buildName = buildName; this.buildNum = buildNum; this.X = X; this.Y = Y; this.imgPath = imgPath; this.wifi = wifi;
        this.college = College;
        this.xDiff = 0;
        this.yDiff = 0;

        if (College == "본부")    this.color = Color.parseColor("#e53935");
        else if (College == "약학대학") this.color = Color.parseColor("#7b1fa2");
        else if (College.equals("자연과학대학")) this.color = Color.parseColor("#311b92");
        else if (College.equals("기숙사")) this.color = Color.parseColor("#2196f3");
        else if (College.equals("인문대학")) this.color = Color.parseColor("#1a237e");
        else if (College.equals("법과대학")) this.color = Color.parseColor("#03a9f4");
        else if (College.equals("경영대학")) this.color = Color.parseColor("#00acc1");
        else if (College.equals("사회과학대학")) this.color = Color.parseColor("#80d8ff");
        else    this.color = Color.parseColor("#00c853");
    }

    public void printAll(){
//        Log.e("BuildingListData" ,buildName + " " + buildNum + " " + X + " " + Y + " " + imgPath + " " + wifi);
    }

    public String returnName(){
        return buildName;
    }

    public double returnArcTan(){
        double tan = xDiff / yDiff;
        double radAngle = Math.atan(tan);

//        Log.e("xDiff", Double.toString(xDiff));
//        Log.e("yDiff", Double.toString(yDiff));
//        Log.e("tan", Double.toString(tan));

        if (Math.abs(radAngle) < Math.abs(10*(Math.PI / 180))) {
//            Log.e("ArcTan", "동쪽 예외처리");
        }
        // 3사분면
        else if (yDiff > 0 && xDiff > 0) {
            radAngle += Math.PI;
//            Log.e("ArcTan", "3사분면 처리");
        }

        // 2 사분면인 경우 Angle 값에서 180도 차감
        else if (yDiff > 0 && xDiff < 0) {
            radAngle += Math.PI;
//            Log.e("ArcTan", "3사분면 처리");
        }
        else{
//            Log.e("ArcTan", "별도 처리 없음 tan:" + tan + " radAngle: " + Math.toDegrees(radAngle) );
        }

        if (radAngle < 0)
            radAngle += (2* Math.PI);
        else if (radAngle > 2* Math.PI)
            radAngle -= (2* Math.PI);

        return radAngle;
    }

    public void setXYDiff(double x, double y){
        this.xDiff = x;
        this.yDiff = y;
    }

    public String getBuildName(){
        return this.buildName;
    }

    public int getBuildNum(){
        return this.buildNum;
    }

    public int getColor(){
        return this.color;
    }

    public void calcDistance(double X, double Y){
//        distance = Math.sqrt((X - this.X)*(X - this.X) + (Y-this.Y)*(Y-this.Y));
        Location start = new Location("start");
        start.setLatitude(X);
        start.setLongitude(Y);

        Location end = new Location("end");
        end.setLatitude(this.X);
        end.setLongitude(this.Y);

        distance = start.distanceTo(end);

//        Log.e("distance", Double.toString(distance));
    }

    public double getDistance(){
        return distance;
    }

    public String getDistanceString(){
        return String.format("%.3f", distance) + "m";
    }

    public String getCollege(){
        return this.college;
    }

}
