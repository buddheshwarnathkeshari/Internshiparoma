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

public class JobInternshipTrainingDetails extends Fragment implements CompoundButton.OnCheckedChangeListener {

    public JobInternshipTrainingDetails() {
        // Required empty public constructor
    }
    RelativeLayout actionResume;
    TextView resumeTitle,start,end,descriptionNo;
    ImageView home;

    EditText description,profile,organization,location;
    Button save;
    final Calendar mycalender=Calendar.getInstance();
    CheckBox statusOfDate,statusOfLocation;

    private String pageTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_job_internship_training_details, container, false);
        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.resume_title);
        home=getActivity().findViewById(R.id.home);

        start=view.findViewById(R.id.start);
        end=view.findViewById(R.id.end);
        statusOfDate=view.findViewById(R.id.statusOfDate);
        statusOfLocation=view.findViewById(R.id.statusOfLocation);
        description=view.findViewById(R.id.description);
        location=view.findViewById(R.id.location);
        organization=view.findViewById(R.id.organization);
        profile=view.findViewById(R.id.profile);
        descriptionNo=view.findViewById(R.id.descriptionNo);

        home.setVisibility(View.VISIBLE);

        pageTitle=getArguments().getString("pageTitle");

        switch (pageTitle){
            case "job":
                resumeTitle.setText("Job Details");
                break;
            case "internship":
                resumeTitle.setText("Internship Details");
                break;
            case "training":
                resumeTitle.setText("Training Details");
                profile.setHint("Training Program");
                statusOfLocation.setText("Online");
                statusOfDate.setText("Currently ongoing");
                description.setHint("Training Description");
                break;

            default:
                break;


        }

        statusOfLocation.setOnCheckedChangeListener(this);
        statusOfDate.setOnCheckedChangeListener(this);

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
        switch(compoundButton.getId()){
            case R.id.statusOfLocation:
                if(statusOfLocation.isChecked()){
                    if(pageTitle.equalsIgnoreCase("training")){
                        location.setText("Online");
                    }
                    else{
                        location.setText("Work From Home");

                    }
                    location.setEnabled(false);
                }
                else{
                    location.setText("");
                    location.setEnabled(true);
                    location.setFocusable(true);
                }
                break;
            case R.id.statusOfDate:
                if(statusOfDate.isChecked()){
                    end.setText("Present");
                    end.setEnabled(false);
                }
                else{
                    end.setText("");
                    end.setEnabled(true);
                    end.setFocusable(true);
                }
                break;
        }
    }
}
