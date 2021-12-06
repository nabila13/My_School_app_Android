package com.example.my_school_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Teacher_Site_Adapter extends RecyclerView.Adapter<Teacher_Site_Adapter.ViewHolder>{
    private ArrayList<String> nNames = new ArrayList<>();
    private ArrayList<Integer> nImageUrls = new ArrayList<>();
    private ArrayList<Teacher_info_Builder>nteacher_Info=new ArrayList<>();
    private Context nContext;
    public Teacher_Site_Adapter(Context nContext, ArrayList<String> nNames, ArrayList<Integer> nImageUrls) {
        this.nNames = nNames;
        this.nImageUrls = nImageUrls;
        this.nContext = nContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_teacher, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);
        Glide.with(nContext)
                .load(nImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.images);
        holder.names.setText(nNames.get(position));
    }

    @Override
    public int getItemCount() {
        return nImageUrls.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView images;
        TextView names;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(position==0){
                        Intent i=new Intent(v.getContext(), Principal_speech.class);
                        nContext.startActivity(i);
                    }
                    if(position==2){
                        Intent iii=new Intent(v.getContext(), Listview_exam_result_teacher_site.class);
                        nContext.startActivity(iii);
                    }
                    if(position==3){
                        Intent iv=new Intent(v.getContext(),Listview_student_info_teacher_site .class);
                        nContext.startActivity(iv);
                    }
                    if(position==4){
                        Intent iq=new Intent(v.getContext(), Teacher_info_teacher_site.class);
                        nContext.startActivity(iq);
                    }
                    if(position==5){
                        Intent ii=new Intent(v.getContext(),Listview_activities_teacher_site.class);
                        nContext.startActivity(ii);
                    }
                }
            });
            this.images = itemView.findViewById(R.id.imageview_widget2);
            this.names = itemView.findViewById(R.id.name_widget2);
        }
    }
}
