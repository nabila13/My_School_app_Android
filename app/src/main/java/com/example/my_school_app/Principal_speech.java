package com.example.my_school_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Principal_speech extends AppCompatActivity {
ImageView principal_image;
TextView prin_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_speech);
        principal_image=findViewById(R.id.prin_img);
        prin_text=findViewById(R.id.prin_txt);



    }
}
