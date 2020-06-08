package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
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
import com.buddheshwar.internshiparoma.model.JobInternshipTrainingData;
import com.buddheshwar.internshiparoma.resume.JobInternshipTrainingDetails;

import java.util.ArrayList;

public class JobInternshipTrainingAdapter extends RecyclerView.Adapter<JobInternshipTrainingAdapter.ViewHolder> {

    private ArrayList<JobInternshipTrainingData> data;
    private Context context;

    public JobInternshipTrainingAdapter(Context context, ArrayList<JobInternshipTrainingData> trainingData, RecyclerView recyclerViewDetail) {
      this.context=context;
      this.data=trainingData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.job_internship_training_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       TextView txtTitle=holder.txtTitle;
       TextView txtDate=holder.txtDate;
       TextView txtAbout=holder.txtAbout;
       TextView txtDetail=holder.txtDetail;

       ImageView edit=holder.edit;
       ImageView delete=holder.delete;

       final JobInternshipTrainingData jobInternshipTrainingData=data.get(position);

        txtTitle.setText(jobInternshipTrainingData.getProfile());
        txtDate.setText(jobInternshipTrainingData.getStartDate() + " - " + jobInternshipTrainingData.getEndDate() );
        txtAbout.setText(jobInternshipTrainingData.getOrganization() + " (" + jobInternshipTrainingData.getLocation() + ")");
        txtDetail.setText(jobInternshipTrainingData.getDescription());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Fragment fr = new JobInternshipTrainingDetails();
            Bundle bundle=new Bundle();
            bundle.putString("pageTitle",jobInternshipTrainingData.getType());
            fr.setArguments(bundle);
            ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, data.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtDate,txtAbout,txtDetail;
        ImageView delete,edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtDate=itemView.findViewById(R.id.txtDate);
            txtAbout=itemView.findViewById(R.id.txtAbout);
            txtDetail=itemView.findViewById(R.id.txtDetail);
            delete=itemView.findViewById(R.id.delete);
            edit=itemView.findViewById(R.id.edit);

        }
    }
}
