package com.ezefm.informatorio2023.tpfinal1.entity;

import java.time.LocalDate;
import java.util.List;

public class Fut5Team {

    private String name;
    private LocalDate creationDate;
    private List<Player> players;
    private String coach;

    public Fut5Team(){}

    public Fut5Team(String name, LocalDate creationDate, List<Player> players, String coach) {
        this.name = name;
        this.creationDate = creationDate;
        this.players = players;
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", players=" + players +
                ", coach='" + coach + '\'' +
                '}';
    }
}