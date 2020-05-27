//package com.buddheshwar.internshiparoma.resume;
//
//import android.content.DialogInterface;
//import android.graphics.Typeface;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.buddheshwar.internshiparoma.R;
//import com.buddheshwar.internshiparoma.adaptersForResume.EducationAdapter;
//import com.buddheshwar.internshiparoma.modelForResume.AfterIntermediateData;
//import com.google.android.material.bottomsheet.BottomSheetDialog;
//
//import java.util.ArrayList;
//
//
//public class EditResume extends Fragment implements View.OnClickListener {
//
//    public EditResume() {
//        // Required empty public constructor
//    }
//
//   // private ArrayList<Education> EducationList;
//
//    RecyclerView recyclerViewEducation,recyclerViewJob,recyclerViewInternship,recyclerViewResponsibility,recyclerViewTraining,recyclerViewProject,recyclerViewSkill,recyclerViewWork,recyclerViewDetail;
//
//    TextView education,job,internship,responsibility,training,project,skill,work,detail;
//    ScrollView scrollView;
//    View viewResume;
//
//    private BottomSheetDialog education_Dialog;
//    RelativeLayout actionResume;
//    TextView resumeTitle;
//    ImageView home,edit;
//
//    private ArrayList<AfterIntermediateData> graduationList;
//    private EducationAdapter recylerViewAdapter;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view=inflater.inflate(R.layout.fragment_edit_resume, container, false);
//
//        actionResume=getActivity().findViewById(R.id.actionResume);
//        resumeTitle=getActivity().findViewById(R.id.title);
//        home=getActivity().findViewById(R.id.home);
//
//        home.setVisibility(View.GONE);
//
//        resumeTitle.setText("Resume");
//
//
//        graduationList=new ArrayList<AfterIntermediateData>();
//
//        recyclerViewEducation=view.findViewById(R.id.recyclerViewEducation);
//        recyclerViewJob=view.findViewById(R.id.recyclerViewJob);
//        recyclerViewInternship=view.findViewById(R.id.recyclerViewInternship);
//        recyclerViewResponsibility=view.findViewById(R.id.recyclerViewResponsibility);
//        recyclerViewTraining=view.findViewById(R.id.recyclerViewTraining);
//        recyclerViewProject=view.findViewById(R.id.recyclerViewProject);
//        recyclerViewSkill=view.findViewById(R.id.recyclerViewSkill);
//        recyclerViewWork=view.findViewById(R.id.recyclerViewWork);
//        recyclerViewDetail=view.findViewById(R.id.recyclerViewDetail);
//
//        scrollView=view.findViewById(R.id.scrollView);
//        viewResume=view.findViewById(R.id.viewResume);
//
//        edit=view.findViewById(R.id.edit);
//
//        education=view.findViewById(R.id.education);
//        job=view.findViewById(R.id.job);
//        internship=view.findViewById(R.id.internship);
//        responsibility=view.findViewById(R.id.responsibility);
//        training=view.findViewById(R.id.training);
//        project=view.findViewById(R.id.project);
//        skill=view.findViewById(R.id.skill);
//        work=view.findViewById(R.id.work);
//        detail=view.findViewById(R.id.details);
//
//        education_Dialog = new BottomSheetDialog(getContext());
//
//        recylerViewAdapter = new EducationAdapter(getContext(), graduationList, recyclerViewEducation);
//
//        graduationList.add(new AfterIntermediateData("graduation",2017,2021,"National Institute of Technology, Patna","Electronics and Communication Department","CGPA(10)",7.52f));
//
//        education_Dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                dialog.dismiss();
//            }
//        });
//
//        education.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDailog();
//            }
//        });
//        job.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new JobInternshipTrainingDetails();
//                Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","job");
//                fr.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        internship.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new JobInternshipTrainingDetails();
//                Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","internship");
//                fr.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        responsibility.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new ResumeDetails();
//                Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","responsibility");
//                fr.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        training.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new JobInternshipTrainingDetails();
//                Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","training");
//                fr.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        project.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new ResumeDetails();
//                Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","project");
//                fr.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        skill.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new Skill();
//               /* Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","project");
//                fr.setArguments(bundle);*/
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        work.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new WorkSample();
//               /* Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","project");
//                fr.setArguments(bundle);*/
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//        detail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new ResumeDetails();
//                Bundle bundle=new Bundle();
//                bundle.putString("pageTitle","detail");
//                fr.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fr = new PersonalDetails();
//                getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//
//            }
//        });
//
//
//        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                if (scrollView != null) {
//                    if (scrollView.getScrollY()==0) {
//                        viewResume.setVisibility(View.INVISIBLE);
//
//                    }
//                    else {
//                        viewResume.setVisibility(View.VISIBLE);
//                    }
//                }
//            }
//        });
//
//        return  view;
//    }
//
//    private void showDailog() {
//
//        education_Dialog.setContentView(R.layout.education_list);
//
//        Button secondary = education_Dialog.findViewById(R.id.secondary);
//        Button seniorSecondary = education_Dialog.findViewById(R.id.seniorSecondary);
//        Button graduation = education_Dialog.findViewById(R.id.graduation);
//        Button post = education_Dialog.findViewById(R.id.post);
//        Button phd = education_Dialog.findViewById(R.id.phd);
//        Button diploma = education_Dialog.findViewById(R.id.diploma);
//        education_Dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
//
//        education_Dialog.show();
//
//        secondary.setOnClickListener(this);
//        seniorSecondary.setOnClickListener(this);
//        graduation.setOnClickListener(this);
//        post.setOnClickListener(this);
//        phd.setOnClickListener(this);
//        diploma.setOnClickListener(this);
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        Fragment fr = new EducationDetails();
//        Bundle bundle=new Bundle();
//        switch (view.getId()) {
//            case R.id.secondary:
//                bundle.putString("title","secondary");
//                break;
//            case R.id.seniorSecondary:
//                bundle.putString("title","seniorSecondary");
//                break;
//            case R.id.graduation:
//                bundle.putString("title","graduation");
//                break;
//            case R.id.post:
//                bundle.putString("title","post");
//                break;
//            case R.id.diploma:
//                bundle.putString("title","diploma");
//                break;
//            case R.id.phd:
//                bundle.putString("title","phd");
//                break;
//            default:
//                break;
//
//        }
//        fr.setArguments(bundle);
//        getFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
//        education_Dialog.cancel();
//    }
//}
