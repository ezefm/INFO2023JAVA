package com.ezefm.informatorio2023.tpfinal1.utils;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TeamExporter {
    private final Scanner sc = new Scanner(System.in);

    public void exportTeamToCsvOrTxt(List<Fut5Team> teams, String fileName, int election){

        Fut5Team team = null;
        System.out.println("Team name: ");
        String name = sc.nextLine();
        for(Fut5Team t : teams){
            if(t.getName().equals(name)){
                team = t;
            }
        }
        if(team == null ){
            System.out.println("Team doesn't exist");
        } else {
            String filePath = "src/main/java/com/ezefm/informatorio2023/tpfinal1/files/" + fileName;
            try (FileWriter writer = new FileWriter(filePath)) {
                // Headers - Title
                writer.write("Team Name,Creation Date,Player Name, Player Lastname, Position,Goals,Matches Played,Is Captain,T-Shirt Number\n");

                String teamName = team.getName();
                String creationDate = String.valueOf(team.getCreationDate());

                for (Player player : team.getPlayers()) {
                    writer.write(String.format("%s,%s,%s,%s,%s,%d,%d,%s,%d\n",
                            teamName, creationDate,
                            player.getName(), player.getLastName(), player.getPosition(),
                            player.getGoals(), player.getMatchesPlayed(),
                            player.getCaptain() ? "Yes" : "No",
                            player.gettShirtNumber()));
                }
                System.out.println(election == 1 ?
                        "Teams exported to CSV successfully." : "Teams exported to TXT successfully.");
            } catch (IOException e) {
                System.err.println("An error occurred while exporting teams: " + e.getMessage());
            }
        }
    }

    public void exportTeamsToCsvOrTxt(List<Fut5Team> teams, String fileName, int election) {
        String filePath = "src/main/java/com/ezefm/informatorio2023/tpfinal1/files/" + fileName;
        try (FileWriter writer = new FileWriter(filePath)) {
            // Headers - Title
            writer.write("Team Name,Creation Date,Player Name, Player Lastname, Position,Goals,Matches Played,Is Captain,T-Shirt Number\n");

            for (Fut5Team team : teams) {
                String teamName = team.getName();
                String creationDate = String.valueOf(team.getCreationDate());

                for (Player player : team.getPlayers()) {
                    writer.write(String.format("%s,%s,%s,%s,%s,%d,%d,%s,%d\n",
                            teamName, creationDate,
                            player.getName(), player.getLastName(), player.getPosition(),
                            player.getGoals(), player.getMatchesPlayed(),
                            player.getCaptain() ? "Yes" : "No",
                            player.gettShirtNumber()));
                }
            }
            System.out.println(election == 1 ?
                    "Teams exported to CSV successfully." : "Teams exported to TXT successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while exporting teams: " + e.getMessage());
        }
    }

}
