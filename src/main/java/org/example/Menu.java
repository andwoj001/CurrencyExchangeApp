package org.example;

import java.util.Scanner;

public class Menu{
    static int clientNumber = 0;
    static char clientPassword = '0';

    public static void mainMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("*** Currency Exchange ***");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        switch(selection) {
            case 1:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                loginMenu();

                break;

            case 2:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("You selected Exit, Goodbye");
                System.exit(0);
                break;

            default:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("You should select 1 or 2 button on keypad");
                break;
        }

    }

    public static void loginMenu() {
        if (clientNumber == 123456 && "ABC123".contains(String.valueOf(clientPassword))) {
            afterLoginMenu();
        }

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("1. Enter your client number");
        System.out.println("2. Enter your password");
        System.out.println("3. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        switch (selection) {
            case 1:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Enter your 6-digit client number: " + "\n");
                Scanner scan1 = new Scanner(System.in);
                clientNumber = scan1.nextInt();
                loginMenu();
                break;
            case 2:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Enter your password: " + "\n");
                Scanner scan2 = new Scanner(System.in);
                clientPassword = scan2.next().charAt(0);
                loginMenu();
                break;
            case 3:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                mainMenu();

                break;

            default:

                break;
        }
    }

    public static void afterLoginMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("*** Client panel ***");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Check account balance");
        System.out.println("4. Currency exchange");
        System.out.println("5. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        switch(selection) {
            case 1:
                System.out.println("You selected 1");

                break;

            case 2:
                System.out.println("You selected 2");

                break;

            case 3:
                System.out.println("You selected 3");

                break;

            case 4:
                System.out.println("You selected 4");

                break;

            case 5:
                clientNumber = 0;
                clientPassword = '0';
                loginMenu();

                break;

            default:
                System.out.println("You should select 1, 2, 3 or 4 button on keypad");
                break;
        }
    }
}