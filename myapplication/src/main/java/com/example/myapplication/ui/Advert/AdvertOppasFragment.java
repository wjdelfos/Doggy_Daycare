package com.example.myapplication.ui.Advert;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class AdvertOppasFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner Type;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.advert_create_oppas_main, container, false);

        Type = (Spinner) v.findViewById(R.id.TypeCare);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Type.setAdapter(adapter);
        Type.setOnItemSelectedListener(this);

       /* @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            parent.getItemAtPosition(pos)

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
*/


        Button createAdvert = (Button) v.findViewById(R.id.createadvert);
        createAdvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //TODO create account
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        EditText Price = (EditText) v.findViewById(R.id.price);
        Price.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update Price
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText Startdate = (EditText) v.findViewById(R.id.startDate);
        Startdate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update startdate
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText Enddate = (EditText) v.findViewById(R.id.endDate);
        Enddate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update End date
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText Starttime = (EditText) v.findViewById(R.id.startTime);
        Starttime.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update start time
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText EndTime = (EditText) v.findViewById(R.id.endTime);
        EndTime.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("variables",s.toString());

                //TODO end time
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
        EditText Capacity = (EditText) v.findViewById(R.id.capacity);
        Capacity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update capacity
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText experience = (EditText) v.findViewById(R.id.experience);
        Capacity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update experience
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i("variables","Deus ex machina");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}