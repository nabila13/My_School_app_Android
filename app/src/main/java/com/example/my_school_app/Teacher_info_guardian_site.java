package com.example.my_school_app;

import android.os.Bundle;
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

public class Teacher_info_guardian_site extends AppCompatActivity {

   // private static final String JSON_URL = "http://10.0.2.2/Software_project/get_teacher_info.php";
    List<Teacher_info_Model> teacherList;
    //the recyclerview
    RecyclerView recyclerView4;
    Show_TeacherInfo_Controller viewAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_info_guardian_site);
        recyclerView4=findViewById(R.id.rv_teacherview2);

        adddata3();
    }
    public void adddata3() {
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
                    viewAdapter2= new Show_TeacherInfo_Controller(getApplicationContext(),teacherList);
                    recyclerView4.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView4.setAdapter(viewAdapter2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Teacher_info_guardian_site.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }
}