package com.example.myapplication.ui.advertentie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;

public class AdvertentieDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.advertentie_detail, container, false);
        Advertentie _advertentie= (Advertentie) getActivity().getIntent()
                .getSerializableExtra("Advertentie");




        return root;
    }
}
