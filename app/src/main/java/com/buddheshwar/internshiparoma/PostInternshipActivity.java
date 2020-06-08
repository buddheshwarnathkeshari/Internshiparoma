package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.buddheshwar.internshiparoma.adapters.DataAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PostInternshipActivity extends AppCompatActivity {
    ViewFlipper vf;

    int viewNumber;
    EditText etAbout,internshipPosition,etQuestions;
    TextView etStartDate,etLastDateToApply;
    AutoCompleteTextView ac,ac1st,ac_city;
    Button btn;
    TextView tv,tvToAdd;
    final Calendar mycalender=Calendar.getInstance();
    RadioButton fullTime,workFromHome;
    RadioGroup radioGroup;
    private String apikey="AIzaSyBvzY_qtuY_6t3aiCC9D3RjjorEQXgUe5Y";
    private RequestQueue requestQueue;
    RelativeLayout questionLayout;
    Button save;
    RecyclerView list;

    ArrayList<String> questions=new ArrayList<String>();
    DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_internship);

        requestQueue = Volley.newRequestQueue(PostInternshipActivity.this);

        viewNumber=1;

        vf=findViewById(R.id.vf_details);
        questionLayout=findViewById(R.id.questionLayout);
        tvToAdd=findViewById(R.id.tvToAdd);
        save=findViewById(R.id.save);
        list=findViewById(R.id.list);
        etQuestions=findViewById(R.id.et_question);
        ac_city=findViewById(R.id.ac_city);
        btn=findViewById(R.id.btn_continue);
        tv=findViewById(R.id.tv);
        fullTime=findViewById(R.id.fullTime);
        workFromHome=findViewById(R.id.work_from_home);
        internshipPosition=findViewById(R.id.internship_position);
        radioGroup=findViewById(R.id.radioGroup);

        dataAdapter=new DataAdapter(getApplicationContext(),questions,list);

        tvToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etQuestions.setText("");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    etQuestions.requestFocus();
                }
                questionLayout.setVisibility(View.VISIBLE);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etQuestions.getText().toString().trim().isEmpty()){
                    Toast.makeText(PostInternshipActivity.this, "Question is empty.Write something to proceed!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    questionLayout.setVisibility(View.GONE);
                    questions.add(etQuestions.getText().toString());
                    dataAdapter.notifyItemInserted(questions.size()-1);

                }
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(linearLayoutManager);
        list.setAdapter(dataAdapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(fullTime.isChecked()){
                    ac_city.setVisibility(View.VISIBLE);
                }
                else{
                    ac_city.setVisibility(View.GONE);

                }
            }
        });

        ac_city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String url="https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + ac_city.getText().toString() + "&key=" + apikey;
                if((i+i2)==3){

                    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                            Request.Method.GET,
                            url,
                            null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {

                                    try {
                                        String status=response.getString("status");
                                        JSONArray prediction=response.getJSONArray("predictions");
                                        if(status.equalsIgnoreCase("ok")) {

                                            String[] list2=new String[prediction.length()];

                                            for(int i=0;i<prediction.length();i++){
                                                JSONObject jsonObject= prediction.getJSONObject(i);
                                                String description=jsonObject.getString("description");
                                                list2[i]=description;
                                            }
                                            ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list2);
                                            ac_city.setAdapter(adapter);
                                            ac_city.setThreshold(3);
                                        }
                                        else{
                                            Log.d("msg",status);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onErrorResponse(VolleyError error) {


                            if(error instanceof TimeoutError ||error instanceof NoConnectionError){
                                AlertDialog.Builder builder=new AlertDialog.Builder(PostInternshipActivity.this);
                                builder.setMessage("You are currenly offline, please connect to internet.")
                                        .setCancelable(false)
                                        .setIcon(R.drawable.ic_info_outline_black_24dp)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {


                                            }
                                        });
                                AlertDialog alertDialog=builder.create();
                                alertDialog.setTitle("No Connection");
                                alertDialog.show();

                                Button btnDialogOk=alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                                btnDialogOk.setTextColor(getResources().getColor(R.color.dark));

                            }
                        }
                    });
                    requestQueue.add(jsonObjectRequest);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });


        etStartDate=findViewById(R.id.et_start_date);
        etLastDateToApply=findViewById(R.id.et_last_date_to_apply);
        etAbout=findViewById(R.id.et_about);
        final TextView tvcount=findViewById(R.id.counter);

        
        ac=findViewById(R.id.actv);
        ac1st=findViewById(R.id.actv1);

        String[] duration=new String[]{"Day","Week","Month"};
        String[] list=new String[]{"per hour","per day","per week","per month"};
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        ac.setAdapter(adapter);
        ac.setInputType(0);

        ac.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    ac.showDropDown();
            }
        });

        ArrayAdapter adapter2=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,duration);
        ac1st.setAdapter(adapter2);
        ac1st.setInputType(0);

        ac1st.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    ac1st.showDropDown();
            }
        });
        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        mycalender.set(Calendar.YEAR,i);
                        mycalender.set(Calendar.MONTH,i1);
                        mycalender.set(Calendar.DAY_OF_MONTH,i2);
                        if(i1<9 && i2<9){
                            etStartDate.setText("0" + (i2) + "-0" + (i1+1) + "-" + i);
                        }
                        else if(i1<9 && i2>9){
                            etStartDate.setText(i2 + "-0" + (i1+1) + "-" + i);
                        }
                        else if(i1>9 && i2<9){
                            etStartDate.setText("0" + (i2) + "-" + (i1+1) + "-" + i);

                        }
                        else{
                            etStartDate.setText(i2 + "-" + (i1+1) + "-" + i);
                        }
                    }
                };

                DatePickerDialog datePickerDialog=new DatePickerDialog(PostInternshipActivity.this,date,mycalender.get(Calendar.YEAR),mycalender.get(Calendar.MONTH),mycalender.get(Calendar.DAY_OF_MONTH));
                Date year=new Date();

                datePickerDialog.getDatePicker().setMinDate(year.getTime());

                datePickerDialog.show();
            }
        });

        etLastDateToApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        mycalender.set(Calendar.YEAR,i);
                        mycalender.set(Calendar.MONTH,i1);
                        mycalender.set(Calendar.DAY_OF_MONTH,i2);
                        if(i1<9 && i2<9){
                            etLastDateToApply.setText("0" + (i2) + "-0" + (i1+1) + "-" + i);
                        }
                        else if(i1<9 && i2>9){
                            etLastDateToApply.setText(i2 + "-0" + (i1+1) + "-" + i);
                        }
                        else if(i1>9 && i2<9){
                            etLastDateToApply.setText("0" + (i2) + "-" + (i1+1) + "-" + i);

                        }
                        else{
                            etLastDateToApply.setText(i2 + "-" + (i1+1) + "-" + i);
                        }
                    }
                };

                DatePickerDialog datePickerDialog=new DatePickerDialog(PostInternshipActivity.this,date,mycalender.get(Calendar.YEAR),mycalender.get(Calendar.MONTH),mycalender.get(Calendar.DAY_OF_MONTH));
                Date year=new Date();

                datePickerDialog.getDatePicker().setMinDate(year.getTime());

                datePickerDialog.show();
            }
        });




        etAbout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    tvcount.setText(""+etAbout.getText().length()+"/250");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void flip(View view) {
        if(viewNumber==1) {
            vf.showNext();
            viewNumber++;
        }
        else if(viewNumber==2){
            tv.setVisibility(View.GONE);
            vf.showNext();
            viewNumber++;
        }
        else{
            startActivity(new Intent(PostInternshipActivity.this, Mainscreen.class));
        }
    }

}

