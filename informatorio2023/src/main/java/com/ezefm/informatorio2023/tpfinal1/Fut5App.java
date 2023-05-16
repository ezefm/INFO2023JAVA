package com.ezefm.informatorio2023.tpfinal1;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.service.TeamService;

import java.util.ArrayList;
import java.util.List;

public class Fut5App {
    public static void main(String[] args) {

        List<Fut5Team> teams = new ArrayList<>();

        TeamService teamService = new TeamService();
        teams.add(teamService.newTeam());
        teams.add(teamService.newTeam());

        for (Fut5Team team : teams){
            System.out.println(team);
        }

        teamService.addPlayer("INFO", teams);
        teamService.addPlayer("INFO", teams);

        teamService.deletePlayerByNameAndTeam(teams);
    }
}