package com.example.my_school_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class Teacher_site extends AppCompatActivity {

Button logout;
    private static final int NUM_COLUMNS2 = 2;
    private ArrayList<Integer> nImageUrls = new ArrayList<>();
    private ArrayList<String> nNames = new ArrayList<>();
    private Context nContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_site);
      initImageBitmaps2();
   logout=findViewById(R.id.logout);
   logout.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent logout=new Intent(getApplicationContext(),Choice_type.class);
           startActivity(logout);
       }
   });
    }

    private void initImageBitmaps2() {
        // Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        nImageUrls.add(R.drawable.principal);
        nNames.add("Principal's Speech");


        nImageUrls.add(R.drawable.notice);
        nNames.add("Notice");


        nImageUrls.add(R.drawable.result);
        nNames.add("Exam Results");

        nImageUrls.add(R.drawable.student_info);
        nNames.add("Student's Information");

        nImageUrls.add(R.drawable.style);
        nNames.add("Teacher's Information");


        nImageUrls.add(R.drawable.daily_activity);
        nNames.add("Daily Activity");

        nImageUrls.add(R.drawable.homework);
        nNames.add("Home Work");

        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView3);

        Teacher_Site_Adapter recyclerView_stag_teacher =
                new Teacher_Site_Adapter(this, nNames, nImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS2, LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        recyclerView2.setAdapter(recyclerView_stag_teacher);
    }
}
