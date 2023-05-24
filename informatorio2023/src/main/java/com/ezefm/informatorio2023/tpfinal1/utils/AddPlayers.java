package com.ezefm.informatorio2023.tpfinal1.utils;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;
import com.ezefm.informatorio2023.tpfinal1.entity.Position;

import java.util.List;


public class AddPlayers {
    public void fillPlayersList(List<Fut5Team> teams){
        int player  = 1;
        boolean captain;
        for(Fut5Team team : teams){
            for(int i = 1; i <= 7; i++){
                captain = i == 1;
                Position position = Position.values()[(int) (Math.random() * Position.values().length)];
                team.getPlayers().add(new Player(
                        "Player " + player,
                        "Fut5Team",
                        position,
                        (int)(Math.random() * 100),
                        (int)(Math.random() * 100),
                        captain,
                        (int)(Math.random() * 10),
                        team.getName()
                ));
                player++;
            }
        }
    }

}