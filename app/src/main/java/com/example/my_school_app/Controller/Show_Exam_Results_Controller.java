package com.example.my_school_app.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_school_app.R;
import com.example.my_school_app.Model.Exam_result_Model;

import java.util.List;

public class Show_Exam_Results_Controller extends RecyclerView.Adapter<Show_Exam_Results_Controller.CustomerViewHolder>{
    public Show_Exam_Results_Controller(Context mCtx, List<Exam_result_Model> resultList) {
        this.mCtx = mCtx;
        this.resultList = resultList;
    }

    private Context mCtx;
    private List<Exam_result_Model> resultList;

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.result_recycler_design, null);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Exam_result_Model pro =resultList.get(position);
        holder.textroll.setText(pro.getC_roll());
        holder.textName.setText(pro.getC_name());
        String c_gpa=String.valueOf(pro.getC_gpa());
        String c_point=String.valueOf(pro.getC_point());
        holder.textgpa.setText(c_gpa);
        holder.textpoint.setText(c_point);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder {
        //getting text views
        TextView textid;
        TextView textroll;
        TextView textName;
        TextView textgpa;
        TextView textpoint;
        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
//getting text views
            textid = itemView.findViewById(R.id.text_id);
            textroll = itemView.findViewById(R.id.editroll);
            textName = itemView.findViewById(R.id.editname);
            textgpa=itemView.findViewById(R.id.editgpa);
            textpoint=itemView.findViewById(R.id.editmark);
            itemView.setTag(itemView);
// itemView.setOnClickListener(this);
        }
    }
}
