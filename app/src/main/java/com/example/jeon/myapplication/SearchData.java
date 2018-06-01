package com.example.jeon.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//검색을 통한 화면 홈페이지 건물 위치 내부지도 등 건물에 대한 기본 설명 와이파이 등 정보 기술
public class SearchData extends AppCompatActivity {

    private static final String TAG = SearchData.class.getSimpleName();
    ArrayList<Department> deptList;
    private DBHelper dbHelper;
    private TextView description;
    private SearchAdapter adapter;
    private ArrayList<String> infoList;
    private ListView info;
    private String url;
    private boolean isSelected;
    private boolean isComputer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchdata);

        Intent intent;
        TextView resultName;
        String buildName = "";
        dbHelper = new DBHelper(getApplicationContext(), Environment.getExternalStorageDirectory().getPath() + "/gnumap/main.db", null, 1);
        infoList = new ArrayList<String>();
        info = (ListView) findViewById(R.id.deptList);
        isComputer = false;
        isSelected = false;

        intent = getIntent();
        buildName = intent.getStringExtra("buildingObj");

        deptList = dbHelper.searchDeptByName(buildName);

        for(int i = 0; i < deptList.size(); i++){
            deptList.get(i).getResultForDebug();
            infoList.add(deptList.get(i).getDescription());
        }

        adapter = new SearchAdapter(infoList, this);
        // 리스트뷰에 아답터를 연결한다.
        try {
            info.setAdapter(adapter);

//            // TODO: Click Event 처리
            info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    url = deptList.get(position).getWeb();
                    isSelected = true;

                    if (deptList.get(position).getBuildNum() == 30){
                        isComputer = true;
                    }

//                    Log.e("ItemClick", "isSelect: " + Boolean.toString(isSelected) + "  isComputer: " + Boolean.toString(isComputer));

                    Toast.makeText(getApplicationContext(), "정보가 갱신되었습니다." , Toast.LENGTH_SHORT).show();
                }
            });
        } catch ( Exception e ) {
            Log.e(TAG,"Exception : " + e);
        }


        resultName = (TextView) findViewById(R.id.resultName); // id값 resulName값을
//        description = (TextView) findViewById(R.id.description);


        resultName.setText(buildName); //SearchData레이아웃의 resultName값을 넣음
//        description.setText(deptList.get(0).getDescription());

//        Log.v(TAG,list_name);

        // 설명
        Building current = dbHelper.searchName(buildName).get(0);
        description = (TextView) findViewById(R.id.description);
        description.setText(current.getCollege() + " " + Integer.toString(current.getBuildNum()) + "동 \n" + buildName + "입니다." );
    }

    public void Homepage(View v) {
        Log.e("ItemClick", "isSelect: " + Boolean.toString(isSelected) + "  isComputer: " + Boolean.toString(isComputer));
        if (this.isSelected == false){
            Toast.makeText(getApplicationContext(), "정보가 없습니다.." , Toast.LENGTH_SHORT).show();
            return;
        }
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(myIntent);

    }
    public void MapsActivity(View v) {
        Intent myIntent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(myIntent);

    }

    public void InternalMap(View v) {
        Log.e("ItemClick", "isSelect: " + Boolean.toString(isSelected) + "  isComputer: " + Boolean.toString(isComputer));
        if (this.isComputer == false){
            Toast.makeText(getApplicationContext(), "구현중 입니다.." , Toast.LENGTH_SHORT).show();
            return;
        }
        Intent myIntent = new Intent(getApplicationContext(),InternalMap.class);
        startActivity(myIntent);

    }

    @Override
    public void onBackPressed() {
        Log.e("Event", "Back Btn Pressed");
        this.isSelected = false;
        this.isComputer = false;

        super.onBackPressed();
    }
}
