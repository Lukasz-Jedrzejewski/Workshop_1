package pl.coderslab.Game_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


    }


    private static void userInput() {
        Scanner in = new Scanner(System.in);
        String abc;
        String[] arr = {"", "", "", "", ""};
        int licznik = 0;
        System.out.println("Enter code");
        abc = in.nextLine();
        if (abc.matches("\\d+[D,d]\\d+[+,-]\\d+") || abc.matches("[D,d]\\d+[+,-]\\d+")
                || abc.matches("[D,d]\\d+") || abc.matches("\\d+[D,d]\\d+")) {
            for (int i = 0; i < abc.length(); i++) {
                while (Character.isDigit(abc.charAt(i))) {
                    arr[licznik] += abc.charAt(i);
                    if (i == abc.length() - 1)
                        break;
                    i++;
                    System.out.println(Arrays.toString(arr));
                }
                licznik++;
                if (abc.charAt(i) == 'D' || abc.charAt(i) == 'd') {
                    arr[licznik] += abc.charAt(i);
                    System.out.println(Arrays.toString(arr));
                    licznik++;
                } else if (abc.charAt(i) == '+' || abc.charAt(i) == '-') {
                    arr[licznik] += abc.charAt(i);
                    System.out.println(Arrays.toString(arr));
                    licznik++;
                }
            }
            System.out.println(Arrays.toString(arr));
        } else {
            System.out.println("Wrong format");
            userInput();
        }
    }



}
