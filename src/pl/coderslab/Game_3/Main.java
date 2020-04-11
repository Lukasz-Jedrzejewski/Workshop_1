package pl.coderslab.Game_3;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        guessNumber();
    }

    static int guessNumber() {
        System.out.println("Type your number in range of 0 - 1000." +
                "\nI will try to guess in max 10 attempts");
        int min = 0;
        int max = 1000;
        int counter = 1;
        int guess = ((max - min) / 2) + min;
        String answer = "";
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Answer: too much, not enough or you guessed it");
            System.out.println("Guess " + counter + " " + i +" :" + guess);
            answer = scan.nextLine();
            counter++;
//            if ((!answer.equalsIgnoreCase("too much")) && (!answer.equalsIgnoreCase("not enough"))
//                    && (!answer.equalsIgnoreCase("you guessed it"))) {
//            }
            if (answer.equalsIgnoreCase("too much")) {
                if (i == 9) {
                    System.out.println("Don't cheat \nLet's try again\n");
                    guessNumber();
                } else {
                    max = guess;
                    guess = ((max - min) / 2) + min;
                }
            } else if (answer.equalsIgnoreCase("not enough")) {
                if(i == 9) {
                    System.out.println("Don't cheat \nLet's try again\n");
                    guessNumber();
                } else {
                    min = guess;
                    guess = ((max - min) / 2) + min;
                }
            } else if (answer.equalsIgnoreCase("you guessed it")) {
                System.out.println("I won!");
                break;
            } else {
                System.out.println("Bad answer");
                i--;
                counter--;
            }
        }
        return guess;
    }
}
