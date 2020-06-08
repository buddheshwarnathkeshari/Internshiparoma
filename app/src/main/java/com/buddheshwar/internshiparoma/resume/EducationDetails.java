package com.buddheshwar.internshiparoma.resume;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.text.InputType;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.buddheshwar.internshiparoma.R;

import java.util.Date;

public class EducationDetails extends Fragment {

    public EducationDetails() {
        // Required empty public constructor
    }

    RelativeLayout actionResume;
    TextView resumeTitle,status;
    ImageView home;
    EditText college,performance,streamSchool,degreeBoard;
    AutoCompleteTextView intermediateStream,scale,startYr,endYr;
    final Date d=new Date();
    final int year=d.getYear() + 1900;
    Button save;
    private String title;
    private String[] startYrList,endYrList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_education_details, container, false);

        title=getArguments().getString("title");

        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.title);
        home=getActivity().findViewById(R.id.home);

        college=view.findViewById(R.id.college);
        startYr=view.findViewById(R.id.startYr);
        endYr=view.findViewById(R.id.endYr);
        scale=view.findViewById(R.id.scale);
        performance=view.findViewById(R.id.performance);
        streamSchool=view.findViewById(R.id.streamSchool);
        degreeBoard=view.findViewById(R.id.degreeBoard);
        intermediateStream=view.findViewById(R.id.intermediateStream);

        status=view.findViewById(R.id.status);
        save=view.findViewById(R.id.save);

        home.setVisibility(View.VISIBLE);

        startYrList=new String[41];
        for (int i = 0; i <= 40; i++) {
            startYrList[i]=String.valueOf(year-i);
        }
        endYrList=new String[47];
        for (int i = -6; i <= 40; i++) {
            endYrList[i+6]=String.valueOf(year-i);
        }

        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(20,10,20,10);
        lp.weight = 2;

        switch (title){
            case "secondary":
                resumeTitle.setText("X(Secondary) Details");
                status.setText("Matriculation status");
                college.setVisibility(View.GONE);
                endYr.setVisibility(View.GONE);
                startYr.setLayoutParams(lp);
                startYr.setHint("Year of completion");
                degreeBoard.setHint("Board");


                streamSchool.setHint("School");
                break;
            case "seniorSecondary":
                resumeTitle.setText("XII(Senior Secondary) Details");
                status.setText("Intermediate status");
                college.setVisibility(View.GONE);
                endYr.setVisibility(View.GONE);
                startYr.setLayoutParams(lp);
                startYr.setHint("Year of completion");
                intermediateStream.setVisibility(View.VISIBLE);
                degreeBoard.setHint("Board");
                streamSchool.setHint("School");
                break;
            case "graduation":
                resumeTitle.setText("Graduation Details");
                status.setText("Graduation status");
                break;
            case "post":
                resumeTitle.setText("Post Graduation Details");
                status.setText("Post Graduation status");
                break;
            case "diploma":
                resumeTitle.setText("Diploma Details");
                status.setText("Diploma status");
                degreeBoard.setVisibility(View.GONE);
                break;
            case "phd":
                resumeTitle.setText("PhD Details");
                status.setText("PhD status");
                degreeBoard.setVisibility(View.GONE);
                break;
            default:
                break;


        }


        startYr.setInputType(InputType.TYPE_NULL);

        ArrayAdapter adapter2=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,startYrList);
        startYr.setAdapter(adapter2);
        startYr.setInputType(0);

        startYr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startYr.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    startYr.showDropDown();
                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startYr.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_grey_caret_down), null);
                    }

                }
            }
        });

        startYr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startYr.showDropDown();
            }
        });

        endYr.setInputType(InputType.TYPE_NULL);
        ArrayAdapter adapter3=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,endYrList);
        endYr.setAdapter(adapter3);
        endYr.setInputType(0);

        endYr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        endYr.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    endYr.showDropDown();
                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        endYr.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_grey_caret_down), null);
                    }

                }
            }
        });

        endYr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endYr.showDropDown();
            }
        });

        String[] list4=new String[]{"Percentage","CGPA 10","CGPA 9","CGPA 8", "CGPA 7","CGPA 6","CGPA 5"};
        ArrayAdapter adapter4=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list4);
        scale.setAdapter(adapter4);
        scale.setInputType(0);

        scale.setInputType(InputType.TYPE_NULL);

        scale.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        scale.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    scale.showDropDown();
                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        scale.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_grey_caret_down), null);
                    }

                }
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scale.showDropDown();
            }
        });


        String[] list5=new String[]{"Science","Commerce","Arts"};
        ArrayAdapter adapter5=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list5);
        intermediateStream.setAdapter(adapter5);
        intermediateStream.setInputType(0);

        intermediateStream.setInputType(InputType.TYPE_NULL);

        intermediateStream.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        intermediateStream.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    intermediateStream.showDropDown();

                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        intermediateStream.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_grey_caret_down), null);
                    }

                }
            }
        });

        intermediateStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intermediateStream.showDropDown();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (title){
                    case "secondary":

                        break;
                    case "seniorSecondary":

                        break;
                    case "graduation":

                        break;
                    case "post":

                        break;
                    case "diploma":

                        break;
                    case "phd":

                        break;
                    default:
                        break;
                }

            }
        });

        return view;
    }
}
