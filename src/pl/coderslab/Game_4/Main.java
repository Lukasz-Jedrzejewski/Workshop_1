package pl.coderslab.Game_4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is exemplary code: \n2D3+2 \nwhere first number in row is number of throws " +
                "\nD+number is a symbol to define dice type \noperator and last number defines modifer");
        System.out.println();
        while (true) {
            System.out.println(diceRolling(userInput()));
        }

    }
    static int[] userInput() {
        Scanner in = new Scanner(System.in);
        String input;
        String[] arr = {"", "", "", "", ""};
        int counter = 0;
        int[] var = {1, 0, 0};
        System.out.println("Enter code");
        input = in.nextLine();
        while (!input.matches("\\d+[D,d](3|4|6|8|10|12|20|100)[+,-]\\d+") &&
                !input.matches("[D,d](3|4|6|8|10|12|20|100)[+,-]\\d+") &&
                !input.matches("[D,d](3|4|6|8|10|12|20|100)") &&
                !input.matches("\\d+[D,d](3|4|6|8|10|12|20|100)")) {
            System.out.println("Wrong format");
            System.out.println("Enter code");
            input = in.nextLine();
        }
        for (int i = 0; i < input.length(); i++) {
            while (Character.isDigit(input.charAt(i))) {
                arr[counter] += input.charAt(i);
                if (i == input.length() - 1)
                    break;
                i++;
            }
            counter++;
            if (input.charAt(i) == 'D' || input.charAt(i) == 'd') {
                arr[counter] += input.charAt(i);
                counter++;
            } else if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                arr[counter] += input.charAt(i);
                counter++;
            }
        }
        if (!arr[0].isEmpty())
            var[0] = Integer.parseInt(arr[0]);
        var[1] = Integer.parseInt(arr[2]);
        if (!arr[4].isEmpty()) {
            if (arr[3].equals("-"))
                var[2] = -Integer.parseInt(arr[4]);
            else
                var[2] = Integer.parseInt(arr[4]);
        }
        return var;
    }

    static int diceRolling(int[] var) {
        int x = var[0];
        int y = var[1];
        int z = var[2];
        int resultR = 0;
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            resultR += random.nextInt(y) + 1;
        }
        System.out.print("Final score: ");
        return resultR + z;
    }
}