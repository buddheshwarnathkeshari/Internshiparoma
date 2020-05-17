package com.buddheshwar.internshiparoma.resume;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.buddheshwar.internshiparoma.R;


import java.util.ArrayList;


public class EditResume extends Fragment {

    public EditResume() {
        // Required empty public constructor
    }

   // private ArrayList<Education> EducationList;

    RecyclerView recyclerViewEducation,recyclerViewJob,recyclerViewInternship,recyclerViewResponsibility,recyclerViewTraining,recyclerViewProject,recyclerViewSkill,recyclerViewWork,recyclerViewDetail;

    TextView education,job,internship,responsibility,training,project,skill,work,detail;

    private Dialog education_Dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit_resume, container, false);

        recyclerViewEducation=view.findViewById(R.id.recyclerViewEducation);
        recyclerViewJob=view.findViewById(R.id.recyclerViewJob);
        recyclerViewInternship=view.findViewById(R.id.recyclerViewInternship);
        recyclerViewResponsibility=view.findViewById(R.id.recyclerViewResponsibility);
        recyclerViewTraining=view.findViewById(R.id.recyclerViewTraining);
        recyclerViewProject=view.findViewById(R.id.recyclerViewProject);
        recyclerViewSkill=view.findViewById(R.id.recyclerViewSkill);
        recyclerViewWork=view.findViewById(R.id.recyclerViewWork);
        recyclerViewDetail=view.findViewById(R.id.recyclerViewDetail);

        education=view.findViewById(R.id.education);
        job=view.findViewById(R.id.job);
        internship=view.findViewById(R.id.internship);
        responsibility=view.findViewById(R.id.responsibility);
        training=view.findViewById(R.id.training);
        project=view.findViewById(R.id.project);
        skill=view.findViewById(R.id.skill);
        work=view.findViewById(R.id.work);
        detail=view.findViewById(R.id.details);

        education_Dialog = new Dialog(getContext());

        education_Dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                education_Dialog.setContentView(R.layout.education_list);

                Button secondary = education_Dialog.findViewById(R.id.secondary);
                Button seniorSecondary = education_Dialog.findViewById(R.id.seniorSecondary);
                Button graduation = education_Dialog.findViewById(R.id.graduation);
                Button post = education_Dialog.findViewById(R.id.post);
                Button phd = education_Dialog.findViewById(R.id.phd);
                Button diploma = education_Dialog.findViewById(R.id.diploma);
                education_Dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
                education_Dialog.show();

            }
        });
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        internship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "job", Toast.LENGTH_SHORT).show();

            }
        });
        return  view;
    }
}
