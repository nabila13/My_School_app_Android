package com.example.my_school_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listview_activities_teacher_site extends AppCompatActivity {
    String [] active_stu={"Class 1","Class 2","Class 3","Class 4","class 5"};
    ListView lv_active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_activities_teacher_site);
        lv_active=(ListView)findViewById(R.id.list_active2);
        List<String> list3=new ArrayList<>();
        for(String i: active_stu){
            list3.add(i);
        }
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,R.layout.list_adapter,R.id.text1,list3);
        lv_active.setAdapter(adapter2);

    }
}
