package com.example.myapplication.ui.create_advert;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

import java.sql.Date;

public class AdvertOppasFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner Type;
    private Advertentie temp = new Advertentie();
    App_Gebruiker loggedInUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("user");
        View v = inflater.inflate(R.layout.advert_create_oppas_main, container, false);

        Type = (Spinner) v.findViewById(R.id.TypeCare);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Type.setAdapter(adapter);
        Type.setOnItemSelectedListener(this);


        Button createAdvert = (Button) v.findViewById(R.id.createadvert);
        createAdvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                temp.set_AdvertentiePlaatser(loggedInUser);
                HondenDB.get(getActivity()).addAdvertentie(temp);
                Toast.makeText(getActivity(),
                        "Advert created", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        EditText Price = (EditText) v.findViewById(R.id.price);
        Price.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp.setPrijs(Double.parseDouble(s.toString()));
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
                temp.setBeginTijd(new Date(System.currentTimeMillis()));
                try {
                    temp.setBeginTijd(Date.valueOf(s.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                temp.setEindTijd(new Date(System.currentTimeMillis()));
                try {
                    temp.setEindTijd(Date.valueOf(s.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                temp.setCapaciteit(Integer.parseInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText experience = (EditText) v.findViewById(R.id.experience);
        experience.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp.setErvaringHonden(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //position 0=bij eigenaar thuis 1=bij Oppas thuis
        Log.i("variables", "postion is: " + position);
        if (position == 0) {
            temp.setLocatie("bij hond eigenaar");
        } else {
            temp.setLocatie(loggedInUser.getPlaatsnaam());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}