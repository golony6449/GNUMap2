package com.example.jeon.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */

public class SearchAdapter extends BaseAdapter /*implements AdapterView.OnItemClickListener*/ {

    private Context context;
    private List<String> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public SearchAdapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflate.inflate(R.layout.row_listview,null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.label);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));


        return convertView;
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
//    {
//        // 두가지 방법 모두 사용가능하다.
//        //    Data data = (Data) parent.getItemAtPosition(position);
//        ContactsContract.Data data = mList.get(position);
//
//        // 다음 액티비티로 넘길 Bundle 데이터를 만든다.
//        Bundle extras = new Bundle();
//
//        extras.putString("title", data.getTitle());
//        extras.putString("description", data.getDescription());
//        extras.putInt("color", data.getColor());
//
//
//        // 인텐트를 생성한다.
//        // 컨텍스트로 현재 액티비티를, 생성할 액티비티로 ItemClickExampleNextActivity 를 지정한다.
//
//        Intent myIntent = new Intent(getApplicationContext, SearchData.class);
//
//        // 위에서 만든 Bundle을 인텐트에 넣는다.
//        intent.putExtras(extras);
//
//        // 액티비티를 생성한다.
//        startActivity(intent);
//    }


    class ViewHolder{
        public TextView label;
    }

}