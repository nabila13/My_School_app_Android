package com.example.my_school_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_school_app.View.Class1_result_teacher_site;

import java.util.ArrayList;
import java.util.List;

public class Listview_exam_result_teacher_site extends AppCompatActivity {
    String [] stu_result={"Class 1","Class 2","Class 3","Class 4","class 5"};
    ListView lv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_exam_result_teacher_site);

        lv_result=(ListView)findViewById(R.id.list_result2);
        List<String> list=new ArrayList<>();
        for(String i: stu_result){
            list.add(i);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_adapter,R.id.text1,list);
        lv_result.setAdapter(adapter);

       lv_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String value=stu_result[position];
             Intent ii=new Intent(getApplicationContext(), Class1_result_teacher_site.class);
             ii.putExtra("val",value);
             startActivity(ii);

           }
       });

    }
}
