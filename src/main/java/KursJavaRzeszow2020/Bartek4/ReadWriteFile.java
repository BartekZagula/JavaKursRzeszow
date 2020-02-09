package KursJavaRzeszow2020.Bartek4;

import java.io.*;
import java.util.*;

public class ReadWriteFile {

    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.simpleWriteToFile();
        readWriteFile.writeTOFileWithResources();
        readWriteFile.readFileSimple();
        List<DataStorage> storage = new ArrayList<>();
        storage.add(new DataStorage(0, "Adam", "Nowak"));
        storage.add(new DataStorage(1, "Jan", "Nowak"));
        storage.add(new DataStorage(2, "Maria", "Nowak"));

        try {
            readWriteFile.writeWithBufferedWriter(storage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Zawsze sie wykonuje");
        }
        System.out.println("Wypisanie zawartosci Mapy");
        Map<Integer, DataStorage> content = readWriteFile.readWithBufferedReader();
        content.values().stream().forEach(s -> System.out.println(s.getIndex() + " "
        + s.getData1() + " " + s.getData2()));

       /* System.out.println("Varrargs example");
        System.out.println(readWriteFile.varargsSum(3,10));
        System.out.println(readWriteFile.varargsSum(3));
        System.out.println(readWriteFile.varargsSum(3,10,20));
        System.out.println(readWriteFile.varargsSum(3,10,20,30));
        System.out.println(readWriteFile.varargsSum(3,10,10,10));*/

    }

    public boolean simpleWriteToFile() {
        try {
            FileWriter fileWriter = new FileWriter("Samplefile.txt");
            fileWriter.write("Sample line one \n");
            fileWriter.write("Sample line two");

            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean writeTOFileWithResources() {

        final String lineDelimiter = "\n";
        try (FileWriter fileWriter = new FileWriter("AnotherFile.txt")) {
            fileWriter.write("First line" + lineDelimiter);
            fileWriter.write("Second line");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean readFileSimple() {
        String fileName = "Samplefile.txt";
        File file = new File(fileName);
        Scanner scanner = null;

        try {
            scanner = new Scanner(new FileReader(file.getName()));
            scanner.useDelimiter("\n");
            System.out.println("Reading file : " + fileName);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Arithemtic Error");
        }
        return false;
    }

    public boolean writeWithBufferedWriter(List<DataStorage> dataToWrite)
            throws IOException {
        String fieldSeparator = ";";
        String lineSeparator = "\n";
        BufferedWriter file = new BufferedWriter(
                new FileWriter("DataList.txt")
        );
        for (DataStorage storage : dataToWrite) {
            file.write(storage.getIndex() + fieldSeparator
                    + storage.getData1() + fieldSeparator
                    + storage.getData2() + lineSeparator);

        }
        file.close();

        return false;

    }

    public Map readWithBufferedReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader("DataList.txt"))) {
            String input;
            String fieldSeparator = ";";
            Map<Integer, DataStorage> dataStorageMap = new HashMap<>();
            while ((input = reader.readLine()) != null) {
                String[] dataLine = input.split(fieldSeparator);
                int index = Integer.parseInt(dataLine[0]);
                DataStorage storage = new DataStorage(index, dataLine[1], dataLine[2]);
                dataStorageMap.put(index, storage);
            }
            return dataStorageMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
   /* private  int varargsSum(int a, int...b) {
        int suma=a;
        for(int i =0; i<b.length; i++) {
            suma += b[i];
        }
        return suma;
    }*/
}
