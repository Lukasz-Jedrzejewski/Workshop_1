package pl.coderslab.Game_5;

import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Connection connect = Jsoup.connect("https://www.money.pl/");
        List<String> titles = new ArrayList<>();
        try {
            Document doc = connect.get();
            Elements links = doc.select("span.tittle");
            for (Element elem : links) {
                titles.add(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ArrayUtils.toString(titles));
    }



}
