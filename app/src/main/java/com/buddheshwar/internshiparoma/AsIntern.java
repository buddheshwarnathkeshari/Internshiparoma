package com.buddheshwar.internshiparoma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;


public class AsIntern extends AppCompatActivity {
AutoCompleteTextView ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_intern);
        ac=findViewById(R.id.actv);
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





        EditText currentCity=((EditText)findViewById(R.id.places_autocomplete_search_input));

        ((View)findViewById(R.id.places_autocomplete_search_button)).setVisibility(View.GONE);
        ((View)findViewById(R.id.places_autocomplete_clear_button)).setVisibility(View.GONE);

        currentCity.setBackgroundResource(R.drawable.et_back);
        currentCity.setHint("Current city");
        currentCity.setMaxLines(1);
        currentCity.setHintTextColor(getResources().getColor(R.color.light));
        currentCity.setPadding(15,10,10,10);
        currentCity.setTextColor(getResources().getColor(R.color.dark));
        currentCity.setTextSize(18);

        String apikey=getString(R.string.GOOGLE_PLACE_API_KEY);
        if(!Places.isInitialized()){
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
        });







    }


    public void goToAsIntern2(View view) {

        startActivity(new Intent(AsIntern.this,AsIntern2.class));

    }
}
