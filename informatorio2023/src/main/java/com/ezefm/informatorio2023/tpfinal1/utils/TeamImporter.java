package com.ezefm.informatorio2023.tpfinal1.utils;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;
import com.ezefm.informatorio2023.tpfinal1.entity.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TeamImporter {

    private final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("M/d/yyyy");

    public void importTeamsFromCSV(List<Fut5Team> teams, String fileName, int election) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    // Ignore the first line containing headers
                    firstLine = false;
                    continue;
                }
                String[] fields = line.split(","); // Separate the fields using the delimiter

                // Create Fut5Team and Player objects using values of the fields
                String teamName = fields[0];
                String creationDate = fields[1];
                String playerName = fields[2];
                String playerLastname = fields[3];
                String position = fields[4];
                int goals = Integer.parseInt(fields[5]);
                int matchesPlayed = Integer.parseInt(fields[6]);
                boolean isCaptain = Boolean.parseBoolean(fields[7]);
                int tShirtNumber = Integer.parseInt(fields[8]);

                Player player = new Player(playerName, playerLastname, Position.valueOf(position), goals, matchesPlayed, isCaptain, tShirtNumber, teamName);

                // Check if the team already exist on the list
                Fut5Team team = teams.stream()
                        .filter(t -> t.getName().equals(teamName))
                        .findFirst()
                        .orElse(null);
                if (team == null) {
                    // If team doesn't exist creates a new one and adds it to the list
                    team = new Fut5Team(teamName, LocalDate.parse(creationDate, formatterDate), new ArrayList<>(), "");
                    teams.add(team);
                }
                // Add player to team
                team.getPlayers().add(player);
            }
            System.out.println(election == 1 ?
                    "Teams imported from CSV successfully." : "Teams imported from TXT successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while importing teams from CSV: " + e.getMessage());
        }
    }
}