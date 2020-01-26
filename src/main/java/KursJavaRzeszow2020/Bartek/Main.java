package KursJavaRzeszow2020.Bartek;

import org.apache.log4j.Logger;

import java.util.*;

public class Main {

    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Person2 person1 = new Polish();
        person1.setFirstName("Anna");
        person1.setLastName("Pradun");
        person1.setAge(35);
        person1.setSex(Sex.WOMAN);
        Person2 person2 = new Polish("Jan", "Kowalski", 4);

        System.out.println("Person1 : " + person1);
        System.out.println("Person2 : " + person2);

        Person2 polish1 = new Polish("Maria", "Wanat", 2);
        System.out.println("Polish : " + polish1);
        polish1.setSex(Sex.WOMAN);
        polish1.setAge(70);
        System.out.println(polish1.isRetired());

        Polish polish2 = new Polish("Andrzej", "Majkut", 4);
        polish2.setSex(Sex.MAN);
        System.out.println(polish2);

        ((Polish) polish1).enabledKdr();

        Race race1 = new Race("Go Karty", 10);
        Race race2 = new Race("F1 Monte Carlo", 12);
        Race race3 = new Race("F1 Le Mans", 18);
        Race race4 = new Race("F1 Monte Carlo", 14);
        race1.setRaceYear(2019);
        race2.setRaceYear(2019);
        race3.setRaceYear(2019);
        race4.setRaceYear(2020);

        List<Race> races = new LinkedList<>();
        races.add((race1));
        races.add((race2));
        races.add((race3));
        races.add((race4));
        System.out.println("----------------------------");
        System.out.println("Wydruk Wyscigów bez sortowania");

        for (Race race : races) {
            System.out.println(race.getRaceName() + " " + race.getRaceYear());

        }

        System.out.println("----------------------------");
        System.out.println("Wydruk Wyscigów z sortowaniem");
        Collections.sort(races);

        for (Race race : races) {
            System.out.println(race.getRaceName() + " " + race.getRaceYear());

        }

        System.out.println("----------------------------");
        System.out.println("Wydruk Wyscigów z sortowaniem po wieku i nazwie");
        Collections.sort(races, new RaceSortByMinAgeAndName());

        for (Race race : races) {
            System.out.println(race.getRaceName() + " " + race.getRaceYear());

        }

        System.out.println("----------------------------");
        System.out.println("Wydruk Wyscigów z sortowaniem po nazwie i liczbie uczestników");
        Collections.sort(races, new RaceSortByNameAndRacersNumber());

        for (Race race : races) {
            System.out.println(race.getRaceName() + " " + race.getRaceYear());

        }
        System.out.println("---------------------");
        Set<Race> racesSet = new HashSet();
        racesSet.add((race1));
        racesSet.add((race2));
        racesSet.add((race3));
        racesSet.add((race4));
        racesSet.add((race1));
        for (Race race : racesSet) {
            System.out.println(race.getRaceName() + " " + race.getRaceYear());
        }
        System.out.println("---------------------");
        Map<String, Race> raceMap = new HashMap();
        raceMap.put(race1.getRaceName(), race1);
        raceMap.put(race2.getRaceName(), race2);
        raceMap.put(race3.getRaceName(), race3);
        raceMap.put(race4.getRaceName(), race4);
        System.out.println("Mapa po wartosciach");
        for (Race race : raceMap.values()) {
            System.out.println(race.getRaceName() + " " + race.getRaceYear());
        }
        System.out.println("Mapa po kluczach");
        for (String key : raceMap.keySet()) {
            System.out.println(raceMap.get(key).getRaceName() + " "
                    + raceMap.get(key).getRaceYear());
        }
        System.out.println("---------------------");
        Map<String, Race> raceMap2 = new HashMap();
        raceMap2.put(race1.toString(), race1);
        raceMap2.put(race2.toString(), race2);
        raceMap2.put(race3.toString(), race3);
        raceMap2.put(race4.toString(), race4);

        System.out.println("Mapa 2 po kluczach ");
        for (String key : raceMap2.keySet()) {
            System.out.println(raceMap2.get(key).getRaceName() + " "
                    + raceMap2.get(key).getRaceYear());
        }
        // set z zawartosci listy,
        Set<Race> setFromList = new HashSet(races);

        LOGGER.error("This is error massage");
        LOGGER.warn("This is warning");
        LOGGER.fatal("This is fatal error");
        LOGGER.debug("This is debug massage");
        LOGGER.info("THis is info massage");

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("info po sprawdzeniu");
        }
        Main mainTest = new Main();
        try {
            mainTest.divide(10, 0);
        } catch (ArithmeticException ex) {
            LOGGER.error("Something wrong", ex);
        }
    }

    private void divide(int a, int b) {
        int i = a / b;
    }
}
