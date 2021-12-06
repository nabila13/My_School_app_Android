package com.example.my_school_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_school_app.View.Class1_studentinfo_teacher_site;

import java.util.ArrayList;
import java.util.List;

public class Listview_student_info_teacher_site extends AppCompatActivity {
    String [] info_stu={"Class 1","Class 2","Class 3","Class 4","class 5"};
    ListView lv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_student_info_teacher_site);
        lv_info=(ListView)findViewById(R.id.list_info2);
        List<String> list=new ArrayList<>();
        for(String i: info_stu){
            list.add(i);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_adapter,R.id.text1,list);
        lv_info.setAdapter(adapter);

        lv_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String value=info_stu[position];
             Intent ii=new Intent(getApplicationContext(), Class1_studentinfo_teacher_site.class);
             ii.putExtra("val",value);
             startActivity(ii);

                /*
                if(position== 0){
                    Intent add=new Intent(view.getContext(), Class1_studentinfo_teacher_site.class);
                    startActivity(add);
                }
                if(position== 1){
                    Intent add2=new Intent(view.getContext(), Class2_studentinfo_teacher_site.class);
                    startActivity(add2);
                } if(position== 2){
                    Intent add3=new Intent(view.getContext(), Class3_studentinfo_teacher_site.class);
                    startActivity(add3);
                } if(position== 3){
                    Intent add4=new Intent(view.getContext(), Class4_studentinfo_teacher_site.class);
                    startActivity(add4);
                } if(position== 4){
                    Intent add5=new Intent(view.getContext(), Class5_studentinfo_teacher_site.class);
                    startActivity(add5);

                }

              */
            }
        });

    }
}
