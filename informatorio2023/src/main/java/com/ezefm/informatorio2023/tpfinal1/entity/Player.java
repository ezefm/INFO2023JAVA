package com.ezefm.informatorio2023.tpfinal1.entity;

import java.util.UUID;

public class Player {

    private UUID id = UUID.randomUUID();
    private String name;
    private String lastName;
    private Position position;
    private Integer goals;
    private Integer matchesPlayed;
    private Boolean isCaptain;
    private Integer tShirtNumber;
    private String team;
    private Fut5Team teamX;
    public Player(){}

    public Player(String name, String lastName, Position position, Integer goals, Integer matchesPlayed, Boolean isCaptain, Integer tShirtNumber, String team) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.goals = goals;
        this.matchesPlayed = matchesPlayed;
        this.isCaptain = isCaptain;
        this.tShirtNumber = tShirtNumber;
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }

    public Integer gettShirtNumber() {
        return tShirtNumber;
    }
    public void settShirtNumber(Integer tShirtNumber) {
        this.tShirtNumber = tShirtNumber;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", goals=" + goals +
                ", matchesPlayed=" + matchesPlayed +
                ", isCaptain=" + isCaptain +
                ", tShirtNumber=" + tShirtNumber +
                ", team='" + team + '\'' +
                '}';
    }
}