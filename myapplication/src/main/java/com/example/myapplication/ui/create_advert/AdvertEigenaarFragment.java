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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

import java.sql.Date;

public class AdvertEigenaarFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner Type;
    String DogNames[];
    Advertentie temp = new Advertentie();
    App_Gebruiker loggedInUser;
    RecyclerView hondenplus;


    /*
    * in this class a advert is made and dogs are statically added
    * this file requires a lot of extra work to make it work dynamically
    * */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.advert_eigenaar_main, container, false);
        loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("user");
        //dummy values if user doesnt enter data
        temp.setBeginTijd(new Date(System.currentTimeMillis()));
        temp.setEindTijd(new Date(System.currentTimeMillis()));

        hondenplus = v.findViewById(R.id.availableDogs);
        DogNames = getResources().getStringArray(R.array.DummyDogNames);
        RyclerFixer myadapter = new RyclerFixer(getActivity(), DogNames);
        hondenplus.setAdapter(myadapter);
        hondenplus.setLayoutManager(new LinearLayoutManager(getActivity()));

        Type = (Spinner) v.findViewById(R.id.TypeCare);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Type.setAdapter(adapter);
        Type.setOnItemSelectedListener(this);


        Button createAdvert = (Button) v.findViewById(R.id.createadvert);
        createAdvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //setting known values to the advert
                temp.setAdvertentieType(Advertentie.AdvertentieTypes.eigenaar);
                temp.set_AdvertentiePlaatser(loggedInUser);
                temp.setErvaringHonden("Ik zoek een oppasser voor mijn honden");
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

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //position 0=bij eigenaar thuis 1=bij Oppas thuis
        Log.i("variables", "postion is: " + position);
        if (position == 0) {
            temp.setLocatie(loggedInUser.getPlaatsnaam());
        } else {
            temp.setLocatie("Bij oppas thuis");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

