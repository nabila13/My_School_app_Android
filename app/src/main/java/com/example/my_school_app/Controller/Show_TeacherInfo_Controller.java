package com.example.my_school_app.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_school_app.R;
import com.example.my_school_app.Model.Teacher_info_Model;

import java.util.List;

public class Show_TeacherInfo_Controller extends RecyclerView.Adapter<Show_TeacherInfo_Controller.CustomerViewHolder>{
    public Show_TeacherInfo_Controller(Context mCtx, List<Teacher_info_Model> teacherList) {
        this.mCtx = mCtx;
        this.teacherList = teacherList;
    }

    private Context mCtx;
    private List<Teacher_info_Model> teacherList;

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.teacherinfo_recycler_design, null);
        return new Show_TeacherInfo_Controller.CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {

        Teacher_info_Model pro =teacherList.get(position);
        holder.textnamet.setText(pro.getC_name());
        holder.textgendert.setText(pro.getC_gender());
        //String c_gpa=String.valueOf(pro.getC_gpa());
       // String c_point=String.valueOf(pro.getC_point());
        holder.textmobilet.setText(pro.getC_mobile());
        holder.textemailt.setText(pro.getC_email());
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }


    class CustomerViewHolder extends RecyclerView.ViewHolder {
        //getting text views
        TextView textid;
        TextView textnamet;
        TextView textgendert;
        TextView textmobilet;
        TextView textemailt;
        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
//getting text views
            textid = itemView.findViewById(R.id.text_id);
            textnamet = itemView.findViewById(R.id.textnamet);
            textgendert = itemView.findViewById(R.id.editgendert);
            textmobilet=itemView.findViewById(R.id.editmobilet);
            textemailt=itemView.findViewById(R.id.editemailt);
            itemView.setTag(itemView);
// itemView.setOnClickListener(this);
        }
    }
}
