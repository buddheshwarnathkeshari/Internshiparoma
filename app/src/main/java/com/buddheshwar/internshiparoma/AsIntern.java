package com.buddheshwar.internshiparoma;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AsIntern extends AppCompatActivity {

    AutoCompleteTextView ac,acCity;
    private RequestQueue requestQueue;
    private String apikey="AIzaSyBvzY_qtuY_6t3aiCC9D3RjjorEQXgUe5Y";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_intern);

        requestQueue = Volley.newRequestQueue(AsIntern.this);

        ac=findViewById(R.id.actv);
        acCity=findViewById(R.id.ac_city);
        String[] list=new String[]{"Ms.","Mr.","Mrs."};
        ArrayAdapter adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        ac.setAdapter(adapter);
        ac.setInputType(0);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ac.showDropDown();
            }
        });

        acCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String url="https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + acCity.getText().toString() + "&key=" + apikey;
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
                                            acCity.setAdapter(adapter);
                                            acCity.setThreshold(3);
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


                            if(error instanceof TimeoutError||error instanceof NoConnectionError){
                                Toast.makeText(getApplicationContext(),""+error.toString(),Toast.LENGTH_SHORT).show();

                                AlertDialog.Builder builder=new AlertDialog.Builder(AsIntern.this);
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

/*
        EditText currentCity=((EditText)findViewById(R.id.places_autocomplete_search_input));

        ((View)findViewById(R.id.places_autocomplete_search_button)).setVisibility(View.GONE);
        ((View)findViewById(R.id.places_autocomplete_clear_button)).setVisibility(View.GONE);

        currentCity.setBackgroundResource(R.drawable.et_back);
        currentCity.setHint("Current city");
        currentCity.setMaxLines(1);
        currentCity.setHintTextColor(getResources().getColor(R.color.light));
        currentCity.setPadding(15,10,10,10);
        currentCity.setTextColor(getResources().getColor(R.color.dark));
        currentCity.setTextSize(18);*/

      /*  if(!Places.isInitialized()){
            Places.initialize(getApplicationContext(),apikey);

        }

        PlacesClient placesClient= Places.createClient(this);


        AutocompleteSupportFragment autocompleteSupportFragment=(AutocompleteSupportFragment)getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteSupportFragment.setPlaceFields(Arrays.asList(Place.Field.ID,Place.Field.NAME));
        autocompleteSupportFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {

            }

            @Override
            public void onError(@NonNull Status status) {

                Toast.makeText(getApplicationContext(),status.toString(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void goToAsIntern2(View view) {
        Intent i=new Intent(AsIntern.this,AsIntern2.class);
        i.putExtra("DataStringArray",new String[]{"","",""});
        startActivity(i);

    }
}
