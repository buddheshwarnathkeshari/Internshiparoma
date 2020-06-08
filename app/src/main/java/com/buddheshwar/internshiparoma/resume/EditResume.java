package com.buddheshwar.internshiparoma.resume;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.adapters.EducationAdapter;
import com.buddheshwar.internshiparoma.adapters.JobInternshipTrainingAdapter;
import com.buddheshwar.internshiparoma.adapters.ProjectAdapter;
import com.buddheshwar.internshiparoma.adapters.ResumeDetailAdapter;
import com.buddheshwar.internshiparoma.adapters.SkillAdapter;
import com.buddheshwar.internshiparoma.model.EducationData;
import com.buddheshwar.internshiparoma.model.JobInternshipTrainingData;
import com.buddheshwar.internshiparoma.model.ProjectData;
import com.buddheshwar.internshiparoma.model.SkillData;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class EditResume extends Fragment implements View.OnClickListener {

    public EditResume() {
        // Required empty public constructor
    }

    //private ArrayList<Education> EducationList;

    RecyclerView recyclerViewEducation,recyclerViewJob,recyclerViewInternship,recyclerViewResponsibility,recyclerViewTraining,recyclerViewProject,recyclerViewSkill,recyclerViewWork,recyclerViewDetail;

    TextView education,job,internship,responsibility,training,project,skill,work,detail;
    ScrollView scrollView;
    View viewResume;

    private BottomSheetDialog education_Dialog;
    RelativeLayout actionResume;
    TextView resumeTitle;
    ImageView home,edit;

    private ArrayList<EducationData> educationDataArrayList=new ArrayList<EducationData>();
    private EducationAdapter educationAdapter;

    private ArrayList<String> position=new ArrayList<String>();
    private ArrayList<String> additionalDetail=new ArrayList<String>();
    private ArrayList<String> workSamples=new ArrayList<String>();

    private ResumeDetailAdapter positionAdapter,additionalDetailAdapter,workAdapter;

    private ArrayList<JobInternshipTrainingData> jobData=new ArrayList<JobInternshipTrainingData>();
    private ArrayList<JobInternshipTrainingData> internshipData=new ArrayList<JobInternshipTrainingData>();
    private ArrayList<JobInternshipTrainingData> trainingData=new ArrayList<JobInternshipTrainingData>();

    private JobInternshipTrainingAdapter jobAdapter,internshipAdapter,trainingAdapter;

    private ArrayList<ProjectData> projectData=new ArrayList<ProjectData>();

    private ProjectAdapter projectAdapter;

    private ArrayList<SkillData> skillDataArrayList=new ArrayList<SkillData>();

    private SkillAdapter skillAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit_resume, container, false);

        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.title);
        home=getActivity().findViewById(R.id.home);

        home.setVisibility(View.GONE);

        resumeTitle.setText("Resume");

        recyclerViewEducation=view.findViewById(R.id.recyclerViewEducation);
        recyclerViewJob=view.findViewById(R.id.recyclerViewJob);
        recyclerViewInternship=view.findViewById(R.id.recyclerViewInternship);
        recyclerViewResponsibility=view.findViewById(R.id.recyclerViewResponsibility);
        recyclerViewTraining=view.findViewById(R.id.recyclerViewTraining);
        recyclerViewProject=view.findViewById(R.id.recyclerViewProject);
        recyclerViewSkill=view.findViewById(R.id.recyclerViewSkill);
        recyclerViewWork=view.findViewById(R.id.recyclerViewWork);
        recyclerViewDetail=view.findViewById(R.id.recyclerViewDetail);

        scrollView=view.findViewById(R.id.scrollView);
        viewResume=view.findViewById(R.id.viewResume);

        edit=view.findViewById(R.id.edit);

        education=view.findViewById(R.id.education);
        job=view.findViewById(R.id.job);
        internship=view.findViewById(R.id.internship);
        responsibility=view.findViewById(R.id.responsibility);
        training=view.findViewById(R.id.training);
        project=view.findViewById(R.id.project);
        skill=view.findViewById(R.id.skill);
        work=view.findViewById(R.id.work);
        detail=view.findViewById(R.id.details);

        education_Dialog = new BottomSheetDialog(getContext());

        educationAdapter = new EducationAdapter(getContext(), educationDataArrayList, recyclerViewEducation);

        education_Dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });

        positionAdapter = new ResumeDetailAdapter(getContext(), position, recyclerViewResponsibility,"responsibility");
        workAdapter = new ResumeDetailAdapter(getContext(), workSamples, recyclerViewWork,"workSample");
        additionalDetailAdapter = new ResumeDetailAdapter(getContext(), additionalDetail, recyclerViewDetail,"additionalDetails");

        jobAdapter = new JobInternshipTrainingAdapter(getContext(), jobData, recyclerViewResponsibility);
        internshipAdapter = new JobInternshipTrainingAdapter(getContext(), internshipData, recyclerViewWork);
        trainingAdapter = new JobInternshipTrainingAdapter(getContext(), trainingData, recyclerViewDetail);

        projectAdapter=new ProjectAdapter(getContext(),projectData,recyclerViewProject);

        skillAdapter=new SkillAdapter(getContext(),skillDataArrayList,recyclerViewSkill);

         addData();

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDailog();
            }
        });
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new JobInternshipTrainingDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","job");
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        internship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new JobInternshipTrainingDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","internship");
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        responsibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new ResumeDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","responsibility");
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new JobInternshipTrainingDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","training");
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new ResumeDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","project");
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new Skill();

                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new WorkSample();
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new ResumeDetails();
                Bundle bundle=new Bundle();
                bundle.putString("pageTitle","detail");
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new PersonalDetails();
                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();

            }
        });


        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView != null) {
                    if (scrollView.getScrollY()==0) {
                        viewResume.setVisibility(View.INVISIBLE);

                    }
                    else {
                        viewResume.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager7 = new LinearLayoutManager(getContext());
        LinearLayoutManager linearLayoutManager8 = new LinearLayoutManager(getContext());

        recyclerViewResponsibility.setLayoutManager(linearLayoutManager);
        recyclerViewResponsibility.setAdapter(positionAdapter);

        recyclerViewWork.setLayoutManager(linearLayoutManager1);
        recyclerViewWork.setAdapter(workAdapter);

        recyclerViewDetail.setLayoutManager(linearLayoutManager2);
        recyclerViewDetail.setAdapter(additionalDetailAdapter);

        recyclerViewJob.setLayoutManager(linearLayoutManager3);
        recyclerViewJob.setAdapter(jobAdapter);

        recyclerViewInternship.setLayoutManager(linearLayoutManager4);
        recyclerViewInternship.setAdapter(internshipAdapter);

        recyclerViewTraining.setLayoutManager(linearLayoutManager5);
        recyclerViewTraining.setAdapter(trainingAdapter);

        recyclerViewProject.setLayoutManager(linearLayoutManager6);
        recyclerViewProject.setAdapter(projectAdapter);

        recyclerViewSkill.setLayoutManager(linearLayoutManager7);
        recyclerViewSkill.setAdapter(skillAdapter);

        recyclerViewEducation.setLayoutManager(linearLayoutManager8);
        recyclerViewEducation.setAdapter(educationAdapter);

        return  view;
    }

    private void addData() {

            educationDataArrayList.add(new EducationData("graduation",2017,2021,"National Institute of Technology, Patna","Bachelor of Technology(B.tech)","Electronics and Communication Department","CGPA 10",7.52f));
        educationAdapter.notifyItemInserted(educationDataArrayList.size() - 1);

        educationDataArrayList.add(new EducationData("secondary",2015,"Central Board of Secondary Education","St Annes High School","CGPA 10",10));
        educationAdapter.notifyItemInserted(educationDataArrayList.size() - 1);

        educationDataArrayList.add(new EducationData("seniorSecondary",2017,"Central Board of Secondary Education","St Annes High School","Science","Percentage",90));
        educationAdapter.notifyItemInserted(educationDataArrayList.size() - 1);


        position.add("Secured first position in inter Debate Competition organized by St Annes High School,Patna");
        positionAdapter.notifyItemInserted(position.size() - 1);

        workSamples.add("work sample");
        workAdapter.notifyItemInserted(workSamples.size() - 1);

        additionalDetail.add("additional details");
        additionalDetailAdapter.notifyItemInserted(additionalDetail.size() - 1);


        JobInternshipTrainingData jobDataEntry=new JobInternshipTrainingData("job","Android Developer","Myemmo","Work From Home","12-2019","02-2020","Description should be here");

        JobInternshipTrainingData internshipDataEntry=new JobInternshipTrainingData("internship","Android Developer","Iniesta","Work From Home","04-2020","06-2020","Description should be here");

        JobInternshipTrainingData trainingDataEntry=new JobInternshipTrainingData("training","Android Developer","Training center","Kolkata","11-2020","12-2020","Description should be here");

        ProjectData projectDataEntry=new ProjectData("Resume Maker App","12-03-2020","12-05-2020","description about project","link of project");

        SkillData skillData=new SkillData("Java","Intermediate");

        jobData.add(jobDataEntry);
        jobAdapter.notifyItemInserted(jobData.size() -1);

        internshipData.add(internshipDataEntry);
        internshipAdapter.notifyItemInserted(internshipData.size() -1);

        trainingData.add(trainingDataEntry);
        trainingAdapter.notifyItemInserted(trainingData.size() -1);

        projectData.add(projectDataEntry);
        projectAdapter.notifyItemInserted(projectData.size() -1);

        skillDataArrayList.add(skillData);
        skillAdapter.notifyItemInserted(skillDataArrayList.size() -1);
    }

    private void showDailog() {

        education_Dialog.setContentView(R.layout.education_list);

        Button secondary = education_Dialog.findViewById(R.id.secondary);
        Button seniorSecondary = education_Dialog.findViewById(R.id.seniorSecondary);
        Button graduation = education_Dialog.findViewById(R.id.graduation);
        Button post = education_Dialog.findViewById(R.id.post);
        Button phd = education_Dialog.findViewById(R.id.phd);
        Button diploma = education_Dialog.findViewById(R.id.diploma);
        education_Dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        education_Dialog.show();

        secondary.setOnClickListener(this);
        seniorSecondary.setOnClickListener(this);
        graduation.setOnClickListener(this);
        post.setOnClickListener(this);
        phd.setOnClickListener(this);
        diploma.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Fragment fr = new EducationDetails();
        Bundle bundle=new Bundle();
        switch (view.getId()) {
            case R.id.secondary:
                bundle.putString("title","secondary");
                break;
            case R.id.seniorSecondary:
                bundle.putString("title","seniorSecondary");
                break;
            case R.id.graduation:
                bundle.putString("title","graduation");
                break;
            case R.id.post:
                bundle.putString("title","post");
                break;
            case R.id.diploma:
                bundle.putString("title","diploma");
                break;
            case R.id.phd:
                bundle.putString("title","phd");
                break;
            default:
                break;

        }
        fr.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
        education_Dialog.cancel();
    }
}
