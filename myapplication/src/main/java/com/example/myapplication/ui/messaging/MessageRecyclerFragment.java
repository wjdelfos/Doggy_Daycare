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
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;
import com.example.myapplication.model.Message;
import com.example.myapplication.ui.advertentie.AdvertDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageRecyclerFragment extends Fragment {
    private RecyclerView mMessageRecyclerView;
    private MessageAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_recycler, container, false);
        mMessageRecyclerView = (RecyclerView) view
                .findViewById(R.id.messageRecycler);
        mMessageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        List<Message> messages= new ArrayList<>();// = HondenDB.get(getActivity()).getMessages(loggedInUser,MessagingPartner);

        if (mAdapter == null) {
            mAdapter = new MessageAdapter(messages);
            mMessageRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setAdvertenties(messages);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class MessageHolder extends RecyclerView.ViewHolder {
        //defines xml fields
        private Message mMessage;
        private TextView mContents;
        private Button mType;


        public MessageHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_message, parent, false));
            //assigns xml fields
            mContents = (TextView) itemView.findViewById(R.id.contents);
            mType = (Button) itemView.findViewById(R.id.TypeAdvert);

        }

        public void bind(Message message) {
            //binds xml fields
            mMessage = message;
            mContents.setText(mMessage.getContents());
        }
    }

    private class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {
        private List<Message> mMessages;

        public MessageAdapter(List<Message> messages) {
            mMessages = messages;
        }

        @Override
        public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new MessageHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(MessageHolder holder, int position) {
            Message message = mMessages.get(position);
            holder.bind(message);
        }

        @Override
        public int getItemCount() {
            return mMessages.size();
        }

        public void setAdvertenties(List<Message> messages) {
            mMessages = messages;
        }


    }
}
