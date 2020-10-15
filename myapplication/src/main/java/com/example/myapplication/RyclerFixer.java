package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        View c = inflater.inflate(R.layout.row_dognames, parent,false);
        return new MeerWerk(c);
    }

    @Override
    public void onBindViewHolder(@NonNull MeerWerk holder, int position) {
    holder.hondennamen.setText(namen[position]);
    }

    @Override
    public int getItemCount() {
        return namen.length;
    }

    public class MeerWerk extends RecyclerView.ViewHolder {
        TextView hondennamen;
        public MeerWerk(@NonNull View itemView) {
            super(itemView);
            hondennamen = itemView.findViewById(R.id.dogNames);

        }
    }

}
