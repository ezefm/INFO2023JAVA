package com.ezefm.informatorio2023.tpfinal1.utils;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddTeams {
    public void fillTeamList(List<Fut5Team> teams){
        for(int i = 1; i <= 100; i++){
            teams.add(new Fut5Team(
                    "Team " + i,
                    LocalDate.now(),
                    new ArrayList<Player>(),
                    "Coach Team " + i
            ));
        }
    }


}