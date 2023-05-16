package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamService {
    private final Scanner sc= new Scanner(System.in);
    public Fut5Team newTeam(){
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println("Coach: ");
        String coach = sc.nextLine();
        return new Fut5Team(name, LocalDate.now(), new ArrayList<Player>(), coach);
    }

}