package com.example.domain;

import java.util.Date;
import java.util.List;

/**
 * 野球チームのドメイン.
 */
public class BaseballTeam {

    /** 球団id */
    private Integer id;

    /** リーグ名 */
    private String leagueName;

    /** チーム名 */
    private String teamName;

    /** 本拠地 */
    private String Headquarters;

    /** 発足 */
    private String inauguration;

    /** 歴史　*/
    private String history;



    //getter setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHeadquarters() {
        return Headquarters;
    }

    public void setHeadquarters(String headquarters) {
        Headquarters = headquarters;
    }

    public String getInauguration() {
        return inauguration;
    }

    public void setInauguration(String inauguration) {
        this.inauguration = inauguration;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }



    @Override
    public String toString() {
        return "BaseballTeam{" +
                "id=" + id +
                ", leagueName='" + leagueName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", Headquarters='" + Headquarters + '\'' +
                ", inauguration='" + inauguration + '\'' +
                ", history='" + history + '\'' +
                '}';
    }
}
