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
import com.example.my_school_app.Config_url;
import com.example.my_school_app.Controller.Student_info_Controller;
import com.example.my_school_app.Model.Student_info_Model;
import com.example.my_school_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Class3_studentinfo_guardian_site extends AppCompatActivity {
    //private static final String JSON_URL = "http://10.0.2.2:8081/Software_project/get_class3_stuinfo.php";
    List<Student_info_Model> infoList;
    //the recyclerview
    RecyclerView recyclerView6;
    Student_info_Controller viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3_studentinfo_guardian_site);

        recyclerView6=findViewById(R.id.rv_stuinfo31);
        Intent inter=getIntent();
        String value=inter.getStringExtra("val3");

        if(value.equalsIgnoreCase("Class 3")){
            adddata();
        }
        else{
            Intent inter2=new Intent(getApplicationContext(),Class4_studentinfo_guardian_site.class);
            inter2.putExtra("val4",value);
            startActivity(inter2);
        }
    }
    public void adddata () {
//initializing the productlist
        infoList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config_url.getclass3info, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject studetailsall = array.getJSONObject(i);
                        //adding the product to product list
                        infoList.add(new Student_info_Model(
                                studetailsall.getInt("cid"),
                                studetailsall.getInt("croll"),
                                studetailsall.getString("cname"),
                                studetailsall.getDouble("cage"),
                                studetailsall.getString("c_gname"),
                                studetailsall.getInt("c_contact")
                        ));
                    }
                    viewAdapter = new Student_info_Controller(getApplicationContext(),infoList);
                    recyclerView6.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView6.setAdapter(viewAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Class3_studentinfo_guardian_site.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }
}