package com.example.myapplication.ui.afspraken;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;
import com.example.myapplication.model.Afspraak;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

public class AfspraakDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.afspraak_detail, container, false);

        final Advertentie _advertentie = (Advertentie) getActivity().getIntent()
                .getSerializableExtra("Advertentie");
        final App_Gebruiker loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("LoggedInUser");
        final Afspraak _afspraak = (Afspraak) getActivity().getIntent()
                .getSerializableExtra("Afspraak");



        TextView locatie = (TextView) root.findViewById(R.id.locatie_id);
        locatie.setText(_advertentie.getLocatie());

        TextView naam = (TextView) root.findViewById(R.id.naam_id);
        naam.setText(_afspraak.get_eigenaar().getNaam());

        TextView tel = (TextView) root.findViewById(R.id.telefoon_id);
        tel.setText(""+_afspraak.get_eigenaar().getTelefoon_Nummer());

        TextView verhaal = (TextView) root.findViewById(R.id.peroonlijk_verhaal_id);
        verhaal.setText(_advertentie.getErvaringHonden());

        Button deal = (Button) root.findViewById(R.id.ButtonAfspraak);
        deal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO everything

            }
        });
        return root;
    }
}

