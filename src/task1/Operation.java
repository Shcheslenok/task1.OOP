package task1;

import java.util.Scanner;

public class Operation {
    public static Scanner input = new Scanner(System.in);

    public static int inputNumber(){

        int number;
        input = new Scanner(System.in);
        number = input.nextInt();
        return number;
    }

    public static String inputString(){

        String str;
        input = new Scanner(System.in);
        str = input.next();
        return str;
    }

    public static void menu() {

        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Select an action...");
            System.out.println("1)Add ");
            System.out.println("2)Client");
            System.out.println("0)Exit");
            System.out.println("---------------------------------------------");

            switch (Operation.inputNumber()){

                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 0: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Work completed");
                    System.out.println("---------------------------------------------");
                    System.exit(0);
                }
                default: {
                    System.out.println("---------------------------------------------");
                    System.out.println("Impossible choice or format. Repeat please ...");
                }
            }
        }
    }

}
