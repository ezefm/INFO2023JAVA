package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TeamService {

    private final PlayerService playerService = new PlayerService();
    private final Scanner sc= new Scanner(System.in);
    public Fut5Team newTeam(){
        System.out.print("Team name: ");
        String name = sc.nextLine();
        System.out.print("Coach: ");
        String coach = sc.nextLine();
        return new Fut5Team(name, LocalDate.now(), new ArrayList<Player>(), coach);
    }
    public void addPlayer(String teamName, List<Fut5Team> teams){
        for(Fut5Team team : teams){
            if(team.getName().equals(teamName)){
                Player player = playerService.newPlayer();
                player.setTeam(teamName);
                team.getPlayers().add(player);
                break;
            } else {
                System.out.println("Team doesn't exist");
            }
        }
    }
    public Fut5Team createTeam(){
        Fut5Team team = newTeam();
        int e;
        do {
            Player player = playerService.newPlayer();
            player.setTeam(team.getName());
            team.getPlayers().add(player);
            System.out.print("""
                    1. Yes
                    2. No
                    Do you want add other player? :
                    """);
            e = Integer.parseInt(sc.nextLine());
        } while(e != 2);
        return team;
    }
    public void deletePlayerByNameAndTeam(List<Fut5Team> teams){
        System.out.print("Team name: ");
        String team = sc.nextLine();
        for(Fut5Team t : teams){
            if(t.getName().equals(team)){
                System.out.print("Player name: ");
                String playerName = sc.nextLine();
                int initialSize = t.getPlayers().size();
                t.getPlayers().removeIf( player -> player.getName().equals(playerName));
                if(initialSize == t.getPlayers().size()){
                    System.out.println("The player doesn't exist");
                } else {
                    System.out.println("The player has been removed");
                }
                break;
            }
        }
    }

    public void assignCoach(Fut5Team team){
        System.out.print("Coach name: ");
        String coach = sc.nextLine();
        team.setCoach(coach);
    }

    public void getPlayers(List<Fut5Team> teams){
        System.out.println("Team name: ");
        String teamName = sc.nextLine();
        List<Player> players = teams.stream()
                .filter(team -> team.getName().equals(teamName))
                .findFirst()
                .map(Fut5Team::getPlayers)
                .orElse(null);

        if (players != null) {
            players.forEach(player -> System.out.println(player.getName()));
        } else {
            System.out.println("There is no team with the given name");
        }
    }

    public void getCoach(List<Fut5Team> teams){
        System.out.println("Coach name: ");
        String coachName = sc.nextLine();
        String coach = teams.stream()
                .filter(team -> team.getCoach().equals(coachName))
                .findFirst()
                .map(Fut5Team::getCoach)
                .orElse(null);
        System.out.println(Objects.requireNonNullElse(coach, "There is no team with the given name"));
    }

    public void findPlayerByName(List<Fut5Team> teams){
        boolean p = false;
        System.out.println("Player name: ");
        String name = sc.nextLine();
        for(Fut5Team t : teams){
           List<Player> players = t.getPlayers();
           for(Player player : players){
               if((player.getName() + " " + player.getLastName()).equals(name)){
                   System.out.printf("""
                           Name: %s %s
                           Position: %s
                           Captain: %s
                           Team Name: %s
                           """, player.getName(), player.getLastName(), player.getPosition(), player.getCaptain(), player.getTeam());
                   p = true;
                   break;
               }
           }
        }
        if(!p){
            System.out.println("The player doesn't exist");
        }
    }

    public void showTeams(List<Fut5Team> teams){
        for (Fut5Team t : teams){
            System.out.println(t);
        }
    }
}