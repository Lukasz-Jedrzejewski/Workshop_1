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
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection connect = Jsoup.connect("https://www.onet.pl/");
        List<String> titles = new ArrayList<>();
        try {
            Document doc = connect.get();
            Elements links = doc.select("span.title");
            for (Element elem : links) {
                titles.add(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(titles);
        Path path = Paths.get("/home/lukasz/Pulpit/javaCD/Workshop_1/src/pl/coderslab/Game_5/popularWords.txt");
        try {
            PrintWriter printWriter = new PrintWriter("writeFile.txt");
            printWriter.println("first line");
            try {
                for (String line : titles) {
                    titles.addAll(titles);
                    Files.write(path, titles);
                }
            } catch (ConcurrentModificationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Błąd zapisu do pliku.");
        }




    }





}
