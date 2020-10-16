package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView mAdvertentieRecyclerView;
    private AdvertentieAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mAdvertentieRecyclerView = (RecyclerView) view
                .findViewById(R.id.AdvertRecycler);
        mAdvertentieRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fab:// TODO New advert
                /*
                Notitie notitie = new Notitie();
                NotitieBlok.getCurrent(getActivity()).addNotitie(notitie);
                Intent intent = new Intent(getActivity(), NotitieActivity.class);
                intent.putExtra("com.example.noteapplication.notitie_id", notitie.getId());
                startActivity(intent);*/
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        List<Advertentie> advertenties=new ArrayList<>();
        App_Gebruiker TestPersoon= new App_Gebruiker();
        TestPersoon.setNaam("Gerard");
        TestPersoon.setTelefoon_Nummer(123456789);
        TestPersoon.setHuisnummer(5);
        TestPersoon.setIntroductieText("ik ben een test gebruiker");
        TestPersoon.setWachtwoord("123");

        Advertentie TestAdvertentie= new Advertentie();
        TestAdvertentie.set_AdvertentiePlaatser(TestPersoon);
        TestAdvertentie.setCapaciteit(3);
        TestAdvertentie.setErvaringHonden("Ik ben opgegroeid met honden");
        TestAdvertentie.setLocatie("rotterdam");
        TestAdvertentie.setBeginTijd(new Date());
        TestAdvertentie.setPrijs(2);
        Advertentie TestAdvertentie2= new Advertentie();
        TestAdvertentie2.set_AdvertentiePlaatser(TestPersoon);
        TestAdvertentie2.setCapaciteit(3);
        TestAdvertentie2.setLocatie("rotterdam");
        TestAdvertentie2.setBeginTijd(new Date());

        advertenties.add(TestAdvertentie);
        advertenties.add(TestAdvertentie2);
        advertenties.add(TestAdvertentie);
        advertenties.add(TestAdvertentie2);
        advertenties.add(TestAdvertentie);
        advertenties.add(TestAdvertentie2);

        // = HondenDB.get(getActivity()).getAdvertenties();

        if (mAdapter == null) {
            mAdapter = new AdvertentieAdapter(advertenties);
            mAdvertentieRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setAdvertenties(advertenties);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class AdvertentieHolder extends RecyclerView.ViewHolder {
        private Advertentie mAdvertentie;
        private TextView mCapacityTextView;
        private TextView mDateTextView;
        private TextView mOwnerTextView;
        private TextView mLocationTextView;

        public AdvertentieHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_advertentie, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* TODO open advert
                    Intent intent = new Intent(getActivity(), NotitieActivity.class);

                    intent.putExtra("com.example.noteapplication.notitie_id", mAdvertentie.getId());
                    startActivity(intent);*/

                    Toast.makeText(getActivity(),
                            mAdvertentie.getCapaciteit() + " clicked!", Toast.LENGTH_SHORT)
                                .show();
                }
            });
            mCapacityTextView = (TextView) itemView.findViewById(R.id.Capacity);
            mDateTextView = (TextView) itemView.findViewById(R.id.Date);
            mOwnerTextView = (TextView) itemView.findViewById(R.id.Owner);
            mLocationTextView = (TextView) itemView.findViewById(R.id.Location);
        }

        public void bind(Advertentie advertentie) {
            mAdvertentie = advertentie;
            mCapacityTextView.setText("Capacity: "+ mAdvertentie.getCapaciteit());
            mDateTextView.setText(mAdvertentie.getBeginTijd().toString());
            mOwnerTextView.setText(mAdvertentie.get_AdvertentiePlaatser().getNaam());
        }
    }

    private class AdvertentieAdapter extends RecyclerView.Adapter<AdvertentieHolder> {
        private List<Advertentie> mAdvertenties;

        public AdvertentieAdapter(List<Advertentie> advertenties) {
            mAdvertenties = advertenties;
        }

        @Override
        public AdvertentieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new AdvertentieHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(AdvertentieHolder holder, int position) {
            Advertentie advertentie = mAdvertenties.get(position);
            holder.bind(advertentie);
        }

        @Override
        public int getItemCount() {
            return mAdvertenties.size();
        }

        public void setAdvertenties(List<Advertentie> advertenties) {
            mAdvertenties = advertenties;
        }


    }
}
