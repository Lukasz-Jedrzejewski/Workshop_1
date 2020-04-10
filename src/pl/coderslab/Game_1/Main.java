package pl.coderslab.Game_1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Now I will draw a number from 1 to 100...");
        System.out.println();
        int rand = randNumber(100);
            guessNumber(rand);

    }

    static int randNumber(int max) {
        Random randomNumber = new Random();
        int num = 0;
        num = randomNumber.nextInt(max - 1) + 1;

        return num;

    }

    static int guessNumber(int rand) {
        int guesNumber = 0;
        int counter = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Guess number");
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("This is not a number");
            }
            guesNumber = scan.nextInt();
            if (guesNumber > 100){
                System.out.println("Out of bound");
                continue;
            }
            counter++;

            if (guesNumber > rand) {
                System.out.println("Too big");
            } else if (guesNumber < rand) {
                System.out.println("Too small");
            } else {
                System.out.println("Got it! " + "Your score is: " + counter);
                break;
            }
        }

        return guesNumber;
    }
}
