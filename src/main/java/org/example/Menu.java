package org.example;

import java.util.Scanner;

public class Menu{

    public static void mainMenu(){

        System.out.println("*** Currency Exchange ***" + "\n");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        switch(selection) {
            case 1:
                loginMenu();

                break;

            case 2:
                System.out.println("You selected Exit, Goodbye");

                break;

            default:
                System.out.println("You should select 1 or 2 button on keypad");
                break;
        }

    }

    public static void loginMenu(){

        System.out.println("Enter your 6-digit client number: " + "\n");
        Scanner scan1 = new Scanner(System.in);
        int clientNumber = scan1.nextInt();

        System.out.println("Enter your password: " + "\n");
        Scanner scan2 = new Scanner(System.in);
        char clientPassword = scan2.next().charAt(0);

        boolean validation;

        if (clientNumber == 123456 && "ABC123".contains(String.valueOf(clientPassword))){
            validation = true;
            afterLoginMenu();
        }
    }


    public static void afterLoginMenu(){
        System.out.println("*** Client panel ***" + "\n");
        System.out.println("1. Deposit" + "\n");
        System.out.println("2. Withdrawal" + "\n");
        System.out.println("3. Check account balance" + "\n");
        System.out.println("4. Currency exchange" + "\n");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        switch(selection) {
            case 1:
                loginMenu();

                break;

            case 2:
                System.out.println("You selected Exit, Goodbye");

                break;

            case 3:
                System.out.println("You selected Exit, Goodbye");

                break;

            case 4:
                System.out.println("You selected Exit, Goodbye");

                break;

            default:
                System.out.println("You should select 1 or 2 button on keypad");
                break;
        }

    }



}