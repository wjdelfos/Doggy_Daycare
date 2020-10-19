package com.example.myapplication.ui.advertentie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;
import com.example.myapplication.model.Afspraak;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

import java.util.UUID;

public class AdvertentieDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.advertentie_detail, container, false);

        final Advertentie _advertentie = (Advertentie) getActivity().getIntent()
                .getSerializableExtra("Advertentie");
        final App_Gebruiker loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("LoggedInUser");

        // region TextView assignment
        TextView capaciteit = (TextView) root.findViewById(R.id.Capacity_id);
        capaciteit.setText("" + _advertentie.getCapaciteit());

        TextView prijs = (TextView) root.findViewById(R.id.Price_id);
        prijs.setText("" + _advertentie.getPrijs());

        TextView fromDate = (TextView) root.findViewById(R.id.from_id);
        fromDate.setText(_advertentie.getBeginTijd().toString());

        TextView tillDate = (TextView) root.findViewById(R.id.Till_id);
        tillDate.setText(_advertentie.getEindTijd().toString());

        TextView description = (TextView) root.findViewById(R.id.Description_id);
        description.setText(_advertentie.getErvaringHonden());
        // endregion

        // this on click listener adds a concept appointment to the database
        Button deal = (Button) root.findViewById(R.id.buttonDeal);
        deal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UUID plaatser = _advertentie.getAdvertentiePlaatser();
                UUID dealMaker = loggedInUser.getID();

                //check if making deal with itself
                if (!plaatser.equals(dealMaker)) {
                    //boolean to set the right acceptance column to be true or false
                    //The one who makes the deal automatically accepts because it is their offer to make the deal
                    boolean IsEigenaarsAdvert = _advertentie.getAdvertentieType().equals(Advertentie.AdvertentieTypes.eigenaar);
                    Afspraak a;

                    // Create new appointment taking the two different appointments into regard
                    if (IsEigenaarsAdvert) {
                        a = new Afspraak(_advertentie.getPrijs(),
                                Afspraak.StatusAfspraken.concept,
                                true, false,
                                loggedInUser.getID(),
                                _advertentie.getAdvertentiePlaatser(),
                                _advertentie.getID());
                    } else {
                        a = new Afspraak(_advertentie.getPrijs(),
                                Afspraak.StatusAfspraken.concept,
                                false, true,
                                _advertentie.getAdvertentiePlaatser(),
                                loggedInUser.getID(),
                                _advertentie.getID());
                    }

                    HondenDB.get(getActivity()).addAfspraak(a);

                    //popup to show it worked
                    Toast.makeText(getActivity(),
                            "Deal made!", Toast.LENGTH_SHORT)
                            .show();
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity(),
                            "Cannot make deal with yourself", Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
        return root;
    }
}

