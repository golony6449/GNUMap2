package com.example.jeon.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//메인 화면 카메라뷰 띄우고 검색 현재위치 범위 설정 가능
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private FrameLayout mTextMessage;

    FragmentManager fm;
    FragmentTransaction tran;

    // 필드 추가 및 작성
    // 센서 메니저 생성
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor mMagneticField;

    // 센서 값
    float[] magVal;
    float[] gravityVal;
    float mAzimut, mPitch, mRoll;
    double X, Y;
    float[] azimutList = new float[50];
    float[] rollList = new float[50];
    int count = 0;

    // DB Helper 생성
    DBHelper dbHelper;
    ArrayList<Building> buildList;

    // 디버깅용 TextView
    TextView text;
    TextView GPStext;
    BuildView markerView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                fm = getFragmentManager();
                tran = fm.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.navigation_search:
                        Intent myIntent = new Intent(getApplicationContext(), com.example.jeon.myapplication.Search.class);
                        startActivity(myIntent);
                        return true;

                    case R.id.navigation_refresh:
                        change();

                        return true;
                    case R.id.navigation_locate:
                        Intent myIntent3 = new Intent(getApplicationContext(),BuildingLocation.class);
                        startActivity(myIntent3);
                        return true;
                }
                return false;
            }
        };
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                show();
//            }
//        });
//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // 성흠 파트 추가
        // DB 초기화 파트
        dbHelper = new DBHelper(getApplicationContext(), Environment.getExternalStorageDirectory().getPath() + "/gnumap/main.db"
                , null, 1);
        System.out.println("객체 생성 OK");
        System.out.println("DB path: " + Environment.getExternalStorageDirectory().getPath() + "/gnumap/main.db");

        // 센서 초기화 파트
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);

        // GPS 초기화
        startLocationService();

        final CameraSurfaceView cameraView = new CameraSurfaceView(getApplicationContext());
        FrameLayout previewFrame = (FrameLayout) findViewById(R.id.previewFrame);
        previewFrame.addView(cameraView);

        text = new TextView(this);
        text.setTextColor(Color.WHITE);
        text.setText("초기화 중");
        previewFrame.addView(text);

        GPStext = new TextView(this);
        GPStext.setTextColor(Color.WHITE);
        GPStext.setText("\n\n\n수신중");
        previewFrame.addView(GPStext);

        markerView = new BuildView(this);
        previewFrame.addView(markerView);
    }


    public void CurrentLocation(View v) {
        Intent myIntent = new Intent(getApplicationContext(),BuildingLocation.class);
        startActivity(myIntent);


    }
    public void search(View v) {
        Intent myIntent = new Intent(getApplicationContext(), com.example.jeon.myapplication.Search.class);
        startActivity(myIntent);
    }

    //****유니티로 전환****
    public void change() {
        Intent intent = this.getPackageManager().getLaunchIntentForPackage("com.gnu.ARmap");
        startActivity(intent);
    }





//    void show() {
//        final List<String> ListItems = new ArrayList<>();
//        ListItems.add("100m");
//        ListItems.add("200m");
//        ListItems.add("300m");
//        ListItems.add("400m");
//        ListItems.add("500m");
//
//        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);
//
//        final List SelectedItems  = new ArrayList();
//        int defaultItem = 0;
//        SelectedItems.add(defaultItem);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("범위 목록");
//        builder.setSingleChoiceItems(items, defaultItem,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        SelectedItems.clear();
//                        SelectedItems.add(which);
//                    }
//                });
//        builder.setPositiveButton("Ok",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        String msg="";
//
//                        if (!SelectedItems.isEmpty()) {
//                            int index = (int) SelectedItems.get(0);
//                            msg = ListItems.get(index);
//                        }
//                        Toast.makeText(getApplicationContext(),
//                                " "+ msg + "\n 설정" , Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                });
//        builder.setNegativeButton("Cancel",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//        builder.show();
//    }

//성흠 파트 추가

    // TODO: 터치 이벤트 관련 작업
    public boolean onTouchEvent(MotionEvent event){
        Log.e("TouchEvent", "터치 이벤트 발생");
        System.out.println("X: " + event.getX() + "  Y: " + event.getY());

        // TODO: 기준점 필요 --> Buildview 내부에 존재하는 X, Y 리스트를 처리하는 함수 호출
        Building touched =  markerView.checkTouch(event.getX(), event.getY());
        if (touched == null){
            return false;
        }

        Intent myIntent = new Intent(getApplicationContext(), SearchData.class);
        myIntent.putExtra("buildingObj", touched.getBuildName());
        startActivity(myIntent);

        return true;
    }

    public void onSensorChanged(SensorEvent event) {
//        Log.d("SensorEvent", "센서 값 변경");
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magVal = event.values;
//           System.out.println(magVal[0]); // 0 ~ 2
//            text.setText("X: " + magVal[0] + " Y: " + magVal[1] + " Z: " + magVal[2]);
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            gravityVal = event.values;
        }

        if (magVal != null && gravityVal != null) {
            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, gravityVal, magVal);
            if (success) {
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);
                mAzimut = (float) Math.toDegrees(orientation[0]) + 90;  // 오차보정 + 7
                mPitch = (float) Math.toDegrees(orientation[1]);
                mRoll = (float) Math.toDegrees(orientation[2]);

                if (mAzimut < 0) {
                    mAzimut = mAzimut + 360;
                }

                int idx = 10;
                if (count == idx) {
                    float azimutSum = 0;
                    float rollSum = 0;
                    for (int i = 0; i < idx; i++) {
                        azimutSum += azimutList[i] / idx;
                        rollSum += rollList[i] / idx;
                    }
                    String result = "Azimut:" + azimutSum + "\n" + "Pitch:" + mPitch + "\n" + "Roll:" + mRoll;
                    text.setText(result);
                    markerView.setSensorValue(azimutSum, rollSum);  // 기기가 90도(PI/2)만큼 회전되어있기 때문에 센서의 Roll 값을 Pitch로 사용
                    count = 0;
                } else {
                    azimutList[count] = mAzimut;
                    rollList[count] = mRoll;
                    count += 1;
                }

            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int val) {

    }

    // GPS
    private void startLocationService() {
        Log.d("LocationService", "위치서비스 시작");
        // 위치 관리자 객체 참조
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        // 위치 정보를 받을 리스너 생성
        GPSListener gpsListener = new GPSListener();
        long minTime = 1500;
        float minDistance = 0;

        // GPS를 이용한 위치 요청
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, gpsListener);

        Toast.makeText(getApplicationContext(), "위치 확인이 시작되었습니다. 로그를 확인하세요.", Toast.LENGTH_SHORT).show();

    }

    public void setXY(double x, double y){
        this.X = x; this.Y = y;
        this.buildList = dbHelper.searchPos(x, y, 0.0015);
//        this.buildList = dbHelper.searchNum(303);
        markerView.setMarkerList(buildList, x, y);
    }

    /**
     * 리스너 클래스 정의
     */
    private class GPSListener implements LocationListener {
        /**
         * 위치 정보가 확인될 때 자동 호출되는 메소드
         */
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            String provider = location.getProvider();

            GPStext.setText("\n\n\n\n" + "Latitude : " + latitude + " Longitude:" + longitude + " Provider: " + provider);

//            String msg = "Latitude : "+ latitude + "\nLongitude:"+ longitude;
//            Log.i("GPSListener", msg);
//            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            setXY(latitude, longitude);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

}
