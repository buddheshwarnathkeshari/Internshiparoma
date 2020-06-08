package com.buddheshwar.internshiparoma.resume;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.buddheshwar.internshiparoma.PostInternshipActivity;
import com.buddheshwar.internshiparoma.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonalDetails extends Fragment {


    public PersonalDetails() {
        // Required empty public constructor
    }

    RelativeLayout actionResume;
    TextView resumeTitle;
    ImageView home;
    AutoCompleteTextView chooseTitle;
    LinearLayout mobile;
    View viewBar;
    EditText mobileNo;
    AutoCompleteTextView currentCity,secondaryCity;

    private String apikey="AIzaSyBvzY_qtuY_6t3aiCC9D3RjjorEQXgUe5Y";
    private RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_personal_details, container, false);

        actionResume=getActivity().findViewById(R.id.actionResume);
        resumeTitle=getActivity().findViewById(R.id.title);
        home=getActivity().findViewById(R.id.home);

        chooseTitle=view.findViewById(R.id.selectTitle);
        mobile=view.findViewById(R.id.mobile);
        viewBar=view.findViewById(R.id.view);
        mobileNo=view.findViewById(R.id.mobileNo);
        currentCity=view.findViewById(R.id.currentCity);
        secondaryCity=view.findViewById(R.id.secondaryCity);

        home.setVisibility(View.VISIBLE);

        resumeTitle.setText("Personal Details");

        String[] list=new String[]{"Ms.","Mr.","Mrs."};
        ArrayAdapter adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list);
        chooseTitle.setAdapter(adapter);

        chooseTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseTitle.showDropDown();
            }
        });

        chooseTitle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        chooseTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_caret_down), null);
                    }
                    chooseTitle.showDropDown();
                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        chooseTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, getActivity().getDrawable(R.drawable.ic_grey_caret_down), null);
                    }

                }
            }
        });
        mobileNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        mobile.setBackgroundDrawable(getActivity().getDrawable(R.drawable.caret_background_box));

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        viewBar.setBackgroundColor(getActivity().getColor(R.color.caretColor));
                    }
                }
                else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        mobile.setBackgroundDrawable(getActivity().getDrawable(R.drawable.grey_button));
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        viewBar.setBackgroundColor(getActivity().getColor(R.color.educationListColor));
                    }

                }
            }
        });

        requestQueue = Volley.newRequestQueue(getContext());


        currentCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if((i+i2)==3){
                    checkAutoCompleteTextView(currentCity);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
        secondaryCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if((i+i2)==3){
                    checkAutoCompleteTextView(secondaryCity);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });


        return view;
    }

    private void checkAutoCompleteTextView(final AutoCompleteTextView autoCompleteTextView) {

        String url="https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + autoCompleteTextView.getText().toString() + "&key=" + apikey;

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
                                ArrayAdapter adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list2);
                                autoCompleteTextView.setAdapter(adapter);
                                autoCompleteTextView.setThreshold(3);
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
                    AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
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
