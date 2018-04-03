package com.example.nacho.world_cup_russia_2018.Adapter;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import java.util.List;

/**
 * Created by Nacho on 02/04/2018.
 */

public class TeamsAdapter extends BaseAdapter {

    private int layoutData;
    private List<ListTeams> equiposList;
    ArrayAdapter<String> mAdapter;
    private Activity activity;

    private String getId;
    private String imagenes;

    public TeamsAdapter(Activity activity, List<ListTeams> list, int layout){

        this.activity=activity;
        this.equiposList=list;
        this.layoutData=layout;
    }

    @Override
    public int getCount() {
        return equiposList.size();
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

        LayoutInflater inflater = activity.getLayoutInflater();
        convertView=inflater.inflate(layoutData, null);

        TextView lblid = convertView.findViewById(R.id.txtidTitle);
        //SmartImageView imageView=(SmartImageView)convertView.findViewById(R.id.imageproduct);
        TextView teamNombre = convertView.findViewById(R.id.txttitulo);
        //ImageView teamImage = convertView.findViewById(R.id.image_flecha);

        //imagenes = (lista.get(position).getImage().toString());
        //String urlfinal= URL_Rest.urlImage + imagenes;

        getId=Integer.toString(equiposList.get(position).getIdTeam());
        lblid.setText(getId);
        teamNombre.setText(equiposList.get(position).getTeamName());
        //teamImage.setText(equiposList.get(position).getPrecio());

        //Rect rect= new Rect(imageView.getLeft(),imageView.getTop(),imageView.getRight(),imageView.getBottom());
        //imageView.setImageUrl(urlfinal, rect);

        return convertView;
    }
}
