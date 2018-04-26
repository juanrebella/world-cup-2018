package com.example.nacho.world_cup_russia_2018.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nacho.world_cup_russia_2018.Properties.ListStadiums;
import com.example.nacho.world_cup_russia_2018.R;
import com.github.snowdream.android.widget.SmartImageView;

import java.util.List;

/**
 * Created by Nacho on 26/04/2018.
 */

public class CustomAdapterStadiums extends RecyclerView.Adapter<CustomAdapterStadiums.ViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(ListStadiums item);
    }

    private List<ListStadiums> stadiumsList;
    private final OnItemClickListener listener;

    public CustomAdapterStadiums(List<ListStadiums> stadiumsList, OnItemClickListener listener) {
        this.stadiumsList = stadiumsList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stadium_list_view_items, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(stadiumsList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return stadiumsList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        public SmartImageView imgStadiumIcon;
        public TextView txtNombreEstadio;


        public ViewHolder(View itemView) {
            super(itemView);

            txtNombreEstadio = itemView.findViewById(R.id.txtNombreEstadio);
            imgStadiumIcon = itemView.findViewById(R.id.imgStadiumIcon);

            }

        public void bind(final ListStadiums item, final OnItemClickListener listener) {

            String images  = (item.getImages());
            txtNombreEstadio.setText(item.getNameStadium());
            imgStadiumIcon.setImageUrl(images, null);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
