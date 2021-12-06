package com.example.my_school_app.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.my_school_app.AppSingleton1;
import com.example.my_school_app.Config_url;
import com.example.my_school_app.R;

import java.util.HashMap;
import java.util.Map;

public class SignUp_teacher extends AppCompatActivity {
   EditText editTextFullname,editTextemail,editTextpassword,editTextUsername;
    Button buttonSignUp;
    TextView textViewLogin;
    private static String TAG = SignUp_teacher.class.getSimpleName();
    // public String baseURL = "https://nabu13.000webhostapp.com/software_project/registration_teacher.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_teacher);
        editTextemail=findViewById(R.id.email);
        editTextUsername=findViewById(R.id.username);
        editTextpassword=findViewById(R.id.password);
        buttonSignUp=findViewById(R.id.signup_t);
        textViewLogin=findViewById(R.id.req_login1);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add=new Intent(getApplicationContext(), Login_teacher.class);
                startActivity(add);
            }
        });
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmadddata();

            }
        });
    }
    private void confirmadddata() {
        if (editTextemail.getText().toString().length() == 0) {
            editTextemail.setError("please insert your email!");
        }
        if (editTextUsername.getText().toString().length() == 0) {
            editTextUsername.setError("please Insert your user name!!");
        }
        if (editTextemail.getText().toString().length() != 0 && editTextUsername.getText().toString().length() != 0 && editTextpassword.getText().toString().length() == 0) {
            editTextpassword.setError("please insert your password!");
        }
        if ((editTextemail.getText().toString().length() == 0 && editTextpassword.getText().toString().length() == 0) && editTextUsername.getText().toString().length() == 0) {
            editTextemail.setError("please insert your email!");
            editTextpassword.setError(("please insert your password!"));
            editTextUsername.setError("please insert your username!");
        }
        if (editTextemail.getText().toString().length() != 0 && editTextpassword.getText().toString().length() != 0 && editTextUsername.getText().toString().length() != 0) {
            androidx.appcompat.app.AlertDialog.Builder alertDialogBuilde = new androidx.appcompat.app.AlertDialog.Builder(this);
            alertDialogBuilde.setMessage("Are you sure you want to Sign up?");

            alertDialogBuilde.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            insertdatanewway2();
                            //  startActivity(new Intent(Insert_new.this,ViewproductList_2.class));
                        }
                    });

            alertDialogBuilde.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

            androidx.appcompat.app.AlertDialog alertDialog = alertDialogBuilde.create();
            alertDialog.show();
        }
    }
    public void insertdatanewway2() {



        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config_url.signup_teacher, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //progressBar.setVisibility(View.GONE);

                editTextemail.setText("");
                editTextUsername.setText("");
                editTextpassword.setText("");
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parameters = new HashMap<String, String>();
                // gpa=Double.parseDouble(editgpa.getText().toString());
                //point=Double.parseDouble(editpoint.getText().toString());
                // GPA=String.valueOf(gpa);
                //total=String.valueOf(point);
                parameters.put("email", editTextemail.getText().toString().trim());
                parameters.put("username", editTextUsername.getText().toString());
                parameters.put("password", editTextpassword.getText().toString());
                return parameters;
            }
        };
        AppSingleton1.getInstance(this).addToRequestQueue(stringRequest,TAG);
    }
}