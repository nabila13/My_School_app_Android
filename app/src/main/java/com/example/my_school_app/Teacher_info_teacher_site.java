package com.example.my_school_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my_school_app.Controller.Show_TeacherInfo_Controller;
import com.example.my_school_app.Model.Teacher_info_Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Teacher_info_teacher_site extends AppCompatActivity {
   // private static final String JSON_URL = "http://10.0.2.2/Software_project/get_teacher_info.php";
    List<Teacher_info_Model> teacherList;
    List<Teacher_info_Builder>teacherInfoList;
    //the recyclerview
    RecyclerView recyclerView3;
    Show_TeacherInfo_Controller viewAdapter1;

    Button addinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info_teacher_site);
        addinfo = findViewById(R.id.teacher_info1);

        addinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Add_teacher_info.class));
            }
        });
        recyclerView3 = findViewById(R.id.rv_teacherview);
        adddata2();
    }

    public void adddata2() {
//initializing the productlist
        teacherList = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config_url.getTeacherinfo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject studetailsall = array.getJSONObject(i);
                        //adding the product to product list
                        teacherList.add(new Teacher_info_Model(
                                studetailsall.getInt("cid"),
                                studetailsall.getString("cname"),
                                studetailsall.getString("cgender"),
                                studetailsall.getString("cmobile"),
                                studetailsall.getString("cemail")
                        ));
                    }
                    viewAdapter1 = new Show_TeacherInfo_Controller(getApplicationContext(),teacherList);
                    recyclerView3.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView3.setAdapter(viewAdapter1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Teacher_info_teacher_site.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }
}