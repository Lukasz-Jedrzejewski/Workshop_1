package pl.coderslab.Game_3;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        guessNumber();
    }
    static int guessNumber(){
        System.out.println("Type your number in range of 1 - 1000." +
                "\nI will try to guess in max 10 attempts");
        int min = 0;
        int max = 1000;
        int guess = ((max - min) / 2) + min;
        String answer = "";
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Answer: too much, not enough or you guessed it");
            System.out.println("Guess: " + guess);
            answer = scan.nextLine();
            if ((!answer.equalsIgnoreCase("too much")) && (!answer.equalsIgnoreCase("not enough"))
                    && (!answer.equalsIgnoreCase("you guesssed it")))
                System.out.println("Bad answer");
            if (answer.contains("too much")){
                max = guess;
                guess = ((max - min) / 2) + min;
            } else if (answer.contains("not enough")){
                min = guess;
                guess = ((max - min) / 2) + min;
            } else
                System.out.println("I won!");
        }
        return guess;
    }
}
