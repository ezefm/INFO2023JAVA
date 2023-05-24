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
                2. Find player by name
                3. Find team by name (A)
                4. Find team by name (B)
                5. Delete team by name
                6. Import teams (csv / txt) file
                7. Export teams (csv / txt) file
                8. Exit
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
                        c = Integer.parseInt(sc.nextLine());
                    }while(c != 2);
                }
                case 2 -> teamService.findPlayerByName(teams);
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
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
                        teamExporter.exportTeamsToCSV(teams, "teams.csv", select);
                    } else if (select == 2) {
                        teamExporter.exportTeamsToCSV(teams, "teams.txt", select);
                    } else {
                        System.out.println("You have selected a wrong option.");
                    }
                }
            }
        }while (e != 8);
    }
}