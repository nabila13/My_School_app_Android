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

public class Signup_guardian extends AppCompatActivity {
    EditText editTextFullname,editTextemail,editTextpassword,editTextUsername;
    Button buttonSignUp;
    TextView textViewLogin;
    private static String TAG = Signup_guardian.class.getSimpleName();
   // private String insertDataURL = "http://10.0.2.2:8081/Software_project/registration_guardian.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_guardian);

    editTextemail=findViewById(R.id.email_g);
    editTextUsername=findViewById(R.id.username_g);
    editTextpassword=findViewById(R.id.password_g);
    buttonSignUp=findViewById(R.id.signup_g);
    textViewLogin=findViewById(R.id.req_login2);
    textViewLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), Login_Guardian.class);
            startActivity(intent);
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
        } if (editTextUsername.getText().toString().length() == 0) {
            editTextUsername.setError("please Insert your user name!!");
        }
            if (editTextemail.getText().toString().length() != 0 && editTextUsername.getText().toString().length() != 0 && editTextpassword.getText().toString().length() == 0) {
            editTextpassword.setError("please insert your password!");
        }if((editTextemail.getText().toString().length()==0 && editTextpassword.getText().toString().length()==0) && editTextUsername.getText().toString().length()==0) {
        editTextemail.setError("please insert your email!");
        editTextpassword.setError(("please insert your password!"));
        editTextUsername.setError("please insert your username!");
            }
            if(editTextemail.getText().toString().length()!=0 && editTextpassword.getText().toString().length()!=0 && editTextUsername.getText().toString().length()!=0){
            androidx.appcompat.app.AlertDialog.Builder alertDialogBuilde = new androidx.appcompat.app.AlertDialog.Builder(this);
            alertDialogBuilde.setMessage("Are you sure you want to sign up?");

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



        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config_url.signup_guardian, new Response.Listener<String>() {
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