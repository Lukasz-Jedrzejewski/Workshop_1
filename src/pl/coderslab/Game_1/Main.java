package pl.coderslab.Game_1;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rand = randNumber(100);
        guessNumber(rand);
    }
    static int randNumber(int max){
        Random randomNumber = new Random();
        int num = 0;
        num = randomNumber.nextInt(max-1)+1;
        System.out.println(num);

        return num;

    }
    static int guessNumber(int rand){
        System.out.println("Gues number");
        int guesNumber;
        Scanner scan = new Scanner(System.in);
        while (true) {
            guesNumber = scan.nextInt();
            System.out.println(guesNumber);
            if (guesNumber > rand) {
                System.out.println("Too big");
            } else if (guesNumber < rand) {
                System.out.println("Too small");
            } else {
                System.out.println("Got it");
                break;
            }
        }
            return guesNumber;
    }
}
