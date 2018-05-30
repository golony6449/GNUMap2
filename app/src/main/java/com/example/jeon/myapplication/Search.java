package com.example.jeon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//검색을 통한 화면 홈페이지 건물 위치 내부지도 등 건물에 대한 기본 설명 와이파이 등 정보 기술
public class Search extends AppCompatActivity {

    private static final String TAG = Search.class.getSimpleName();

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);


        editSearch = (EditText) findViewById(R.id.input);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        setArraylist();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        try {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(Search.this, SearchData.class); //전환 클래스명만 바꾸면됨
                    myIntent.putExtra("list_name",list.get(position).toString());
                    startActivity(myIntent);
                Log.v(TAG,"On Click gnsdlfwjs");
                }
            });
        } catch ( Exception e ) {
            Log.v(TAG,"Exception : "+e);
        }


        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search1(text);
            }
        });


    }

    // 검색을 수행하는 메소드
    public void search1(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }



/*    //*******************************
    //SD카드 검색
    //*******************************
    public static void save(String result) {
        String sdPath; //SD 카드 경로
        String externalState = Environment.getExternalStorageState();
        if (externalState.equals(Environment.MEDIA_MOUNTED)) {
            //외부장치가 마운트 되어서 읽어올 준비가 되었을떄
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        else {
            //마운트 되지 않았을떄
            sdPath = Environment.MEDIA_UNKNOWN;
        }
        File file = new File(sdPath + "/gnumap/main.db");
        if (!file.isDirectory())
            file.mkdir(); //디렉토리 만들기
        File file1 = new File(sdPath + "/gnumap/main.db");
        try {
            FileOutputStream fos = new FileOutputStream(file1);
            fos.write(result.getBytes());
            fos.close();

        } catch (Exception e) {
            Log.i("파일 저장 실패:", e.getMessage());
        }
    }

    //데이터 로드 메소드
    public static String load() {
        String sdPath;  //SD 카드의 경로
        String externalState = Environment.getExternalStorageState();
        if (externalState.equals(Environment.MEDIA_MOUNTED)) {
            //외부 저장 장치가 마운트 되어서 읽어올 준비가 되었을 때
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            //마운트 되지 않았을 때
            sdPath = Environment.MEDIA_UNMOUNTED;
        }
        String result = "";
        try {
            String dir = sdPath + "/myDir/text.txt";
            //파일에서 읽어오기 위한 스트림 객체
            File file = new File(dir);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            result = new String(buffer);
        } catch (Exception e) {
            Log.i("불러오기 실패", e.getMessage());
        }
        return result;ㅇ
    }*/





    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void setArraylist(){ //settingList
        list.add("대학본부");
        list.add("도서관");
        list.add("학생회관");
        list.add("교육정보전산원");
        list.add("체육관");
        list.add("박물관");
        list.add("GNU어린이집");
        list.add("교양학관");
        list.add("창업보육센터");
        list.add("공동실험실습관");
        list.add("약학대학");
        list.add("국제어학원");
        list.add("컴퓨터과학관");
        list.add("남명학관");
        list.add("학군단");
        list.add("야외공연장");
        list.add("대운동장");
        list.add("파워플랜트");
        list.add("테니스장");
        list.add("게스트하우스");
        list.add("EnglishVillage");
        list.add("LG개척관");
        list.add("부설중학교");
        list.add("부설고등학교");
        list.add("인문1호관");
        list.add("인문2호관");
        list.add("사회과학관");
        list.add("경영학관");
        list.add("법학관");
        list.add("대경학술관");
        list.add("교육1호관");
        list.add("교육2호관");
        list.add("교육문화센터");
        list.add("예술관");
        list.add("과학1호관");
        list.add("과학2호관");
        list.add("과학3호관");
        list.add("과학4호관");
        list.add("공학1호관");
        list.add("공학2호관");
        list.add("공학3호관");
        list.add("공학4호관");
        list.add("공학5호관");
        list.add("공학6호관");
        list.add("공학7호관(항공우주산학협력관)");
        list.add("공대부속공장");
        list.add("농생1호관");
        list.add("농생2호관");
        list.add("농생3호관");
        list.add("농생4호관");
        list.add("농생5호관");
        list.add("농생6호관");
        list.add("농생7호관");
        list.add("농생8호관");
        list.add("농생과학관");
        list.add("수의1호관");
        list.add("동물병원");
        list.add("실험동물실습관");

    }
}




/*
    public void (View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gnu.ac.kr/main/"));
        startActivity(myIntent);

    }
    public void BuildingLocation(View v) {
        Intent myIntent = new Intent(getApplicationContext(),BuildingLocation.class);
        startActivity(myIntent);

    }
    public void InternalMap(View v) {
        Intent myIntent = new Intent(getApplicationContext(),InternalMap.class);
        startActivity(myIntent);

    }

}


*/
