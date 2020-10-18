package com.example.myapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.model.Afspraak;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;

import java.util.List;
import java.util.UUID;

public class SlideshowFragment extends Fragment {


    private RecyclerView mAfspraakRecyclerView;
    private AfspraakAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        mAfspraakRecyclerView = (RecyclerView) view
                .findViewById(R.id.AfspraakRecycler);
        mAfspraakRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
            case R.id.fab:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        //TODO create get query
        App_Gebruiker loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("user");

        List<Afspraak> afspraakList = HondenDB.get(getActivity()).getAfspraken(loggedInUser.getID());

        if (mAdapter == null) {
            mAdapter = new AfspraakAdapter(afspraakList);
            mAfspraakRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setAfspraken(afspraakList);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class AfspraakHolder extends RecyclerView.ViewHolder {
        private Afspraak mAfspraak;
        private TextView mCapacityTextView;
        private TextView mDateTextView;
        private TextView mOwnerTextView;
        private TextView mLocationTextView;

        public AfspraakHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_afspraak, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {/* TODO create detail view
                    Intent intent = new Intent(getActivity(), AdvertDetailActivity.class);
                    intent.putExtra("Advertentie", mAdvertentie);
                    intent.putExtra("LoggedInUser", (App_Gebruiker) getActivity().getIntent()
                            .getSerializableExtra("user"));
                    startActivity(intent);*/

                }
            });
            mCapacityTextView = (TextView) itemView.findViewById(R.id.Capacity);
            mDateTextView = (TextView) itemView.findViewById(R.id.Date);
            mOwnerTextView = (TextView) itemView.findViewById(R.id.Owner);
            mLocationTextView = (TextView) itemView.findViewById(R.id.Location);
        }

        public void bind(Afspraak afspraak) {
            mAfspraak = afspraak;
            mCapacityTextView.setText("Capacity: " + mAfspraak.get_advertentie().getCapaciteit());
            mDateTextView.setText(mAfspraak.get_advertentie().getBeginTijd().toString());
            mOwnerTextView.setText(mAfspraak.get_eigenaar().getNaam());
            mLocationTextView.setText(mAfspraak.get_advertentie().getLocatie());
        }
    }

    private class AfspraakAdapter extends RecyclerView.Adapter<AfspraakHolder> {
        private List<Afspraak> mAfspraken;

        public AfspraakAdapter(List<Afspraak> afspraakList) {
            mAfspraken = afspraakList;
        }

        @Override
        public AfspraakHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new AfspraakHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(AfspraakHolder holder, int position) {
            Afspraak afspraak = mAfspraken.get(position);
            holder.bind(afspraak);
        }

        @Override
        public int getItemCount() {
            return mAfspraken.size();
        }

        public void setAfspraken(List<Afspraak> afspraakList) {
            mAfspraken = afspraakList;
        }


    }
}