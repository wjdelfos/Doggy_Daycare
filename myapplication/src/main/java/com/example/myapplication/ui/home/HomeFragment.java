package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView mAdvertentieRecyclerView;
    private NotitieAdapter mAdapter;

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_notitieblok, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_notitie:
                Notitie notitie = new Notitie();
                NotitieBlok.getCurrent(getActivity()).addNotitie(notitie);
                Intent intent = new Intent(getActivity(), NotitieActivity.class);
                intent.putExtra("com.example.noteapplication.notitie_id", notitie.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        List<Notitie> notities = NotitieBlok.getCurrent(getActivity()).getNotities();

        if (mAdapter == null) {
            mAdapter = new NotitieAdapter(notities);
            mAdvertentieRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setNotities(notities);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class NotitieHolder extends RecyclerView.ViewHolder {
        private Notitie mNotitie;
        private TextView mTitleTextView;
        private TextView mDateTextView;

        public NotitieHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_notitie, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), NotitieActivity.class);
                    intent.putExtra("com.example.noteapplication.notitie_id", mNotitie.getId());
                    startActivity(intent);
                    //Toast.makeText(getActivity(),
                    //        mNotitie.getTitel() + " clicked!", Toast.LENGTH_SHORT)
                    //            .show();
                }
            });
            mTitleTextView = (TextView) itemView.findViewById(R.id.notitie_titel);
            mDateTextView = (TextView) itemView.findViewById(R.id.notitie_datum);
        }

        public void bind(Notitie notitie) {
            mNotitie = notitie;
            mTitleTextView.setText(mNotitie.getTitel());
            mDateTextView.setText(mNotitie.getDatum().toString());
        }
    }

    private class NotitieAdapter extends RecyclerView.Adapter<NotitieHolder> {
        private List<Notitie> mNotities;

        public NotitieAdapter(List<Notitie> notities) {
            mNotities = notities;
        }

        @Override
        public NotitieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new NotitieHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(NotitieHolder holder, int position) {
            Notitie notitie = mNotities.get(position);
            holder.bind(notitie);
        }

        @Override
        public int getItemCount() {
            return mNotities.size();
        }

        public void setNotities(List<Notitie> notities) {
            mNotities = notities;
        }


    }
}
