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
        System.out.println("0. Cancel to previous menu");

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
            case 0:
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
        System.out.println("0. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        switch(selection) {
            case 1:
                depositMenu();
                break;
            case 2:
                withdrawalMenu();
                break;
            case 3:
                checkAccountBalanceMenu();
                break;
            case 4:
                currencyToBeExchangeMenu();
                break;
            case 0:
                clientNumber = 0;
                clientPassword = '0';
                loginMenu();
                break;
            default:
                System.out.println("You should select 0 - 4 button on keypad");
                break;
        }
    }

    public static void depositMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Select currency to deposit:");
        System.out.println("1. PLN");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. CZK");
        System.out.println("5. NOK");
        System.out.println("6. DKK");
        System.out.println("0. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selectedCurrencyToDeposit = scan.nextInt();

        switch(selectedCurrencyToDeposit) {
            case 1:
                amountMenu();
                break;

            case 2:
                amountMenu();
                break;

            case 3:
                amountMenu();
                break;

            case 4:
                amountMenu();
                break;

            case 0:
                afterLoginMenu();
                break;

            default:
                System.out.println("You should select 0 - 6 button on keypad");
                break;
        }

    }

    public static void withdrawalMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Select currency to withdrawal:");
        System.out.println("1. PLN");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. CZK");
        System.out.println("5. NOK");
        System.out.println("6. DKK");
        System.out.println("0. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selectedCurrencyToWithdrawal = scan.nextInt();

        switch(selectedCurrencyToWithdrawal) {
            case 1:
                amountMenu();
                break;
            case 2:
                amountMenu();
                break;
            case 3:
                amountMenu();
                break;
            case 4:
                amountMenu();
                break;
            case 0:
                afterLoginMenu();
                break;
            default:
                System.out.println("You should select 0 - 6 button on keypad");
                break;
        }
    }

    public static void checkAccountBalanceMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Your account balance:");
        System.out.println("150 000 	PLN");
        System.out.println("	 50		USD");
        System.out.println("  1 000 	EUR");
        System.out.println("      0 	CZK");
        System.out.println(" 24 000 	NOK");
        System.out.println(" 50 000 	DKK");
        System.out.println("0. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();

        if (selection == 0) {
            afterLoginMenu();
        }

    }

    public static void currencyToBeExchangeMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Select currency to be exchange:");
        System.out.println("1. PLN");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. CZK");
        System.out.println("5. NOK");
        System.out.println("6. DKK");
        System.out.println("0. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selectedCurrencyToBeExchange = scan.nextInt();

        switch(selectedCurrencyToBeExchange) {
            case 1:
                amountToBeExchangeMenu();
                break;

            case 2:
                amountToBeExchangeMenu();
                break;

            case 3:
                amountToBeExchangeMenu();
                break;

            case 4:
                amountToBeExchangeMenu();
                break;

            case 0:
                afterLoginMenu();
                break;

            default:
                System.out.println("You should select 0 - 6 button on keypad");
                break;
        }

    }

    public static void currencyToBeExchangedForMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Select currency to be exchanged for:");
        System.out.println("1. PLN");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. CZK");
        System.out.println("5. NOK");
        System.out.println("6. DKK");
        System.out.println("0. Cancel to previous menu");

        Scanner scan = new Scanner(System.in);
        int selectedCurrencyToBeExchangedFor = scan.nextInt();

        switch(selectedCurrencyToBeExchangedFor) {
            case 1:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("The currency has been exchanged");
                System.out.println("0. Cancel to previous menu");
                Scanner scan1 = new Scanner(System.in);
                int scaner1 = scan1.nextInt();
                if (scaner1 == 0) {
                    afterLoginMenu();
                }
                break;
            case 2:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("The currency has been exchanged");
                System.out.println("0. Cancel to previous menu");
                Scanner scan2 = new Scanner(System.in);
                int scaner2 = scan2.nextInt();
                if (scaner2 == 0) {
                    afterLoginMenu();
                }
                break;
            case 3:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("The currency has been exchanged");
                System.out.println("0. Cancel to previous menu");
                Scanner scan3 = new Scanner(System.in);
                int scaner3 = scan3.nextInt();
                if (scaner3 == 0) {
                    afterLoginMenu();
                }
                break;
            case 4:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("The currency has been exchanged");
                System.out.println("0. Cancel to previous menu");
                Scanner scan4 = new Scanner(System.in);
                int scaner4 = scan4.nextInt();
                if (scaner4 == 0) {
                    afterLoginMenu();
                }
                break;

            case 5:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("The currency has been exchanged");
                System.out.println("0. Cancel to previous menu");
                Scanner scan5 = new Scanner(System.in);
                int scaner5 = scan5.nextInt();
                if (scaner5 == 0) {
                    afterLoginMenu();
                }
                break;
            case 6:
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("The currency has been exchanged");
                System.out.println("0. Cancel to previous menu");
                Scanner scan6 = new Scanner(System.in);
                int scaner6 = scan6.nextInt();
                if (scaner6 == 0) {
                    afterLoginMenu();
                }
                break;
            case 0:
                afterLoginMenu();
                break;
            default:
                System.out.println("You should select 0 - 6 button on keypad");
                break;
        }
    }

    public static void amountMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Enter amount: " + "\n");

        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();

        afterLoginMenu();
    }

    public static void amountToBeExchangeMenu(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Enter amount: " + "\n");

        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();

        currencyToBeExchangedForMenu();
    }
}