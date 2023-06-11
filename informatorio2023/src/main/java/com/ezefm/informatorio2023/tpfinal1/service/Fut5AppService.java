package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.utils.AddPlayers;
import com.ezefm.informatorio2023.tpfinal1.utils.AddTeams;
import com.ezefm.informatorio2023.tpfinal1.utils.TeamExporter;
import com.ezefm.informatorio2023.tpfinal1.utils.TeamImporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fut5AppService {

    private final Scanner sc = new Scanner(System.in);
    private final TeamService  teamService= new TeamService();
    private final PlayerService playerService = new PlayerService();
    private final List<Fut5Team> teams = new ArrayList<>();
    private final AddTeams addTeams = new AddTeams();
    private final AddPlayers addPlayers = new AddPlayers();
    private final TeamExporter teamExporter = new TeamExporter();
    private final TeamImporter teamImporter = new TeamImporter();

    public void showMenu(){
        addTeams.fillTeamList(teams);
        addPlayers.fillPlayersList(teams);
        int e;
        int select;
        do {
            System.out.println("""
                1. New team
                2. Find player by full name
                3. Find team by team name, coach name and captain name (A)
                4. Find team by name (B)
                5. Delete team by name
                6. Import team or teams (csv / txt) file
                7. Export all teams (csv / txt) file
                8. Find team by name order by player name
                9. Find team by name order by t-shirt number
                10. Find team by name order by position and t-shirt number
                11. Export team (csv / txt) file
                12. Show all teams
                13. Exit
                """);
            e = sc.nextInt();
            switch (e){
                case 1 -> {
                    int c;
                    do {
                        teams.add(teamService.createTeam());
                        System.out.println("""
                            1. Yes
                            2. No
                            Do you want add other team? :
                            """);
                        c = Integer.parseInt(sc.next());
                    }while(c != 2);
                }
                case 2 -> playerService.findPlayerByName(teams);
                case 3 -> teamService.findTeamByTeamCoachCaptainName(teams);
                case 4 -> teamService.findTeamByName(teams);
                case 5 -> teamService.deleteTeamByName(teams);
                case 6 -> {
                    System.out.print("""
                            1. CSV
                            2. TXT
                            Select:
                            """);
                    select = Integer.parseInt(sc.next());
                    if(select == 1){
                        teamImporter.importTeamsFromCSV(teams, "teamsImport.csv", 1);
                    } else if (select == 2) {
                        teamImporter.importTeamsFromCSV(teams, "teamsImport.txt", 2);
                    } else {
                        System.out.println("You have selected a wrong option.");
                    }
                }
                case 7 -> {
                    System.out.print("""
                            1. CSV
                            2. TXT
                            Select:
                            """);
                    select = Integer.parseInt(sc.next());
                    if(select == 1){
                        teamExporter.exportTeamsToCsvOrTxt(teams, "teams.csv", select);
                    } else if (select == 2) {
                        teamExporter.exportTeamsToCsvOrTxt(teams, "teams.txt", select);
                    } else {
                        System.out.println("You have selected a wrong option.");
                    }
                }
                case 8 -> teamService.findTeamByNameOrderByPlayerName(teams);
                case 9 -> teamService.findTeamByNameOrderByPlayerNumber(teams);
                case 10 -> teamService.findTeamByNameOrderByPositionAndTShirtNumber(teams);
                case 11 -> {
                    System.out.print("""
                            1. CSV
                            2. TXT
                            Select:
                            """);
                    select = Integer.parseInt(sc.next());
                    if(select == 1){
                        teamExporter.exportTeamToCsvOrTxt(teams, "team.csv", select);
                    } else if (select == 2) {
                        teamExporter.exportTeamToCsvOrTxt(teams, "team.txt", select);
                    } else {
                        System.out.println("You have selected a wrong option.");
                    }
                }
                case 12 -> teamService.showTeams(teams);
            }
        }while (e != 13);
    }
}