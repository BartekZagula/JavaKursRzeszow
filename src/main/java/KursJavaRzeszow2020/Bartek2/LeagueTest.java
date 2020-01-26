package KursJavaRzeszow2020.Bartek2;

public class LeagueTest {

    public static void main(String[] args){
        Team footballTeam1 = new FootballTeam("Atletico Madrid");
        Team footballTeam2 = new FootballTeam("Real Madrid");
        Team footballTeam3 = new FootballTeam("Barcelona");
        Team footballTeam4 = new FootballTeam("Valencia CF");

        Team volleyballTeam1 = new VolleyballTeam();
        Team volleyballTeam2 = new VolleyballTeam();
        Team volleyballTeam3 = new VolleyballTeam();
        Team volleyballTeam4 = new VolleyballTeam();

        footballTeam1.setPoints(10);
        footballTeam2.setPoints(12);
        footballTeam3.setPoints(8);
        footballTeam4.setPoints(16);

        volleyballTeam1.setPoints(10);volleyballTeam1.setName("Skra Belchatow");
        volleyballTeam2.setPoints(8);volleyballTeam2.setName("Asseco Resovia");
        volleyballTeam3.setPoints(16);volleyballTeam3.setName("Zaksa");
        volleyballTeam4.setPoints(14);volleyballTeam4.setName("Jastrzebski Wegiel");

        League footballLeague = new League("Primiera Division");
        League volleyballLeague = new League("Plus Liga");

        footballLeague.AddTeam(footballTeam1);
        footballLeague.AddTeam(footballTeam2);
        footballLeague.AddTeam(footballTeam3);
        footballLeague.AddTeam(footballTeam4);
        volleyballLeague.AddTeam(volleyballTeam1);
        volleyballLeague.AddTeam(volleyballTeam2);
        volleyballLeague.AddTeam(volleyballTeam3);
        volleyballLeague.AddTeam(volleyballTeam4);

        System.out.println("---------------------");
        volleyballLeague.pirntTable();

        System.out.println("----------------------");
        footballLeague.pirntTable();
    }
}
