package com.example.myapplication.controller.advertentie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Advertentie;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.data_handeling.HondenDB;

import java.util.List;

public class AdvertentieRecyclerFragment extends Fragment {
    private RecyclerView mAdvertentieRecyclerView;
    private AdvertentieAdapter mAdapter;

    //This is the fragment controller that controls the recycler view of adverts

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advert_recycler, container, false);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        List<Advertentie> advertenties = HondenDB.get(getActivity()).getAdvertenties();

        if (mAdapter == null) {
            mAdapter = new AdvertentieAdapter(advertenties);
            mAdvertentieRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setAdvertenties(advertenties);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class AdvertentieHolder extends RecyclerView.ViewHolder {
        //defines xml fields
        private Advertentie mAdvertentie;
        private TextView mCapacityTextView;
        private TextView mDateTextView;
        private TextView mPriceTextView;
        private TextView mOwnerTextView;
        private TextView mLocationTextView;
        private ImageButton mFavourite;
        private Button mType;
        private Boolean favourite;


        public AdvertentieHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_advertentie, parent, false));
            //assigns xml fields
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AdvertDetailActivity.class);
                    intent.putExtra("Advertentie", mAdvertentie);
                    intent.putExtra("LoggedInUser", (App_Gebruiker) getActivity().getIntent()
                            .getSerializableExtra("user"));
                    startActivity(intent);
                }
            });
            mCapacityTextView = (TextView) itemView.findViewById(R.id.Capacity);
            mDateTextView = (TextView) itemView.findViewById(R.id.Date);
            mPriceTextView = (TextView) itemView.findViewById(R.id.Prijs);
            mOwnerTextView = (TextView) itemView.findViewById(R.id.Owner);
            mLocationTextView = (TextView) itemView.findViewById(R.id.Location);
            mType = (Button) itemView.findViewById(R.id.TypeAdvert);

        }

        public void bind(Advertentie advertentie) {
            //binds xml fields
            mAdvertentie = advertentie;
            mCapacityTextView.setText("Capacity: "+ mAdvertentie.getCapaciteit());
            mDateTextView.setText(mAdvertentie.getBeginTijd().toString());
            mPriceTextView.setText("Prijs: "+ mAdvertentie.getPrijs());
            mOwnerTextView.setText(mAdvertentie.get_AdvertentiePlaatser().getNaam());
            mLocationTextView.setText(mAdvertentie.getLocatie());
            mFavourite = (ImageButton) itemView.findViewById(R.id.imageButton);
            mType.setText(mAdvertentie.getAdvertentieType()+" advertentie");
            mFavourite.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mFavourite.setBackgroundResource(R.drawable.favourite_button_gekleurd);

                }
            });
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
