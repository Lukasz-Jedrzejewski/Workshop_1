package pl.coderslab.Game_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        yourNumbers();
    }
    static int[] yourNumbers(){
        int[] typyingNumbers = new int[6];
        System.out.println("Type six numbers from 1 to 49");
        int yourTypyingNumber = 0;
        Scanner scan = new Scanner(System.in);
            for (int i = 0; i < typyingNumbers.length; i++) {
                System.out.print("Your number: ");
//                while (!scan.hasNextInt()) {
//                    scan.next();
//                    System.out.println("This is not a number");
//                }
                yourTypyingNumber = scan.nextInt();
                typyingNumbers[i] = yourTypyingNumber;
            }
            Arrays.sort(typyingNumbers);
            System.out.println(Arrays.toString(typyingNumbers));
            return typyingNumbers;
    }

}
