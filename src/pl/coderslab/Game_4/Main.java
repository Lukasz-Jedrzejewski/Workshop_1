package pl.coderslab.Game_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println(diceRolling(userInput()));
        }

    }
    private static int[] userInput() {
        Scanner in = new Scanner(System.in);
        String input;
        String[] inputData = {"", "", "", "", ""};
        int counter = 0;
        int[] resultData = {1, 0, 0};
        System.out.println("Enter code");
        input = in.nextLine();
        if (input.matches("\\d+[D,d](3|4|6|8|10|12|20|100)[+,-]\\d+")
                || input.matches("[D,d](3|4|6|8|10|12|20|100)[+,-]\\d+")
                || input.matches("[D,d](3|4|6|8|10|12|20|100)")
                || input.matches("\\d+[D,d](3|4|6|8|10|12|20|100)")) {
            for (int i = 0; i < input.length(); i++) {
                while (Character.isDigit(input.charAt(i))) {
                    inputData[counter] += input.charAt(i);
                    if (i == input.length() - 1)
                        break;
                    i++;
                }
                counter++;
                if (input.charAt(i) == 'D' || input.charAt(i) == 'd') {
                    inputData[counter] += input.charAt(i);
                    counter++;
                } else if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                    inputData[counter] += input.charAt(i);
                    counter++;
                }
            }
            if(!inputData[0].isEmpty())
                resultData[0] = Integer.parseInt(inputData[0]);
            resultData[1] = Integer.parseInt(inputData[2]);
            if(!inputData[4].isEmpty()){
                if(inputData[3].equals("-"))
                    resultData[2] = -Integer.parseInt(inputData[4]);
                else
                    resultData[2] = Integer.parseInt(inputData[4]);
            }
        } else {
                System.out.println("Wrong format");
                userInput();
        }
        System.out.println(Arrays.toString(resultData));
        System.out.println("ok");
        return resultData;
    }

    private static int diceRolling(int[] var) {
        int throwsNumber = var[0];
        int diceType = var[1];
        int modifer = var[2];
        int throwsResult = 0;
        Random random = new Random();
        for (int i = 0; i < throwsNumber ; i++) {
            throwsResult += random.nextInt(diceType)+1;
        }
        if(modifer < 0 && throwsResult+modifer <= 0){
            System.out.println("Negative modifier too large");
            userInput();
        }
        return throwsResult+modifer;
    }
}