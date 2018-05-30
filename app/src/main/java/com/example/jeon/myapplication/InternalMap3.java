package com.example.jeon.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//내부지도 지금은 이미지로 표시 버튼을 따로 기재 해서 층간 구분 계획
public class InternalMap3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_map3);
        //301호강의실
        TextView three_1 = (TextView) findViewById(R.id.three_1);
        three_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show1();
            }
        });
        //302호강의실
        TextView three_2 = (TextView) findViewById(R.id.three_2);
        three_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show2();
            }
        });
        //303호강의실
        TextView three_3 = (TextView) findViewById(R.id.three_3);
        three_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show3();
            }
        });
        //실습실
        TextView pr_1 = (TextView) findViewById(R.id.pr_1);
        pr_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show4();
            }
        });
        //교수연구실
        TextView PO_1 = (TextView) findViewById(R.id.PO_1);
        PO_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show5();
            }
        });


        TextView three_HL = (TextView) findViewById(R.id.three_HL);
        three_HL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show6();
            }
        });
    }

    public void activity_main(View v) {
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(myIntent);
    }

    void show1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("301호 강의실 데이터")        // 데이터로 대체
                .setMessage("100석의 책상과 교수용컴퓨터")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }

    void show2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("302호 강의실 데이터")        // 데이터로 대체
                .setMessage("100석의 책상과 교수용컴퓨터")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }

    void show3(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("303호 강의실 데이터")        // 데이터로 대체
                .setMessage("컴퓨터책상과 교수용컴퓨터")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }

    void show4(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("304호 강의실 데이터")        // 데이터로 대체
                .setMessage("실습용컴퓨터 50대구비 교수용컴퓨터")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }

    void show5(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("교수연구실")        // 데이터로 대체
                .setMessage("김민기교수연구실")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }


    void show6() {
        final CharSequence[] items = {"위층", "아래층"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this



// 여기서 부터는 알림창의 속성 설정
// setItems() 메소드는 표시할 항목의 배열과 OnClickListener를 매개 변수로 받는다. OnClickListener는 사용자가 항목을 선택하는 경우에 실행되는 동작을 정의한다.

        builder.setTitle("선택하세요")        // 제목 설정
                .setCancelable(true)
                .setItems(items, new DialogInterface.OnClickListener(){    // 목록 클릭시 설정

                    public void onClick(DialogInterface dialog, int index){
                        if(index==0) {
                            Toast.makeText(getApplicationContext(), items[0], Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(getApplicationContext(), InternalMap4.class);
                            startActivity(myIntent);

                        }
                        else if(index==1){
                            Toast.makeText(getApplicationContext(), items[1], Toast.LENGTH_SHORT).show();
                            Intent myIntent2 = new Intent(getApplicationContext(), InternalMap2.class);
                            startActivity(myIntent2);
                        }
                        else
                        Toast.makeText(getApplicationContext(), "ㅎㅎㅎ", Toast.LENGTH_SHORT).show();


                    }



                });


        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기


    }

}

