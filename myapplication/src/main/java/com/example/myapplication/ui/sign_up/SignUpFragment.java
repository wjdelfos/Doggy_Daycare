package com.example.myapplication.ui.sign_up;

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
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

import java.sql.Date;
import java.util.UUID;

public class SignUpFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner gender;
    private App_Gebruiker temp = new App_Gebruiker();
    private String vnaam="";
    private String anaam="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sign_up_main, container, false);

        gender = (Spinner) v.findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(this);

        Button Aanmelden = (Button) v.findViewById(R.id.Aanmelden);
        Aanmelden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    //Creates user according to user inputs and checks weather the nescecarry fields have been filled in
                    if (temp.getTelefoon_Nummer() != 0
                            && temp.getWachtwoord() != null
                            && temp.getPlaatsnaam() != null
                            && !temp.getNaam().equals("")) {

                        HondenDB.get(getActivity()).addApp_Gebruiker(temp);
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.putExtra("user", temp);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(),
                                "INVULLEN: location, telNR, naam en wachtwoord", Toast.LENGTH_SHORT)
                                .show();
                    }
                } finally {

                }

            }
        });

        EditText PersonName = (EditText) v.findViewById(R.id.PersonName);
        PersonName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                vnaam = s.length()>0?s.toString():"";
                temp.setNaam(vnaam + anaam);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText plaats = (EditText) v.findViewById(R.id.PlaceName);
        plaats.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp.setPlaatsnaam(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText PersonName2 = (EditText) v.findViewById(R.id.PersonName2);
        PersonName2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                anaam =  s.length()>0?s.toString():"";
                temp.setNaam(vnaam + anaam);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText BirthDate = (EditText) v.findViewById(R.id.BirthDate);
        BirthDate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp.setGeboortedatum(new Date(System.currentTimeMillis()));
                try {
                    temp.setGeboortedatum(Date.valueOf(s.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText Phone = (EditText) v.findViewById(R.id.Phone);
        Phone.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("variables", s.toString());

                temp.setTelefoon_Nummer(Integer.parseInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
        EditText Password = (EditText) v.findViewById(R.id.Password);
        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp.setWachtwoord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.i("variables", "Deus ex machina");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
