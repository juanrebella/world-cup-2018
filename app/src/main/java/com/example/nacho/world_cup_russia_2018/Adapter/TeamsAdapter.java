package com.example.nacho.world_cup_russia_2018.Adapter;

import android.app.Activity;
import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nacho on 02/04/2018.
 */

public class TeamsAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ListTeams> equiposList;
    private Activity activity;

    private String getId;

    public TeamsAdapter(Activity activity, List<ListTeams> list){

        this.activity=activity;
        this.equiposList=list;
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

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.teams_list_view, null);

        TextView txtNombreEquipo = convertView.findViewById(R.id.txtNombreEquipo);
        TextView txtGrupo = convertView.findViewById(R.id.txtGrupo);
        TextView txtTitulos = convertView.findViewById(R.id.txtTitulos);

        ListTeams m = equiposList.get(position);

        txtNombreEquipo.setText(m.getTeamName());
        txtGrupo.setText(m.getGroup());
        txtTitulos.setText(m.getTrophies());


        return convertView;
    }
}
