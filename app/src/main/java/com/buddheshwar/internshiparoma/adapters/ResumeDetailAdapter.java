package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.resume.ResumeDetails;
import com.buddheshwar.internshiparoma.resume.WorkSample;

import java.util.ArrayList;

public class ResumeDetailAdapter extends RecyclerView.Adapter<ResumeDetailAdapter.ViewHolder> {

    private ArrayList<String> details;
    private Context context;
    private String type;

    public ResumeDetailAdapter(Context context, ArrayList<String> details, RecyclerView recyclerViewResponsibility, String type) {
       this.details=details;
       this.context=context;
       this.type=type;
    }

    @NonNull
    @Override
    public ResumeDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.resume_detail_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       TextView txt=holder.txt;
       ImageView edit=holder.edit;
       ImageView delete=holder.delete;

       txt.setText(details.get(position));
        if(type.equalsIgnoreCase("workSample")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                txt.setTextColor(((AppCompatActivity) context).getColor(R.color.actionBar));
            }
        }
        edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Fragment fr;
               if(type.equalsIgnoreCase("responsibility")){
                   fr = new ResumeDetails();
                   Bundle bundle=new Bundle();
                   bundle.putString("pageTitle","responsibility");
                   fr.setArguments(bundle);

               }else if(type.equalsIgnoreCase("additionalDetails")){
                    fr = new ResumeDetails();
                   Bundle bundle=new Bundle();
                   bundle.putString("pageTitle","detail");
                   fr.setArguments(bundle);

               }
               else{
                   fr = new WorkSample();

               }
               ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

           }
       });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, details.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView edit,delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          txt=itemView.findViewById(R.id.txt);
          edit=itemView.findViewById(R.id.edit);
          delete=itemView.findViewById(R.id.delete);
        }
    }
}
