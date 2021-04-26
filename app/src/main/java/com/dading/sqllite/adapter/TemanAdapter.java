package com.dading.sqllite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dading.sqllite.R;
import com.dading.sqllite.database.teman;

import java.util.ArrayList;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<teman> listData;

    public TemanAdapter(ArrayList<teman> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinf =LayoutInflater.from(parent.getContext());
        View view = layoutinf.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanViewHolder holder, int position) {
        String nm,tlp;

        nm = listData.get(position).getTeman();
        tlp = listData.get(position).getTelpon();

        holder.namatxt.setText(nm);
        holder.telpontxt.setText(tlp);


    }

    @Override
    public int getItemCount() {
        return (listData !=null)?listData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namatxt,telpontxt;

        public TemanViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            namatxt =(TextView) view.findViewById(R.id.textNama);
            telpontxt = (TextView) view.findViewById(R.id.textTelpon);

        }
    }
}
