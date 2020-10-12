package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.UUID;

public class SignUpFragment extends Fragment {

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

       /*
        EditText titleField = (EditText) v.findViewById(R.id.notitie_titel);
        titleField.setText(mNotitie.getTitel());
        titleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mNotitie.setTitel(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
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