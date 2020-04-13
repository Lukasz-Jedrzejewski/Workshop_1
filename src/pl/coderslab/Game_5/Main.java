package pl.coderslab.Game_5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        result(reading());
    }

    static void  result (List <String> withoutWordsShorterThanThreeCharacters) {
        //zapis do pliku
        Path path = Paths.get("/home/lukasz/Pulpit/javaCD/Workshop_1/src/pl/coderslab/Game_5/popular_words.txt");
        try {
            Files.write(path, withoutWordsShorterThanThreeCharacters);
        } catch (ConcurrentModificationException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //przepisanie pliku popular_words do listy
        List<String> finalList = new ArrayList<>();
        try {
            finalList = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //dodanie listy słów wykluczonych
        List<String> excluded = List.of("oraz", "tudzież", "albo", "bądź", "aczkolwiek", "jednak", "lecz", "natomiast",
                "czyli", "mianowicie", "ponieważ", "jest", "dlatego", "więc", "zatem", "toteż", "bowiem", "choć", "jeżeli",
                "raczej");
        //usunięcie słów wykluczonych z finalnej listy
        finalList.removeAll(excluded);

        Path finalPath = Paths.get("/home/lukasz/Pulpit/javaCD/Workshop_1/" +
                "src/pl/coderslab/Game_5/filtered_popular_words.txt");
        try {
            Files.write(finalPath, finalList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //odczyt pliku
        File file = new File("/home/lukasz/Pulpit/javaCD/Workshop_1/src/pl/coderslab/Game_5/" +
                "filtered_popular_words.txt");
        StringBuilder reading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                reading.append(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file to read");
        }
        System.out.println(reading.toString());
    }

    static List<String> reading() {
        Scanner scan = new Scanner(System.in);
        String input;
        Connection connect;
        while (true) {
            try {
                System.out.println("Enter url");
                input = scan.nextLine();
                // Wywołanie pobierania
                connect = Jsoup.connect(input);
                break;
            } catch (Exception e) {
                System.out.println("Wrong url");
            }
        }
        List<String> titles = new ArrayList<>();
        List<String> splited = new ArrayList<>();
        try {
            Document doc = connect.get();
            Elements links = doc.select("span.title");
            for (Element elem : links) {
                titles.add(elem.text());
            }
            // Eliminacja zbędnych znaków/dzielenie na pojedyncze słowa
            for (String line : titles) {
                List<String> sl = Arrays.asList(line.split("\\p{Punct}+|\\s+|\\s+|\\d+"));
                splited.addAll(sl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //usuwanie słów krótszych niż 3 znaki
        List<String> withoutWordsShorterThanThreeCharacters = new ArrayList<>();
        for (int i = 0; i < splited.size(); i++) {
            if (splited.get(i).length() > 3)
                withoutWordsShorterThanThreeCharacters.add(splited.get(i));
        }
        return withoutWordsShorterThanThreeCharacters;
    }

}
