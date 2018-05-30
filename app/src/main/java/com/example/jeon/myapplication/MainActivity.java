package com.example.jeon.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//메인 화면 카메라뷰 띄우고 검색 현재위치 범위 설정 가능
public class MainActivity extends AppCompatActivity {

    private FrameLayout mTextMessage;

    FragmentManager fm;
    FragmentTransaction tran;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fm = getFragmentManager();
            tran = fm.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_search:
                    Intent myIntent = new Intent(getApplicationContext(),Search.class);
                    startActivity(myIntent);
                    return true;

                case R.id.navigation_refresh:
                    Intent myIntent2 = new Intent(getApplicationContext(),Search.class);
                    startActivity(myIntent2);

                    return true;
                case R.id.navigation_locate:
                    Intent myIntent3 = new Intent(getApplicationContext(),BuildingLocation.class);
                    startActivity(myIntent3);
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    public void CurrentLocation(View v) {
        Intent myIntent = new Intent(getApplicationContext(),BuildingLocation.class);
        startActivity(myIntent);


    }
    public void search(View v) {
        Intent myIntent = new Intent(getApplicationContext(),Search.class);
        startActivity(myIntent);
    }

    //****유니티로 전환****
    public void change(View v) {
        Intent myIntent = new Intent(getApplicationContext(),InternalMap.class); //전환 클래스명만 바꾸면됨
        startActivity(myIntent);
    }





    void show() {
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("100m");
        ListItems.add("200m");
        ListItems.add("300m");
        ListItems.add("400m");
        ListItems.add("500m");

        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);

        final List SelectedItems  = new ArrayList();
        int defaultItem = 0;
        SelectedItems.add(defaultItem);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("범위 목록");
        builder.setSingleChoiceItems(items, defaultItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SelectedItems.clear();
                        SelectedItems.add(which);
                    }
                });
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String msg="";

                        if (!SelectedItems.isEmpty()) {
                            int index = (int) SelectedItems.get(0);
                            msg = ListItems.get(index);
                        }
                        Toast.makeText(getApplicationContext(),
                                " "+ msg + "\n 설정" , Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }


}
