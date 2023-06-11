package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;
import com.ezefm.informatorio2023.tpfinal1.entity.Position;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PlayerService {
    private final Scanner sc = new Scanner(System.in);
    public Player newPlayer(){
        System.out.print("Player firstname: ");
        String name = sc.nextLine();
        System.out.print("Lastname: ");
        String lastName = sc.nextLine();
        System.out.print("Position (GOALKEEPER, DEFENCE, A_MIDFIELDER, A_MIDDLE_FORWARD, A_FORWARD): ");
        Position position = Position.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Goals: ");
        Integer goals = Integer.valueOf(sc.nextLine());
        System.out.print("Matches Played: ");
        Integer matchesPlayed = Integer.valueOf(sc.nextLine());
        System.out.print( "Is captain ? (true-false): ");
        Boolean isCaptain = Boolean.valueOf(sc.nextLine().toLowerCase());
        System.out.print("t-shirt number: ");
        Integer tShirtNumber = Integer.valueOf(sc.nextLine());
        System.out.println("A player has been created");
        return new Player(name, lastName, position, goals, matchesPlayed, isCaptain, tShirtNumber, null);
    }

    public void findPlayerByName(List<Player> players, String name){
        Optional<Player> p = players.stream()
                .filter(x -> name.equalsIgnoreCase(x.getName() + " " + x.getLastName()))
                .findFirst();
        p.ifPresentOrElse(player -> System.out.printf("""
                        Name: %s
                        Lastname: %s
                        Position: %s
                        Is Captain?: %s
                        Team name: %s
                        """, player.getName(),
                player.getLastName(),
                player.getPosition(),
                player.getCaptain(),
                player.getTeam()),
                () -> System.out.println("Player doesn't exist"));
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