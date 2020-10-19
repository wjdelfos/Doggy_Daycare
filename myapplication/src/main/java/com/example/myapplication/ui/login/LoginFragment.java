package com.example.myapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.sign_up.SignUpActivity;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

public class LoginFragment extends Fragment {

    private int _telefoonNummer = 0;
    private String _password = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_login, container, false);

        Button AanmeldButton = (Button) root.findViewById(R.id.Aanmelden);
        AanmeldButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        Button LoginButton = (Button) root.findViewById(R.id.Login);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //sql injection possible....
                //Create a user object that is accessible to other classes to display the user or user information for object creation.

                App_Gebruiker loggedInUser =HondenDB.get(getActivity()).CheckCredentials(_telefoonNummer, _password);
                if (loggedInUser!=null) {
                    // if a user has been created we can enter the application and the data is passed to the next activity

                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("user",loggedInUser);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(),
                           "Wrong login", Toast.LENGTH_SHORT)
                               .show();
                }
            }
        });

        EditText Wachtwoord = (EditText) root.findViewById(R.id.Wachtwoord);
        Wachtwoord.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                _password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        EditText TelefoonNr = (EditText) root.findViewById(R.id.Telefoon_nr);
        TelefoonNr.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    _telefoonNummer = Integer.parseInt(s.toString().replaceAll("\\D", ""));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return root;
    }
}
