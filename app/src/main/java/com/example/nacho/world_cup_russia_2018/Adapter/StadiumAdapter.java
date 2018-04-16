package com.example.nacho.world_cup_russia_2018.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nacho.world_cup_russia_2018.Properties.ListStadiums;
import com.example.nacho.world_cup_russia_2018.R;
import com.github.snowdream.android.widget.SmartImageView;

import java.util.List;

/**
 * Created by Nacho on 16/04/2018.
 */

public class StadiumAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ListStadiums> stadiumsList;
    private Activity activity;
    private String images;

    public StadiumAdapter(Activity activity, List<ListStadiums> list){
        this.activity=activity;
        this.stadiumsList=list;
    }

    @Override
    public int getCount() {
        return stadiumsList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.stadium_list_view_items, null);


        TextView txtNombreEstadio = convertView.findViewById(R.id.txtNombreEstadio);
        SmartImageView imageView = convertView.findViewById(R.id.imgStadiumIcon);

        images  = (stadiumsList.get(position).getImages());
        String urlfinal = images;

        txtNombreEstadio.setText(stadiumsList.get(position).getNameStadium());
        imageView.setImageUrl(urlfinal, null);

        return convertView;

    }
}
