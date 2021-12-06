package com.example.my_school_app.View;

import android.content.Intent;
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
import com.example.my_school_app.Model.Exam_result_Model;
import com.example.my_school_app.Config_url;
import com.example.my_school_app.Controller.Show_Exam_Results_Controller;
import com.example.my_school_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Class4_result_guardian_site extends AppCompatActivity {
    //private static final String JSON_URL = "http://10.0.2.2:8081/Software_project/get_class4_result.php";
    List<Exam_result_Model> resultList;
    //the recyclerview
    RecyclerView recyclerView4;
    Show_Exam_Results_Controller viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class4_result_guardian_site);
        recyclerView4 = findViewById(R.id.rv_student_view4);

        Intent asper = getIntent();
        String value = asper.getStringExtra("val3");
        if (value.equalsIgnoreCase("Class 4")) {
            adddata();
        } else {
            Intent intent = new Intent(getApplicationContext(), Class5_result_guardian_site.class);
            startActivity(intent);
        }
    }
    public void adddata () {
//initializing the productlist
        resultList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config_url.getClass4result, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject studetailsall = array.getJSONObject(i);
                        //adding the product to product list
                        resultList.add(new Exam_result_Model(
                                studetailsall.getInt("cid"),
                                studetailsall.getString("croll"),
                                studetailsall.getString("cname"),
                                studetailsall.getDouble("cgpa"),
                                studetailsall.getDouble("cpoint")
                        ));
                    }
                    viewAdapter = new Show_Exam_Results_Controller(getApplicationContext(),resultList);
                    recyclerView4.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView4.setAdapter(viewAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Class4_result_guardian_site.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }
}