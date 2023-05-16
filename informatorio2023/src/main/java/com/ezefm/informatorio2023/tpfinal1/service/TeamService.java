package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamService {

    private final PlayerService playerService = new PlayerService();
    private final Scanner sc= new Scanner(System.in);
    public Fut5Team newTeam(){
        System.out.print("Name: ");
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
}