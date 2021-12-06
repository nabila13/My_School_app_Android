package com.example.my_school_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Listview_activities extends AppCompatActivity {
    String [] stu2={"Class 1","Class 2","Class 3","Class 4","class 5"};
    ListView lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_activities);
        lv2=(ListView)findViewById(R.id.list_active);
        List<String> list2=new ArrayList<>();
        for(String i: stu2){
            list2.add(i);
        }
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,R.layout.list_adapter,R.id.text1,list2);
        lv2.setAdapter(adapter2);
    }
}
