package KursJavaRzeszow2020.Bartek2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    private String Leaguename;
    private List<Team> LeagueTeams;

    public League(String leaguename) {
        Leaguename = leaguename;
        LeagueTeams = new ArrayList<>();
    }

    public String getLeaguename() {
        return Leaguename;
    }

    public void setLeaguename(String leaguename) {
        Leaguename = leaguename;
    }

    public List<Team> getLeagueTeams() {
        return LeagueTeams;
    }

    public void setLeagueTeams(List<Team> leagueTeams) {
        LeagueTeams = leagueTeams;
    }

    public boolean AddTeam(Team teams) {
        if (isteamonlist(teams)) {
            System.out.println("Kierowca " + teams.getName() + "juz jest na liscie");
            return false;
        }
        return LeagueTeams.add(teams);

    }

    private boolean isteamonlist(Team teams) {
        return LeagueTeams.indexOf(teams) >= 0;

    }

    public void pirntTable(){
        Collections.sort(LeagueTeams);
        System.out.println(Leaguename + " table:");
        for(Team team : LeagueTeams){
            System.out.println(team.getName() + " " +team.getPoints());
        }
    }
}
