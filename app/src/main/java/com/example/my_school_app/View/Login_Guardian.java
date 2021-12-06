package com.example.my_school_app.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my_school_app.Config_url;
import com.example.my_school_app.Guardian_site;
import com.example.my_school_app.Model.Login_Model;
import com.example.my_school_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login_Guardian extends AppCompatActivity {
    EditText login_gname, login_gpass;
    Button Login_g;
    TextView textView_login1;
    String name,pass;
    List<Login_Model> loginList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__guardian);

        login_gname=findViewById(R.id.login_username);
        login_gpass=findViewById(R.id.login_pass);
        textView_login1=findViewById(R.id.req_sign1);
        textView_login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faaa=new Intent(getApplicationContext(), Signup_guardian.class);
                startActivity(faaa);
            }
        });

        Login_g=findViewById(R.id.login_gbtn);
        Login_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=login_gname.getText().toString();
                pass=login_gpass.getText().toString();
                addData(name,pass);
            }
        });

    }
    public void addData (final String name,final String pass) {
//initializing the productlist
        loginList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config_url.login_guardian, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject studetailsall = array.getJSONObject(i);
                        //adding the product to product list
                        loginList.add(new Login_Model(
                                studetailsall.getInt("id"),
                                studetailsall.getString("username"),
                                studetailsall.getString("password")
                        ));
                    }
                    for (Login_Model item : loginList) {
                        if ((String.valueOf(item.getUsername()).toLowerCase().contains(name.toLowerCase())) && (String.valueOf(item.getPassword()).contains(pass))){
                            Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(), Guardian_site.class);
                            startActivity(intent);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }
}