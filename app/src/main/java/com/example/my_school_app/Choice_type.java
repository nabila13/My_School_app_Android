package com.example.my_school_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_school_app.View.SignUp_teacher;
import com.example.my_school_app.View.Signup_guardian;

public class Choice_type extends AppCompatActivity {
Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Signup_guardian.class);
                startActivity(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(getApplicationContext(), SignUp_teacher.class);
                startActivity(ii);
            }
        });
    }
}
