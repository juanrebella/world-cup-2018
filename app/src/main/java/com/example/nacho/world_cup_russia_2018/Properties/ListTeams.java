package com.example.nacho.world_cup_russia_2018.Properties;

import org.json.JSONObject;

/**
 * Created by Nacho on 23/02/2018.
 */

public class ListTeams {

    private int idTeam;
    private int group;
    private String teamName;
    private int trophies;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
}
