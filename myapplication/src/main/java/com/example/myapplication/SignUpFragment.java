package com.example.myapplication;

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

import java.util.UUID;
public class SignUpFragment extends Fragment { //implements AdapterView.OnItemSelectedListener {

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sign_up_main, container, false);

        Spinner gender = (Spinner) v.findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

       /* @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            parent.getItemAtPosition(pos)

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
*/


        Button Aanmelden = (Button) v.findViewById(R.id.Aanmelden);
        Aanmelden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //TODO create account
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        EditText PersonName = (EditText) v.findViewById(R.id.PersonName);
        PersonName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update person name
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
                //TODO update person name 2 (sir name)
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
                //TODO update Birth date
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        EditText Email = (EditText) v.findViewById(R.id.EmailAddress);
        Email.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO update email
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
                Log.i("variables",s.toString());

                //TODO update phone
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        /*
        EditText descField = (EditText) v.findViewById(R.id.notitie_beschrijving);
        descField.setText(mNotitie.getBeschrijving());
        descField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mNotitie.setBeschrijving(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Button dateField = (Button) v.findViewById(R.id.notitie_datum);
        dateField.setText(mNotitie.getDatum().toString());


        */
        return v;
    }


}
