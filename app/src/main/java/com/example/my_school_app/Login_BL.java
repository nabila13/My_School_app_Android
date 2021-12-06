package com.example.my_school_app;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my_school_app.Model.Login_Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login_BL extends AppCompatActivity {
String s;
    List<Login_Model> loginList;
public String match(final String name, final String pass, Context context,String code){


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

                        if ((String.valueOf(item.getUsername()).toLowerCase().contains(name.toLowerCase())) && (String.valueOf(item.getPassword()).toLowerCase().contains(pass.toLowerCase()))){
                            //Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                          //  Intent intent=new Intent(getApplicationContext(), Teacher_site.class);
                            //startActivity(intent);
                            s="success";
                        }
                        else{
                            s="failed";
                           // Toast.makeText(getApplicationContext(),"Login Failed!! Try Again!!", Toast.LENGTH_LONG).show();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                s="error";
             //   Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(context).add(stringRequest);

    return s;
}

}
