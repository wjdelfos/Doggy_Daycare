package com.example.myapplication.ui.LoginUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.SingUpActivity;

public class LoginFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private String email;
    private String password;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_login, container, false);

        Button AanmeldButton = (Button) root.findViewById(R.id.Aanmelden);
        AanmeldButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SingUpActivity.class);
                startActivity(intent);
            }
        });

        Button LoginButton = (Button) root.findViewById(R.id.Login);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                /*CheckEmail(email);
                CheckPassword(password);*/
                //TODO check credentials

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });



        return root;
    }
}
