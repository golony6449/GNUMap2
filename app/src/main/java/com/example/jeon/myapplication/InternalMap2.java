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
public class InternalMap2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_map2);
        TextView two_rr = (TextView) findViewById(R.id.two_rr);
        two_rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show1();
            }
        });

        TextView two_printer = (TextView) findViewById(R.id.two_printer);
        two_printer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show2();
            }
        });

        TextView two_HL = (TextView) findViewById(R.id.two_HL);
        two_HL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show3();
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

        builder.setTitle("30동 열람실")        // 데이터로 대체
                .setMessage("300석의 책상")        // 데이터로 대체
                .setCancelable(true);   // 뒤로 버튼 클릭시 취소 가능 설정

        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기

    }

    void show2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this

// 여기서 부터는 알림창의 속성 설정

        builder.setTitle("프린터")        // 데이터로 대체
                .setMessage("3대PC와 프린터기구비")        // 데이터로 대체
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
                            Intent myIntent = new Intent(getApplicationContext(), InternalMap3.class);
                            startActivity(myIntent);

                        }
                        else if(index==1){
                            Toast.makeText(getApplicationContext(), items[1], Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(getApplicationContext(), InternalMap.class);
                            startActivity(myIntent);
                        }
                        else
                            Toast.makeText(getApplicationContext(), "예외처리", Toast.LENGTH_SHORT).show();


                    }



                });


        AlertDialog dialog = builder.create();    // 알림창 객체 생성

        dialog.show();    // 알림창 띄우기


    }

}

