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
import com.buddheshwar.internshiparoma.model.ProjectData;
import com.buddheshwar.internshiparoma.resume.JobInternshipTrainingDetails;
import com.buddheshwar.internshiparoma.resume.ResumeDetails;

import java.util.ArrayList;

public class ProjectAdapter  extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private ArrayList<ProjectData> projectArrayData;
    private Context context;

    public ProjectAdapter(Context context, ArrayList<ProjectData> projectData, RecyclerView recyclerViewProject) {

        this.projectArrayData=projectData;
        this.context=context;
    }

    @NonNull
    @Override
    public ProjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.project_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ViewHolder holder, final int position) {
        TextView txtTitle=holder.txtTitle;
        TextView txtDate=holder.txtDate;
        TextView txtLink=holder.txtLink;
        TextView txtDetail=holder.txtDetail;

        ImageView edit=holder.edit;
        ImageView delete=holder.delete;

        final ProjectData projectData=projectArrayData.get(position);

        txtTitle.setText(projectData.getTitle());
        txtDate.setText(projectData.getStartDate() + " - " + projectData.getEndDate() );
        txtLink.setText(projectData.getLink());
        txtDetail.setText(projectData.getDescription());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new ResumeDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","project");
                fr.setArguments(bundle);
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            projectArrayData.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, projectArrayData.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return projectArrayData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle,txtDate,txtDetail,txtLink;
        ImageView delete,edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtDate=itemView.findViewById(R.id.txtDate);
            txtLink=itemView.findViewById(R.id.txtLink);
            txtDetail=itemView.findViewById(R.id.txtDetail);
            delete=itemView.findViewById(R.id.delete);
            edit=itemView.findViewById(R.id.edit);
        }
    }
}
