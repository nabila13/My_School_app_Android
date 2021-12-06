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

public class Guardian_Site_Adapter extends RecyclerView.Adapter<Guardian_Site_Adapter.ViewHolder> {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private Context mContext;
    public Guardian_Site_Adapter(Context mContext, ArrayList<String> mNames, ArrayList<Integer> mImageUrls) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);
        holder.name.setText(mNames.get(position));
    }
    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView nums;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(position==0){
                        Intent i=new Intent(v.getContext(), Principal_speech.class);
                        mContext.startActivity(i);
                    }
                    if(position==2){
                        Intent iii=new Intent(v.getContext(), Listview_exam_result_guardian_site.class);
                        mContext.startActivity(iii);
                    }
                    if(position==3){
                        Intent iii=new Intent(v.getContext(), Listview_student_info_guardian_site.class);
                        mContext.startActivity(iii);
                    }
                    if(position==4){
                        Intent ia=new Intent(v.getContext(), Teacher_info_guardian_site.class);
                        mContext.startActivity(ia);
                    }
                    if(position==5){
                        Intent ii=new Intent(v.getContext(),Listview_activities.class);
                        mContext.startActivity(ii);
                    }
                }
            });
            this.image = itemView.findViewById(R.id.imageview_widget);
            this.name = itemView.findViewById(R.id.name_widget);
        }
    }
}
