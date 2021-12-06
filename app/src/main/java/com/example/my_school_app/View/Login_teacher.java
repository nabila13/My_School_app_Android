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
import com.example.my_school_app.Login_BL;
import com.example.my_school_app.Model.Login_Model;
import com.example.my_school_app.R;
import com.example.my_school_app.Teacher_site;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login_teacher extends AppCompatActivity {
    EditText login_tname, login_tpass,login_code;
    Button Login_t;
   private String name;
    private String pass,code;
    TextView textView_login2;
    List<Login_Model>loginList;
    Login_BL login_bl=new Login_BL(); //Context context=getApplicationContext();
    //private static final String JSON_URL = "http://10.0.2.2:8081/Software_project/login_teacher.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        login_tname=findViewById(R.id.login_username);
        login_tpass=findViewById(R.id.login_pass);
        login_code=findViewById(R.id.login_code);
        textView_login2=findViewById(R.id.req_sign2);
        textView_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faaa=new Intent(getApplicationContext(), SignUp_teacher.class);
                startActivity(faaa);
            }
        });


        Login_t=findViewById(R.id.login_tbtn);
        Login_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=login_tname.getText().toString().trim();
                pass=login_tpass.getText().toString().trim();
                code=login_code.getText().toString().trim();


                match(name,pass,code);
                String str=login_bl.match(name,pass,getApplicationContext(),code);
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void match (final String name,final String pass,final String code) {
//initializing the productlist
        loginList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config_url.login_teacher, new Response.Listener<String>() {
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

                        if ((String.valueOf(item.getUsername()).contains(name)) && (String.valueOf(item.getPassword()).contains(pass)) && code.equalsIgnoreCase("tech")) {
                            Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Teacher_site.class);
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