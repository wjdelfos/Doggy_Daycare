package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ui.Advert.AdvertEigenaarFragment;

public class RyclerFixer extends RecyclerView.Adapter<RyclerFixer.MeerWerk> {
    String[] namen;
    Context context;
    
    
    public RyclerFixer(Context ct, String[] s1) {
    context = ct;
    namen = s1;
    }

    @NonNull
    @Override
    public MeerWerk onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(@NonNull MeerWerk holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MeerWerk extends RecyclerView.ViewHolder {
        public MeerWerk(@NonNull View itemView) {
            super(itemView);
        }
    }

}
