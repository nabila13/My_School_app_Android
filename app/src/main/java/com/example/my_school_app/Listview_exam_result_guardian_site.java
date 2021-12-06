package com.example.my_school_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_school_app.View.Class1_result_guardian_site;

import java.util.ArrayList;
import java.util.List;

public class Listview_exam_result_guardian_site extends AppCompatActivity {
    String [] stu3={"Class 1","Class 2","Class 3","Class 4","class 5"};
    ListView lv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_student_result);
        lv3=(ListView)findViewById(R.id.list_result);
        List<String> list=new ArrayList<>();
        for(String i: stu3){
            list.add(i);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_adapter,R.id.text1,list);
        lv3.setAdapter(adapter);
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String value=stu3[position];
            Intent intent=new Intent(getApplicationContext(), Class1_result_guardian_site.class);
            intent.putExtra("val",value);
            startActivity(intent);

             /*   if(position== 0){
                    Intent add=new Intent(view.getContext(), Class1_result_guardian_site.class);
                    startActivity(add);
                }
                if(position== 1){
                    Intent add2=new Intent(view.getContext(), Class2_result_guardian_site.class);
                    startActivity(add2);
                } if(position== 2){
                    Intent add3=new Intent(view.getContext(), Class3_result_guardian_site.class);
                    startActivity(add3);
                } if(position== 3){
                    Intent add4=new Intent(view.getContext(), Class4_result_guardian_site.class);
                    startActivity(add4);
                } if(position== 4){
                    Intent add5=new Intent(view.getContext(), Class5_result_guardian_site.class);
                    startActivity(add5);
                }

              */
            }


        });

    }
}
