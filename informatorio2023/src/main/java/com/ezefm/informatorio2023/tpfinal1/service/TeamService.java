package com.ezefm.informatorio2023.tpfinal1.service;

import com.ezefm.informatorio2023.tpfinal1.entity.Fut5Team;
import com.ezefm.informatorio2023.tpfinal1.entity.Player;

import java.time.LocalDate;
import java.util.*;

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

    public void deleteTeamByName(List<Fut5Team> teams){
        boolean removed = false;
        System.out.print("Team name: ");
        String teamName = sc.nextLine();
        Iterator<Fut5Team> it = teams.iterator();
        while(it.hasNext()){
            Fut5Team team = it.next();
            if(team.getName().equals(teamName)){
                it.remove();
                removed = true;
                break;
            }
        }
        if(removed){
            System.out.println("Team removed");
        } else {
            System.out.println("Team doesn't exist");
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

    public void findTeamByTeamCoachCaptainName(List<Fut5Team> teams){
        System.out.print("Team name: ");
        String teamName = sc.nextLine();
        System.out.print("Coach name: ");
        String coachName = sc.nextLine();
        System.out.println("Captain name: ");
        String captainName = sc.nextLine();
        for(Fut5Team team : teams){
            if(team.getName().equals(teamName) && team.getCoach().equals(coachName)){
                for(Player p : team.getPlayers()){
                    if(p.getCaptain() && p.getName().equals(captainName)){
                        System.out.printf("""
                        Team name: %s
                        Coach name: %s
                        Player List: %s
                        """, team.getName(), team.getCoach(), team.getPlayers());
                    }
                }
            }
        }
    }

    public Fut5Team findTeam(List<Fut5Team> teams){
        Fut5Team team = null;
        System.out.println("Team name: ");
        String name = sc.nextLine();
        for(Fut5Team t : teams){
            if(t.getName().equals(name)){
                team = t;
                break;
            }
        }
        return team;
    }

    public void findTeamByName(List<Fut5Team> teams){
        Fut5Team team = findTeam(teams);
        String msg = team != null ?
                "Team name: " + team.getName() + "\n" +
                "Coach name: " + team.getCoach() +  "\n" +
                "Player List: " + team.getPlayers()
                : "Team doesnt' exist";
        System.out.println(msg);
    }

    private void compareTeams(List<Fut5Team> teams, Comparator<Player> comparing) {
        Fut5Team team = findTeam(teams);
        if(team != null){
            List<Player> players = team.getPlayers();
            players.sort(comparing);
            System.out.printf("""
                        Team name: %s
                        Coach name: %s
                        Player List: %s
                        """, team.getName(), team.getCoach(), players);
        } else {
            System.out.println("Team doesn't exist");
        }
    }

    public void findTeamByNameOrderByPlayerName(List<Fut5Team> teams){
        compareTeams(teams, Comparator.comparing(Player::getName));
    }

    public void findTeamByNameOrderByPlayerNumber(List<Fut5Team> teams){
        compareTeams(teams, Comparator.comparing(Player::gettShirtNumber));
    }

    public void findTeamByNameOrderByPositionAndTShirtNumber(List<Fut5Team> teams) {
    compareTeams(teams, Comparator.comparing(Player::getPosition)
                                      .thenComparing(Player::gettShirtNumber));
    }

    public void showTeams(List<Fut5Team> teams){
        teams.forEach(System.out::println);
    }
}