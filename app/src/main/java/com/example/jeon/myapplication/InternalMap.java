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
public class InternalMap extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_map1);
        //301호강의실
        TextView one_rr = (TextView) findViewById(R.id.one_rr);
        one_rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show1();
            }
        });
        //302호강의실
        TextView one_st = (TextView) findViewById(R.id.one_st);
        one_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show2();
            }
        });

        TextView one_HL = (TextView) findViewById(R.id.one_HL);
        one_HL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show3();
            }
        });
    }
    public void main(View v) {
        Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(myIntent);
    }

    void show1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("30동 열람실")        // 데이터로 대체
                .setMessage("300석의 책상")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }

    void show2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("학생상단센터")        // 데이터로 대체
                .setMessage("상담받으러 가세요~")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }


    void show3() {
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

