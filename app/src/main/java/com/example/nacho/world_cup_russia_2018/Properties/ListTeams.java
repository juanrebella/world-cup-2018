package com.example.nacho.world_cup_russia_2018.Properties;

import org.json.JSONObject;

/**
 * Created by Nacho on 23/02/2018.
 */

public class ListTeams {

    private String idTeam;
    private String group;
    private String teamName;
    private String trophies;

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTrophies() {
        return trophies;
    }

    public void setTrophies(String trophies) {
        this.trophies = trophies;
    }
}
