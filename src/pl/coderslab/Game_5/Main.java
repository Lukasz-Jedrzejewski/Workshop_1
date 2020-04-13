package pl.coderslab.Game_5;

import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Connection connect = Jsoup.connect("https://www.Onet.pl/");
        List<String> titles = new ArrayList<>();
        List<String> splited = new ArrayList<>();

        try {
            Document doc = connect.get();
            Elements links = doc.select("span.title");
            for (Element elem : links) {
                titles.add(elem.text());

            }
            for (String line : titles) {
                List<String> sl = Arrays.asList(line.split("\\p{Punct}+|\\s+|\\s+|\\d+"));
                splited.addAll(sl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(titles);
        System.out.println(splited);
        List<String> withoutSmallthan3 = new ArrayList<>();
        for (int i = 0; i < splited.size(); i++) {
            if (splited.get(i).length() > 3)
                withoutSmallthan3.add(splited.get(i));
        }
        System.out.println(withoutSmallthan3);
        Path path = Paths.get("/home/lukasz/Pulpit/javaCD/Workshop_1/src/pl/coderslab/Game_5/popularWords.txt");
        try {
            PrintWriter printWriter = new PrintWriter("writeFile.txt");
            printWriter.println("first line");
            try {
                Files.write(path, withoutSmallthan3);
            } catch (ConcurrentModificationException e) {
                e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }

        File file = new File("/home/lukasz/Pulpit/javaCD/Workshop_1/src/pl/coderslab/Game_5/popularWords.txt");
        StringBuilder reading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                reading.append(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
        System.out.println(reading.toString());



    }





}
