package com.example.myapplication.ui.advertentie;

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
import com.example.myapplication.model.App_Gebruiker;

public class AdvertentieDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.advertentie_detail, container, false);

        Advertentie _advertentie= (Advertentie) getActivity().getIntent()
                .getSerializableExtra("Advertentie");
        App_Gebruiker loggedInUser= (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("LoggedInUser");

        TextView capaciteit = (TextView) root.findViewById(R.id.Capacity_id);
        capaciteit.setText(""+_advertentie.getCapaciteit());

        TextView prijs = (TextView) root.findViewById(R.id.Price_id);
        prijs.setText(""+_advertentie.getPrijs());

        TextView fromDate = (TextView) root.findViewById(R.id.from_id);
        fromDate.setText(_advertentie.getBeginTijd().toString());

        return root;
    }
}
