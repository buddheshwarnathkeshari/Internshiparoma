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
import com.buddheshwar.internshiparoma.model.EducationData;
import com.buddheshwar.internshiparoma.model.JobInternshipTrainingData;
import com.buddheshwar.internshiparoma.resume.EducationDetails;
import com.buddheshwar.internshiparoma.resume.JobInternshipTrainingDetails;

import java.util.ArrayList;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {
    private ArrayList<EducationData> educationDataArrayList;
    private Context context;

    public EducationAdapter(Context context, ArrayList<EducationData> educationDataArrayList, RecyclerView recyclerViewEducation) {
        this.context=context;
        this.educationDataArrayList=educationDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.education_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TextView educationTitle=holder.educationTitle;
        TextView educationFrom=holder.educationFrom;
        TextView marks=holder.marks;

        ImageView edit=holder.edit;
        ImageView delete=holder.delete;

        final EducationData educationData=educationDataArrayList.get(position);

        switch (educationData.getType()) {
            case "secondary":
                educationTitle.setText("X(Secondary) ." + educationData.getYear() );
                educationFrom.setText(educationData.getBoard() + "  (" + educationData.getSchool() + ")" );
                if(educationData.getPerformanceScale().contains("CGPA")) {
                    marks.setText(String.valueOf(educationData.getPerformance()) + "/" + educationData.getPerformanceScale().substring(5) );
                }
                else{
                    marks.setText(String.valueOf(educationData.getPerformance()) + "%" );
                }

                break;
            case "seniorSecondary":
                educationTitle.setText("XII(Senior Secondary)," + educationData.getStream() + "." + educationData.getYear() );
                educationFrom.setText(educationData.getBoard() + "  (" + educationData.getSchool() + ")" );
                if(educationData.getPerformanceScale().contains("CGPA")) {
                    marks.setText(String.valueOf(educationData.getPerformance()) + "/" + educationData.getPerformanceScale().substring(5) );
                }
                else{
                    marks.setText(String.valueOf(educationData.getPerformance()) + "%" );
                }

                break;
            case "graduation":
            case "post":
                educationTitle.setText(educationData.getDegree() + ", " + educationData.getStream() );
                educationFrom.setText(educationData.getCollege() + "  (" + educationData.getStartYear() + "-" + educationData.getEndYear() + ")" );
                if(educationData.getPerformanceScale().contains("CGPA")) {
                    marks.setText(String.valueOf(educationData.getPerformance()) + "/" + educationData.getPerformanceScale().substring(5) );
                }
                else{
                    marks.setText(String.valueOf(educationData.getPerformance()) + "%" );
                }

                break;
            case "diploma":
            case "phd":
                educationTitle.setText(educationData.getStream() );
                educationFrom.setText(educationData.getCollege() + "  (" + educationData.getStartYear() + "-" + educationData.getEndYear() + ")" );
                if(educationData.getPerformanceScale().contains("CGPA")) {
                    marks.setText(String.valueOf(educationData.getPerformance()) + "/" + educationData.getPerformanceScale().substring(5) );
                }
                else{
                    marks.setText(String.valueOf(educationData.getPerformance()) + "%" );
                }
                break;
            default:
                break;

        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fr = new EducationDetails();
                Bundle bundle=new Bundle();
                bundle.putString("title",educationData.getType());
                fr.setArguments(bundle);
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                educationDataArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, educationDataArrayList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return educationDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView educationTitle,educationFrom,marks;
        ImageView delete,edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            educationTitle=itemView.findViewById(R.id.educationTitle);
            educationFrom=itemView.findViewById(R.id.educationFrom);
            marks=itemView.findViewById(R.id.marks);
            delete=itemView.findViewById(R.id.delete);
            edit=itemView.findViewById(R.id.edit);

        }    }
}
