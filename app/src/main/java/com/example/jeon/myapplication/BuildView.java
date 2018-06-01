package com.example.jeon.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class BuildView extends View {
    private Drawable mCompass;
    private int PADDING = 2;
    private ArrayList<RectF> markerList;
    private ArrayList<Building> buildingList = new ArrayList<Building>();
    private ArrayList<Float> X = new ArrayList<Float>();
    private ArrayList<Float> Y = new ArrayList<Float>();
    private double calcedAngle;
    private double angle;
    private double pitch;

    public BuildView(Context ctx) {
        super(ctx);

//        this.mCompass = ctx.getResources().getDrawable(R.drawable.arrow_n);
    }

    protected void onDraw(Canvas canvas) {
        canvas.save();
        X.clear();
        Y.clear();



        Paint Pnt = new Paint();   // 페인트 생성
//        Pnt.setColor(0xfff612ab);  // 핑크색
//        Pnt.setAlpha(70); // 반투명

        Paint pntText = new Paint();
        pntText.setStyle(Paint.Style.FILL);
        pntText.setTextSize(30);
        pntText.setColor(Color.WHITE);

//        RectF r = new RectF(getWidth()*0.5f, getHeight()*0.1f, getWidth()*0.9f, getHeight()*0.35f); // 시작 X,Y 좌표, 끝 X,Y 좌표

        if (buildingList.isEmpty()){
            super.onDraw(canvas);
            return;
        }

        for (int i =0; i < buildingList.size(); i++) {
            Building buildObj = buildingList.get(i);
            double diff = 0; // 방위각과 건물 위치간의 차이
            double radAngleFromXaxis = 0;
            double xStep = getWidth() / 75;
            double yStep = getHeight() / 60;
            float xPosition = 0;
            float yPosition = (getHeight() / 2) - ((float) yStep * (90 + (float) this.pitch));

            Pnt.setColor(buildObj.getColor()); // 단과대학별 다른 색상
            Pnt.setAlpha(70); // 반투명

            // 1 사분면
            if (angle < 90) {
                    radAngleFromXaxis = (90 - this.angle) * (Math.PI / 180);
                    diff = radAngleFromXaxis - buildObj.returnArcTan(); // 방위각과 건물 위치간의 차이

                // TODO: Diff 값 체크 완료
                    xPosition = (getWidth() / 2) + ((float) (diff * (180 / Math.PI)) * (float) xStep);
//                if (Math.abs(diff) < (Math.PI / 3)) {
//                    radAngleFromXaxis = (90 - this.angle) * (Math.PI / 180);
//                    diff = radAngleFromXaxis - buildObj.returnArcTan(); // 방위각과 건물 위치간의 차이
//
//                    xPosition = (getWidth() / 2) + ((float) (diff * (180 / Math.PI)) * (float) xStep);    // TODO: 수정필요
//                } else {
////                System.out.println("범위 초과: " + buildObj.returnName() + "   diff: " + (diff*(180/ Math.PI)));
//                }
            }

            // 4 사분면
            else if (angle < 180){
                radAngleFromXaxis = (360 - (this.angle - 90)) * (Math.PI / 180);
                diff = radAngleFromXaxis - buildObj.returnArcTan(); // 방위각과 건물 위치간의 차이

                xPosition = (getWidth() / 2) + ((float) (diff * (180 / Math.PI)) * (float) xStep);    // TODO: 수정필요
            }

            // 3사분면
            else if (angle < 270){
                radAngleFromXaxis = (180 + (270 - this.angle)) * (Math.PI / 180);
                diff = radAngleFromXaxis - buildObj.returnArcTan(); // 방위각과 건물 위치간의 차이

                xPosition = (getWidth() / 2) + ((float) (diff * (180 / Math.PI)) * (float) xStep);    // TODO: 수정필요
            }

            // 2사분면
            else if (angle < 360){
                radAngleFromXaxis = (90 + (360 - this.angle)) * (Math.PI / 180);
                diff = radAngleFromXaxis - buildObj.returnArcTan(); // 방위각과 건물 위치간의 차이

                xPosition = (getWidth() / 2) + ((float) (diff * (180 / Math.PI)) * (float) xStep);    // TODO: 수정필요
            }

            // 변수 생성
            RectF obj = new RectF(xPosition - 100.f, yPosition - 100.f, xPosition + 100.f, yPosition + 100.f);

            if ((buildObj.returnArcTan() * (180 / Math.PI)) < 90) System.out.print("1사분면 ");
            else if ((buildObj.returnArcTan() * (180 / Math.PI)) < 180) System.out.print("2사분면 ");
            else if ((buildObj.returnArcTan() * (180 / Math.PI)) < 270) System.out.print("3사분면 ");
            else if ((buildObj.returnArcTan() * (180 / Math.PI)) < 360) System.out.print("4사분면 ");

//            Debug
//            System.out.println("angle From X: " + (radAngleFromXaxis * (180 / Math.PI)) + "   " + buildObj.returnName() + "의 X축 기준 건물위치: " + (buildObj.returnArcTan() * (180 / Math.PI)));

            canvas.drawText(buildObj.returnName(), xPosition - 80.f, yPosition, pntText);
            canvas.drawText(buildObj.getDistanceString(), xPosition - 80.f, yPosition + 30.f, pntText);
            canvas.drawRoundRect(obj, 5, 5, Pnt);

            X.add(xPosition);
            Y.add(yPosition);
        }

        super.onDraw(canvas);
    }

    public void setMarkerList(ArrayList<Building> buildList, double x, double y){
        // 초기화
        buildingList.clear();
        buildingList.addAll(buildList);
        System.out.println("setMarkerList Called");
        for (int i = 0; i < buildList.size(); i++){
            buildList.get(i).printAll();
        }

        for (int i = 0; i < buildList.size(); i++){
            Building obj = buildList.get(i);
            // TODO: 확인필요
            double xDiff = x - obj.X;
            double yDiff = y - obj.Y;
            obj.setXYDiff(xDiff, yDiff);
            buildList.set(i, obj);

            calcedAngle = Math.atan(yDiff / xDiff);

//            디버깅용
//            calcedAngle = Math.acos(yDiff / Math.sqrt(xDiff * xDiff + yDiff * yDiff));
//            System.out.println("X: " + x + "  Y: " + y);
//            System.out.println("objX: " + obj.X + "  objY: " + obj.Y);
//            Log.e("diffValueCheck","xDiff: " + obj.xDiff + "  yDiff: " + obj.yDiff);

//            System.out.println("계산된 방위각: " + (obj.returnArcTan() * (180/Math.PI)));

        }
//        invalidate();
    }

    public void setSensorValue(double angle, double pitch){
        this.angle = angle;
        this.pitch = pitch; // 기기가 90도(PI/2)만큼 회전되어있기 때문에 센서의 Roll 값을 Pitch로 사용

//        System.out.println("방위각 차이: " + (calcedAngle - this.angle));

            invalidate();
    }

    public Building checkTouch(float x, float y){
        // TODO: ArrayList 반복!
        Log.d("checkTouch", "checkTouch 실행");

        for(int i = 0; i < X.size(); i++){
            float objX = X.get(i);
            float objY = Y.get(i);

            if (objX - 100 < x & x < objX + 100)
                if (objY - 100 < y & y < objY + 100){
//                Log.e("checkTouch", buildingList.get(i).printAll();)
                    buildingList.get(i).printAll();
                    return buildingList.get(i);
                }
        }
        return null;
    }
}


