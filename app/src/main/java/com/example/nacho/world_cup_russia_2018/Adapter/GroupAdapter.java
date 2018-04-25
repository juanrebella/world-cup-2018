package com.example.nacho.world_cup_russia_2018.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nacho.world_cup_russia_2018.Properties.ListStadiums;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;
import com.example.nacho.world_cup_russia_2018.View.GroupsActivity;
import com.github.snowdream.android.widget.SmartImageView;

import java.util.List;

/**
 * Created by Nacho on 25/04/2018.
 */

public class GroupAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ListTeams> groupList;
    private Activity activity;
    private TextView txt1, txt2, txt3, txt4;

    public GroupAdapter (Activity activity, List<ListTeams> list){
        this.activity=activity;
        this.groupList=list;
    }

    @Override
    public int getCount() {
        return groupList.size();
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
            convertView = inflater.inflate(R.layout.groups_list_view_items, parent, false);


        txt1 = convertView.findViewById(R.id.equipo1);
        txt2 = convertView.findViewById(R.id.equipo2);
        txt3 = convertView.findViewById(R.id.equipo3);
        txt4 = convertView.findViewById(R.id.equipo4);

        txt1.setText(groupList.get(position).getTeamName());
        txt2.setText(groupList.get(position).getTeamName());
        txt3.setText(groupList.get(position).getTeamName());
        txt4.setText(groupList.get(position).getTeamName());

        return convertView;
    }
}
