package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Player;
import com.ezefm.informatorio2023.tpfinal1.entity.Position;

import java.util.Scanner;

public class PlayerService {
    private final Scanner sc = new Scanner(System.in);
    public Player newPlayer(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Lastname: ");
        String lastName = sc.nextLine();
        System.out.print("Position (GOALKEEPER, DEFENCE, A_MIDFIELDER, A_MIDDLE_FORWARD, A_FORWARD): ");
        Position position = Position.valueOf(sc.nextLine());
        System.out.print("Goals: ");
        Integer goals = Integer.valueOf(sc.next());
        System.out.print("Matches Played: ");
        Integer matchesPlayed = Integer.valueOf(sc.next());
        System.out.print( "Is captain ? (true-false): ");
        Boolean isCaptain = Boolean.valueOf(sc.next());
        System.out.print("t-shirt number: ");
        Integer tShirtNumber = Integer.valueOf(sc.next());
        return new Player(name, lastName, position, goals, matchesPlayed, isCaptain, tShirtNumber, null);
    }
}