package com.example.myapplication.ui.messaging;

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
import com.example.myapplication.model.HondenDB;

import java.util.ArrayList;
import java.util.List;

public class InboxRecyclerFragment extends Fragment {
    private RecyclerView mInboxRecyclerView;
    private InboxAdapter mAdapter;

    App_Gebruiker loggedInUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_inbox, container, false);
        mInboxRecyclerView = (RecyclerView) view
                .findViewById(R.id.InboxRecycler);
        mInboxRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("user");

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
        List<App_Gebruiker> gebruikers = HondenDB.get(getActivity()).getConversations(loggedInUser.getID());

        if (mAdapter == null) {
            mAdapter = new InboxAdapter(gebruikers);
            mInboxRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setAdvertenties(gebruikers);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class InboxHolder extends RecyclerView.ViewHolder {
        //defines xml fields
        private App_Gebruiker mGebruiker;
        private TextView mNaam;


        public InboxHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_inbox, parent, false));
            //assigns xml fields
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), MessagingActivity.class);
                    intent.putExtra("user", loggedInUser);
                    intent.putExtra("receiver", mGebruiker);
                    startActivity(intent);
                }
            });
            mNaam = (TextView) itemView.findViewById(R.id.UserName);

        }

        public void bind(App_Gebruiker gebruiker) {
            //binds xml fields
            mGebruiker = gebruiker;
            mNaam.setText(gebruiker.getNaam());
        }
    }

    private class InboxAdapter extends RecyclerView.Adapter<InboxHolder> {
        private List<App_Gebruiker> mApp_gebruikers;

        public InboxAdapter(List<App_Gebruiker> gebruikers) {
            mApp_gebruikers = gebruikers;
        }

        @Override
        public InboxHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new InboxHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(InboxHolder holder, int position) {
            App_Gebruiker gebruiker = mApp_gebruikers.get(position);
            holder.bind(gebruiker);
        }

        @Override
        public int getItemCount() {
            return mApp_gebruikers.size();
        }

        public void setAdvertenties(List<App_Gebruiker> gebruikers) {
            mApp_gebruikers = gebruikers;
        }


    }
}
