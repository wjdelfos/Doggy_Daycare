package com.example.myapplication.controller.create_advert;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class RyclerFixer extends RecyclerView.Adapter<RyclerFixer.Myadapter> {
    String[] namen;
    Context context;


    public RyclerFixer(Context ct, String[] s1) {
        context = ct;
        namen = s1;
    }

    @NonNull
    @Override
    public Myadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View c = inflater.inflate(R.layout.row_dognames, parent, false);
        return new Myadapter(c);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myadapter holder, int position) {
        holder.hondennamen.setText(namen[position]);
        holder.selected = false;
        holder.screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                if (holder.selected == false) {
                    holder.card.setCardBackgroundColor(Color.BLUE);
                    holder.selected = true;
                } else {
                    holder.card.setCardBackgroundColor(Color.WHITE);
                    holder.selected = false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return namen.length;
    }

    public class Myadapter extends RecyclerView.ViewHolder {
        TextView hondennamen;
        ConstraintLayout screen;
        CardView card;
        Boolean selected;


        public Myadapter(@NonNull View itemView) {
            super(itemView);
            hondennamen = itemView.findViewById(R.id.dogNames);
            screen = itemView.findViewById(R.id.advert_eigenaar_main);
            card = itemView.findViewById(R.id.Card);
        }
    }

}
