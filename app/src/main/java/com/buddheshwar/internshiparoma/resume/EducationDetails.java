package com.buddheshwar.internshiparoma.resume;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buddheshwar.internshiparoma.R;

import java.util.Date;

public class EducationDetails extends Fragment {

    public EducationDetails() {
        // Required empty public constructor
    }

    RelativeLayout actionResume;
    TextView resumeTitle,status;
    ImageView home;
    EditText college,performance,streamSchool,degreeBoard,startYr,endYr,scale,intermediateStream;
    final Date d=new Date();
    final int year=d.getYear() + 1900;
    Button save;
    private String title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_education_details, container, false);

        title=getArguments().getString("title");

        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.resume_title);
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

        startYr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startYr.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                   showDailog(startYr,0);

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
                showDailog(startYr,0);
            }
        });

        endYr.setInputType(InputType.TYPE_NULL);
        endYr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        endYr.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    showDailog(endYr,-6);

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
                showDailog(endYr,-6);
            }
        });

        scale.setInputType(InputType.TYPE_NULL);

        scale.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        scale.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                       showScale(scale);
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
               showScale(scale);
            }
        });




        intermediateStream.setInputType(InputType.TYPE_NULL);

        intermediateStream.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        intermediateStream.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    showStream(intermediateStream);
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
                showStream(intermediateStream);
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

    private void showScale(final EditText scale) {

        PopupMenu menu = new PopupMenu(getContext(), scale);
        menu.getMenu().add("Percentage");
        menu.getMenu().add("CGPA 10");
        menu.getMenu().add("CGPA 9");
        menu.getMenu().add("CGPA 8");
        menu.getMenu().add("CGPA 7");
        menu.getMenu().add("CGPA 6");
        menu.getMenu().add("CGPA 5");

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                scale.setText(" " + item.getTitle() + " ");

                return true;
            }

        });

        menu.show();
    }

    private void showDailog(final EditText et, int j) {

        PopupMenu menu = new PopupMenu(getContext(), et);
        for (int i = j; i <= 40; i++) {
            menu.getMenu().add(String.valueOf(year-i));
        }
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                et.setText(" " + item.getTitle() + " ");

                return true;
            }

        });

        menu.show();

    }
    private void showStream(final EditText et) {

        PopupMenu menu = new PopupMenu(getContext(), et);

        menu.getMenu().add("Science");
        menu.getMenu().add("Commerce");
        menu.getMenu().add("Arts");

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                et.setText(" " + item.getTitle() + " ");

                return true;
            }

        });

        menu.show();

    }
}
