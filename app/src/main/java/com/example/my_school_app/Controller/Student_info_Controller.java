package com.example.my_school_app.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_school_app.R;
import com.example.my_school_app.Model.Student_info_Model;

import java.util.List;

public class Student_info_Controller extends RecyclerView.Adapter<Student_info_Controller.StudentInfoViewHolder> {

    public Student_info_Controller(Context mCtx, List<Student_info_Model> infoList) {
        this.mCtx = mCtx;
        this.infoList = infoList;
    }

    private Context mCtx;
    private List<Student_info_Model> infoList;

    @NonNull
    @Override
    public StudentInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.student_info_recycler_design, null);
        return new Student_info_Controller.StudentInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentInfoViewHolder holder, int position) {

        Student_info_Model pro =infoList.get(position);
        holder.textroll.setText(String.valueOf(pro.getC_roll()));
        holder.textName.setText(pro.getC_name());
        String c_age=String.valueOf(pro.getC_age());
        //String c_point=String.valueOf(pro.getC_point());
        holder.textage.setText(c_age);
        holder.text_gname.setText(pro.getC_gname());
        holder.text_contact.setText(String.valueOf(pro.getC_number()));
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }


    class StudentInfoViewHolder extends RecyclerView.ViewHolder {
        //getting text views
        TextView textid;
        TextView textroll;
        TextView textName;
        TextView textage;
        TextView text_gname;
        TextView text_contact;
        public StudentInfoViewHolder(@NonNull View itemView) {
            super(itemView);
//getting text views
            textid = itemView.findViewById(R.id.text_id);
            textroll = itemView.findViewById(R.id.editroll);
            textName = itemView.findViewById(R.id.editname);
            textage=itemView.findViewById(R.id.editage);
            text_gname=itemView.findViewById(R.id.editgname);
            text_contact=itemView.findViewById(R.id.editcontact);
            itemView.setTag(itemView);
// itemView.setOnClickListener(this);
        }
    }

}
