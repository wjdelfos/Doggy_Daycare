package com.example.myapplication.ui.messaging;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.App_Gebruiker;
import com.example.myapplication.model.HondenDB;
import com.example.myapplication.model.Message;
import com.example.myapplication.ui.advertentie.AdvertDetailActivity;

import java.sql.Date;
import java.util.List;

public class MessageRecyclerFragment extends Fragment {
    private RecyclerView mMessageRecyclerView;
    private MessageAdapter mAdapter;
    private String contents;
    App_Gebruiker loggedInUser;
    App_Gebruiker _receiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_recycler, container, false);
        mMessageRecyclerView = (RecyclerView) view
                .findViewById(R.id.messageRecycler);
        mMessageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        loggedInUser = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("user");
        _receiver  = (App_Gebruiker) getActivity().getIntent()
                .getSerializableExtra("receiver");

        final EditText SendBox= (EditText) view.findViewById(R.id.messageInput);
        SendBox.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contents=s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        Button send = view.findViewById(R.id.buttonSend);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Message message = new Message();
                message.set_Receiver(_receiver);
                message.set_Sender(loggedInUser);
                message.setSendAtTime(new Date(System.currentTimeMillis()));
                message.setContents(contents);
                HondenDB.get(getActivity()).addMessage(message);
                SendBox.setText("");
                updateUI();
            }
        });

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
        List<Message> messages= HondenDB.get(getActivity()).getMessages(loggedInUser.getID(),_receiver.getID());

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
        private CardView mCard;


        public MessageHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_message, parent, false));
            //assigns xml fields
            mContents = (TextView) itemView.findViewById(R.id.contents);
            mType = (Button) itemView.findViewById(R.id.TypeAdvert);
            mCard= (CardView) itemView.findViewById(R.id.MessageCard);
        }

        public void bind(Message message) {
            //binds xml fields
            mMessage = message;
            mContents.setText(mMessage.getContents());
            if (message.getSender().equals(loggedInUser.getID())) {
                mCard.setCardBackgroundColor(Color.parseColor("#b7d6a7"));
            }
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
