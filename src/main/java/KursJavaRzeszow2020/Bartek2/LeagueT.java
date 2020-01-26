package KursJavaRzeszow2020.Bartek2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeagueT<T> {
    private String Leaguename;
    private List<T> LeagueTeams;

    public LeagueT(String leaguename) {
        Leaguename = leaguename;
        LeagueTeams = new ArrayList<>();
    }

    public String getLeaguename() {
        return Leaguename;
    }

    public void setLeaguename(String leaguename) {
        Leaguename = leaguename;
    }

    public List<T> getLeagueTeams() {
        return LeagueTeams;
    }

    public void setLeagueTeams(List<T> leagueTeams) {
        LeagueTeams = leagueTeams;
    }

    public boolean AddTeam(T teams) {
        if (isteamonlist(teams)) {
            System.out.println("Kierowca " + ((Team)(teams)).getName() + "juz jest na liscie");
            return false;
        }
        return LeagueTeams.add(teams);

    }

    private boolean isteamonlist(T teams) {
        return LeagueTeams.indexOf(teams) >= 0;

    }

    public void pirntTable(){
        Collections.sort((List<Team>)LeagueTeams);
        System.out.println(Leaguename + " table:");
        for(T team : LeagueTeams){
            System.out.println(((Team)team).getName() + " " +((Team)team).getPoints());
        }
    }
}
