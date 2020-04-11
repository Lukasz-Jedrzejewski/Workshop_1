package pl.coderslab.Game_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        result();
    }

    static List<Integer> yourNumbers() {

        List<Integer> typedNumbers = new ArrayList<Integer>(6);
        int counter = 1;
        int typed = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter six numbers in range 1-49");
        while (counter < 7) {
            System.out.print("Enter number " + counter + ": ");
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.print("This is not a number" + "\n" + "Enter number " + counter + ": ");
            }
            typed = scan.nextInt();
            if (typed < 1 || typed > 49) {
                System.out.println("Number is out of range");
            } else if (typedNumbers.contains(typed)) {
                System.out.println("This number has already been entered");
            } else {
                typedNumbers.add(typed);
                counter++;
            }
        }
        Collections.sort(typedNumbers);
        System.out.println("Your six numbers: \n" + typedNumbers);
        return typedNumbers;
    }

    static List<Integer> draw() {
        Random numbers = new Random();
        Set<Integer> dn = new HashSet<>();
        while (dn.size() < 6) {
            dn.add(numbers.nextInt(49) + 1);
        }
        List<Integer> drawNumbers = new ArrayList<Integer>(dn);
        Collections.sort(drawNumbers);
        System.out.println("Draw results: \n" + drawNumbers);
        return drawNumbers;
    }

    static void result() {
        List typed = yourNumbers();
        List draw = draw();
        draw.retainAll(typed);
        int counter = draw.size();
        if (counter >= 3)
            System.out.println("You win!" + "\nYou hit " + counter + "!");
        else
            System.out.println("You won nothing \nYou hit " + counter);
    }

}


















