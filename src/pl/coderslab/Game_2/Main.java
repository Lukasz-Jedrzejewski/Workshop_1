package pl.coderslab.Game_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        yourNumbers();
    }

    static List<Integer> yourNumbers() {

        List<Integer> typedNumbers = new ArrayList<Integer>(6);
        int counter = 1;
        int typed = 0;
        Scanner scan = new Scanner(System.in);
        while (counter < 7) {
            System.out.print("Enter number " + counter + ": ");
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.print("This is not a number" + "\n" + "enter number " + counter + ": ");
            }
            typed = scan.nextInt();
            if (typed < 1 || typed > 49) {
                System.out.println("Number is out of range");
            } else if(typedNumbers.contains(typed)) {
                System.out.println("Number already exist");
            } else {
                typedNumbers.add(typed);
                counter++;
            }
        }
        Collections.sort(typedNumbers);
        System.out.println(typedNumbers);
        return typedNumbers;
    }



}

















