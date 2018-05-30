package com.example.jeon.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//검색을 통한 화면 홈페이지 건물 위치 내부지도 등 건물에 대한 기본 설명 와이파이 등 정보 기술
public class SearchData extends AppCompatActivity {

    private static final String TAG = SearchData.class.getSimpleName();

    private Intent intent;
    private TextView resultName;
    private String list_name = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchdata);

        intent = getIntent();
        list_name = intent.getStringExtra("list_name");

        resultName = (TextView) findViewById(R.id.resultName); // id값 resulName값을
        resultName.setText(list_name); //SearchData레이아웃의 resultName값을 넣음

        Log.v(TAG,list_name);
    }

    public void Homepage(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gnu.ac.kr/main/"));
        startActivity(myIntent);

    }
    public void MapsActivity(View v) {
        Intent myIntent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(myIntent);

    }
    public void InternalMap(View v) {
        Intent myIntent = new Intent(getApplicationContext(),InternalMap.class);
        startActivity(myIntent);

    }

}
