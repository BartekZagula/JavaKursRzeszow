package KursJavaRzeszow2020.Bartek2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeagueTestTeam {

    public static void main(String[] args){
        FootballTeam footballTeam1 = new FootballTeam("Atletico Madrid");
        FootballTeam footballTeam2 = new FootballTeam("Real Madrid");
        Team footballTeam3 = new FootballTeam("Barcelona");
        Team footballTeam4 = new FootballTeam("Valencia CF");

        VolleyballTeam volleyballTeam1 = new VolleyballTeam();
        VolleyballTeam volleyballTeam2 = new VolleyballTeam();
        Team volleyballTeam3 = new VolleyballTeam();
        Team volleyballTeam4 = new VolleyballTeam();


        footballTeam1.setPoints(10);
        footballTeam2.setPoints(12);
        footballTeam3.setPoints(7);
        footballTeam4.setPoints(16);

        volleyballTeam1.setPoints(10);volleyballTeam1.setName("Skra Belchatow");
        volleyballTeam2.setPoints(8);volleyballTeam2.setName("Asseco Resovia");
        volleyballTeam3.setPoints(16);volleyballTeam3.setName("Zaksa");
        volleyballTeam4.setPoints(14);volleyballTeam4.setName("Jastrzebski Wegiel");

        LeagueTeam<FootballTeam> footballLeague = new LeagueTeam("Primiera Division");
        LeagueTeam<VolleyballTeam> volleyballLeague = new LeagueTeam("Plus Liga");

        footballLeague.AddTeam(footballTeam1) ;
        footballLeague.AddTeam(footballTeam2);
        footballLeague.AddTeam((FootballTeam)footballTeam3);
        footballLeague.AddTeam((FootballTeam)footballTeam4);
        volleyballLeague.AddTeam(volleyballTeam1);
        volleyballLeague.AddTeam(volleyballTeam2);
        volleyballLeague.AddTeam((VolleyballTeam)volleyballTeam3);
        volleyballLeague.AddTeam((VolleyballTeam)volleyballTeam4);


        System.out.println("---------------------");
        volleyballLeague.pirntTable();

        System.out.println("----------------------");
        footballLeague.pirntTable();

        System.out.println("----------------------");

        for (Object o : footballLeague.getLeagueTeams()) {
            System.out.println(((Team) o).getName());
        }
        System.out.println("----------------------");

        System.out.println("Stream print");
        footballLeague.getLeagueTeams().stream().
                forEach(t -> System.out.println(t.getName()));

        System.out.println("----------------------");
        System.out.println("Stream print with maping teams to names");
        footballLeague.getLeagueTeams().stream()
                .map(x -> x.getName()).forEach(x -> System.out.println(x));

        System.out.println("----------------------");
        System.out.println("Stream print with maping teams to names v2");
        footballLeague.getLeagueTeams().stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Stream print with maping teams to names");
        footballLeague.getLeagueTeams().stream()
                .map(Team::getName).forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Stream print with maping teams to names limited to two teams" );
        footballLeague.getLeagueTeams().stream().limit(2)
                .map(Team::getName).forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("Stream print with maping teams to names where points more than 10" );
        footballLeague.getLeagueTeams().stream().filter(x->x.getPoints() > 10)
                .map(Team::getName).forEach(System.out::println);

        System.out.println("----------------------");
        System.out.println("League copy with teams where points more than 10" );
        List<FootballTeam> teamCopy = footballLeague.getLeagueTeams().stream().
                filter(x->x.getPoints() > 10)
                .collect(Collectors.toList());

        teamCopy.stream().forEach(x -> System.out.println(x.getName()));

        //dodanie drugiej kopii
        List<FootballTeam> teamCopy2 = footballLeague.getLeagueTeams().stream().
                filter(x->x.getPoints() > 10)
                .collect(Collectors.toList());

        //łaczenie strumieni

        List<FootballTeam> teamConcat =
                Stream.concat(teamCopy.stream(), teamCopy2.stream())
                        .collect(Collectors.toList());


        System.out.println("----------------------");
        System.out.println("two streams connected" );
        teamConcat.stream().forEach(x -> System.out.println(x.getName()));

        //laczenie strumieni v2
        List<FootballTeam> teamConcat2 =
                Stream.of(teamCopy, teamCopy2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("----------------------");
        System.out.println("two streams connected v2" );
        teamConcat.stream().forEach(x -> System.out.println(x.getName()));

        //Lista nazw druzyn z listy druzyn

        List<String> teamNames = teamConcat2.stream()
                .map(Team::retriveName)
                .collect(Collectors.toList());

        System.out.println("----------------------");
        System.out.println("List nazw z listy (list)" );
        teamNames.stream().forEach(System.out::println);

        Set<String> teamNamesSet = teamConcat2.stream()
                .map(Team::retriveName)
                .collect(Collectors.toSet());

        System.out.println("----------------------");
        System.out.println("List nazw z listy (Set)" );
        teamNamesSet.stream().forEach(System.out::println);

        System.out.println("---------------------");
        volleyballLeague.printTable();

        int sumPoints = footballLeague.getLeagueTeams().stream()
                .map(Team::getPoints)
                .reduce(0,Integer::sum);

        System.out.println("----------------------");
        System.out.println("Suma pkt równa sie: \n" +sumPoints );

        // zliczanie elementow

        long countElements = footballLeague.getLeagueTeams().stream()
                .map(Team::getPoints).count();

        System.out.println("----------------------");
        System.out.println("Zliczanie elementow v1 \n" +countElements );

        countElements = footballLeague.getLeagueTeams().stream().count();

        System.out.println("----------------------");
        System.out.println("Zliczanie elementow v2 \n" +countElements );

        countElements = footballLeague.getLeagueTeams().stream()
                .filter(x -> x.getPoints() < 8)
                .count();
        System.out.println("----------------------");
        System.out.println("Zliczanie elementow mniejszych od osiem\n" +countElements );

        //suma punktow druzyn gdzie druzyna ma conajmniej 10 pkt

        int sumPoints2 = footballLeague.getLeagueTeams().stream()
                .filter(x -> x.getPoints() >=10)
                .map(Team::getPoints)
                .reduce(0,Integer::sum);

        System.out.println("----------------------");
        System.out.println("Suma pkt druzyn z conajmniej 10 pkt równa sie: \n" +sumPoints2 );

        sumPoints2 = footballLeague.getLeagueTeams().stream()
                .filter(x -> x.getPoints() >=10)
                .map(Team::getPoints)
                .reduce(0,Integer::sum);

        System.out.println("----------------------");
        System.out.println("Suma pkt druzyn z conajmniej 10 pkt równa sie: \n" +sumPoints2 );

        Integer max = footballLeague.getLeagueTeams().stream()
                .mapToInt((t -> t.getPoints()))
                .max()
                .orElse(new Integer(0));
        System.out.println("max :" +max);

        Team teamExpected = footballLeague.getLeagueTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .orElseThrow((NoSuchElementException::new));
        System.out.println("max from team :" +teamExpected.getPoints());


        Integer max2 = footballLeague.getLeagueTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .map(Team::getPoints)
                .orElseThrow(NoSuchElementException::new);
        System.out.println("max2 :" +max2);

        Optional<Integer> max3 = footballLeague.getLeagueTeams().stream()
                .max(Comparator.comparing(Team::getPoints))
                .map(Team::getPoints);
        if(max3.isPresent()) System.out.println("max3 :" +max3);










    }
}
