package com.buddheshwar.internshiparoma.resume;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buddheshwar.internshiparoma.R;

import java.util.Calendar;
import java.util.Date;

public class ResumeDetails extends Fragment implements CompoundButton.OnCheckedChangeListener {


    public ResumeDetails() {
        // Required empty public constructor
    }

    RelativeLayout actionResume;
    TextView resumeTitle,descriptionNo,start,end,addDetailInfo;
    ImageView home;
    EditText description,title,projectLink;
    Button save;
    final Calendar mycalender=Calendar.getInstance();
    CheckBox statusOfDetail;

    private String pageTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_resume_details, container, false);

        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.resume_title);
        home=getActivity().findViewById(R.id.home);


        save=view.findViewById(R.id.save);

        description=view.findViewById(R.id.description);
        descriptionNo=view.findViewById(R.id.descriptionNo);
        start=view.findViewById(R.id.start);
        end=view.findViewById(R.id.end);
        statusOfDetail=view.findViewById(R.id.statusOfDetail);
        addDetailInfo=view.findViewById(R.id.addDetailInfo);
        title=view.findViewById(R.id.title);
        projectLink=view.findViewById(R.id.projectLink);

        statusOfDetail.setOnCheckedChangeListener(this);

        home.setVisibility(View.VISIBLE);

        pageTitle=getArguments().getString("pageTitle");

        switch (pageTitle){
            case "project":
                resumeTitle.setText("Project Details");

                break;
            case "detail":
                resumeTitle.setText("Add Details");
                addDetailInfo.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                end.setVisibility(View.GONE);
                start.setVisibility(View.GONE);
                statusOfDetail.setVisibility(View.GONE);
                projectLink.setVisibility(View.GONE);
                description.setHint("Work Details");
                break;
            case "responsibility":
                resumeTitle.setText("Responsibility Details");
                addDetailInfo.setText(getString(R.string.responsibility));
                addDetailInfo.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                end.setVisibility(View.GONE);
                start.setVisibility(View.GONE);
                statusOfDetail.setVisibility(View.GONE);
                projectLink.setVisibility(View.GONE);
                description.setHint("Work Details");
                break;

            default:
                break;


        }


        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              descriptionNo.setText(String.valueOf(i+i2) + "/250");
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePicker(start);

            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePicker(end);

            }
        });

        return view;
    }

    private void showDatePicker(final TextView tv) {

        final DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mycalender.set(Calendar.YEAR,i);
                mycalender.set(Calendar.MONTH,i1);
                mycalender.set(Calendar.DAY_OF_MONTH,i2);
                if(i1<9){
                    tv.setText(i + "-" + "0" + (i1+1));
                }
                else{
                    tv.setText(i + "-" + (i1+1));
                }
            }
        };

        DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(),date,mycalender.get(Calendar.YEAR),mycalender.get(Calendar.MONTH),mycalender.get(Calendar.DAY_OF_MONTH));
        Date year=new Date();
        datePickerDialog.getDatePicker().setMaxDate(year.getTime());
        datePickerDialog.show();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(statusOfDetail.isChecked()){
            end.setText("Present");
            end.setEnabled(false);
        }
        else{
            end.setText("End Date");
            end.setEnabled(true);
        }
    }
}
