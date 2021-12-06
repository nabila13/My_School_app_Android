package com.example.my_school_app;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Add_teacher_info extends AppCompatActivity {
    //private String insertDataURL = "http://10.0.2.2:8081/Software_project/add_teacher_info.php";
    //  private String insertDataURL = "http://stamasoft.com/android/stu_master_details/Registration.php";



    private static String TAG = Add_teacher_info.class.getSimpleName();
    private Button insert,back;
    double gpa,point;
    private EditText editnamet, editgendert,editphonet,editemailt;

    // Progress dialogs
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher_info);

        insert = (Button) findViewById(R.id.add_teacherinfo);
        back=findViewById(R.id.getback);


        /* editIname = (EditText) findViewById(R.id.c_name_1);
         editroll = (EditText) findViewById(R.id.c_roll_1);
         editgpa = (EditText) findViewById(R.id.c_gpa_1);
         editpoint = (EditText) findViewById(R.id.c_point_1);*/


        editnamet= findViewById(R.id.teacher_name);
        editgendert = findViewById(R.id.teacher_gender);
        editphonet= findViewById(R.id.teacher_mobile);
        editemailt =findViewById(R.id.teacher_email);


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
insert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        confirmadddata();
    }
});
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),Teacher_info_teacher_site.class));
    }
});
    }

    private void confirmadddata(){
        androidx.appcompat.app.AlertDialog.Builder alertDialogBuilde  = new androidx.appcompat.app.AlertDialog.Builder (this);
        alertDialogBuilde.setMessage("Are you sure you want to Add Data?");

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



    //--------------------------

    private void showpDialog() {
        if (!pDialog.isShowing()) pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing()) pDialog.dismiss();
    }

    public void insertdatanewway2() {

        showpDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,Config_url.insertteacherinfo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //progressBar.setVisibility(View.GONE);
                editnamet.setText("");
                editgendert.setText("");
                editphonet.setText("");
                editemailt.setText("");


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
                parameters.put("c_name", editnamet.getText().toString().trim());
                parameters.put("c_gender", editgendert.getText().toString().trim());
                parameters.put("c_mobile", editphonet.getText().toString());
                parameters.put("c_email", editemailt.getText().toString());

                hidepDialog();
                return parameters;
            }
        };

        AppSingleton1.getInstance(this).addToRequestQueue(stringRequest,TAG);
    }
}