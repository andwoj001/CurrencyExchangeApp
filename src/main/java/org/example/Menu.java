package org.example;
// skroty klawiaturowe:
// Ctrl+Shift+NumPad - / Ctrl+Shift+NumPad + -> zwijanie / rozwijanie metod
// Shift+F10 -> Run metody Main
// Ctrl+/ -> zakomentowanie zaznaczonego obszaru

//todo: login i haslo maja byc jeden po drugim a nie rownolegle <- done
//todo: po zdeponowaniu kwoty jakiejs waluty balance powinien sie powiekszac, zrobmy balance w pliku tekstowym i edytujmy go za kazdym depozytem

import java.util.Scanner;

public class Menu {
    static int clientNumber = 0;
    static char clientPassword = '0';
    static Scanner scan = new Scanner(System.in);

    public static void mainMenu() {
        int selection;
        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("*** Currency Exchange ***");
            System.out.println("1. Login");
            System.out.println("0. Exit");

            selection = scan.nextInt();

            switch (selection) {
                case 1:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    clientNumberLoginMenu();
                    break;
                case 0:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You selected Exit, Goodbye");
                    System.exit(0);
                    break;
            }
        } while (selection != 1 && selection != 2);
    }

    public static void clientNumberLoginMenu() {
        int selection;

        do {
            //and password to activate client panel
            //System.out.println("2. Enter your password");
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println(">> Enter your client number and password to activate client panel <<" + "\n");
            System.out.println("1. Enter your client number");
            System.out.println("0. Cancel to previous menu");

            selection = scan.nextInt();

            switch (selection) {
                case 1:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter your 6-digit client number: ");
                    clientNumber = scan.nextInt();
                    clientPasswordLoginMenu();
                    break;
//                case 2:
//                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//                    System.out.println("Enter your password: ");
//                    clientPassword = scan.next().charAt(0);
//                    loginMenu();
//                    break;
                case 0:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    mainMenu();
                    break;
            }
        } while (selection != 0 && selection != 1);
    }

    public static void clientPasswordLoginMenu() {
        int selection;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("1. Enter your client password");
            System.out.println("0. Cancel to previous menu");

            selection = scan.nextInt();

            switch (selection) {
                case 1:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter your client password: ");
                    clientPassword = scan.next().charAt(0);
                    if (clientNumber == 123456 && "ABC123".contains(String.valueOf(clientPassword))) {
                        afterLoginMenu();
                    }
                    break;
                case 0:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    mainMenu();
                    break;
            }
        } while (selection != 0 && selection != 1);
    }

    public static void afterLoginMenu() {

        int selection;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("*** Client panel ***");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check account balance");
            System.out.println("4. Check account balance history");
            System.out.println("5. Currency exchange");
            System.out.println("0. Cancel to previous menu");

            selection = scan.nextInt();

            switch (selection) {
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
                    checkAccountBalanceHistoryMenu();
                    break;
                case 5:
                    currencyToBeExchangeMenu();
                    break;
                case 0:
                    clientNumber = 0;
                    clientPassword = '0';
                    mainMenu();
                    break;
            }
        } while (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);
    }

    public static void depositMenu() {

        int selectedCurrencyToDeposit;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Select currency to deposit:");
            printCurrencySelectionMenu();
            System.out.println("0. Cancel to previous menu");

            selectedCurrencyToDeposit = scan.nextInt();

            switch (selectedCurrencyToDeposit) {
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
                case 5:
                    amountMenu();
                    break;
                case 6:
                    amountMenu();
                    break;
                case 0:
                    afterLoginMenu();
                    break;
            }
        } while (selectedCurrencyToDeposit != 0 && selectedCurrencyToDeposit != 1 && selectedCurrencyToDeposit != 2 && selectedCurrencyToDeposit != 3 && selectedCurrencyToDeposit != 4 && selectedCurrencyToDeposit != 5 && selectedCurrencyToDeposit != 6);
    }

    public static void checkAccountBalanceHistoryMenu() {
        int selection;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Select currency to check its balance history:");
            printCurrencySelectionMenu();
            System.out.println("0. Cancel to previous menu");

            selection = scan.nextInt();

            switch (selection) {
                case 1:
                    balanceHistoryMenu();
                    break;
                case 2:
                    balanceHistoryMenu();
                    break;
                case 3:
                    balanceHistoryMenu();
                    break;
                case 4:
                    balanceHistoryMenu();
                    break;
                case 5:
                    balanceHistoryMenu();
                    break;
                case 6:
                    balanceHistoryMenu();
                    break;
                case 0:
                    afterLoginMenu();
                    break;
            }
        } while (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6);
    }

    public static void withdrawalMenu() {

        int selectedCurrencyToWithdrawal;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Select currency to withdrawal:");
            printCurrencySelectionMenu();
            System.out.println("0. Cancel to previous menu");

            selectedCurrencyToWithdrawal = scan.nextInt();

            switch (selectedCurrencyToWithdrawal) {
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
                case 5:
                    amountMenu();
                    break;
                case 6:
                    amountMenu();
                    break;
                case 0:
                    afterLoginMenu();
                    break;
            }
        } while (selectedCurrencyToWithdrawal != 0 && selectedCurrencyToWithdrawal != 1 && selectedCurrencyToWithdrawal != 2 && selectedCurrencyToWithdrawal != 3 && selectedCurrencyToWithdrawal != 4 && selectedCurrencyToWithdrawal != 5 && selectedCurrencyToWithdrawal != 6);
    }

    public static void checkAccountBalanceMenu() {

        int selection;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your account balance:");
            System.out.println("150 000 	PLN");
            System.out.println("	 50		USD");
            System.out.println("  1 000 	EUR");
            System.out.println("      0 	CZK");
            System.out.println(" 24 000 	NOK");
            System.out.println(" 50 000 	DKK");
            System.out.println("0. Cancel to previous menu");

            selection = scan.nextInt();

            if (selection == 0) {
                afterLoginMenu();
            }
        } while (selection != 0);
    }

    public static void currencyToBeExchangeMenu() {

        int selectedCurrencyToBeExchange;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Select currency to be exchange:");
            printCurrencySelectionMenu();
            System.out.println("0. Cancel to previous menu");

            selectedCurrencyToBeExchange = scan.nextInt();

            switch (selectedCurrencyToBeExchange) {
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
                case 5:
                    amountToBeExchangeMenu();
                    break;
                case 6:
                    amountToBeExchangeMenu();
                    break;
                case 0:
                    afterLoginMenu();
                    break;
            }
        } while (selectedCurrencyToBeExchange != 0 && selectedCurrencyToBeExchange != 1 && selectedCurrencyToBeExchange != 2 && selectedCurrencyToBeExchange != 3 && selectedCurrencyToBeExchange != 4 && selectedCurrencyToBeExchange != 5 && selectedCurrencyToBeExchange != 6);
    }

    public static void currencyToBeExchangedForMenu() {

        int selectedCurrencyToBeExchangedFor;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Select currency to be exchanged for:");
            printCurrencySelectionMenu();
            System.out.println("0. Cancel to previous menu");

            selectedCurrencyToBeExchangedFor = scan.nextInt();

            switch (selectedCurrencyToBeExchangedFor) {

                case 1:
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 2:
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 3:
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 4:
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 5:
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 6:
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 0:
                    currencyToBeExchangeMenu();
                    break;
            }
        } while (selectedCurrencyToBeExchangedFor != 0 && selectedCurrencyToBeExchangedFor != 1 && selectedCurrencyToBeExchangedFor != 2 && selectedCurrencyToBeExchangedFor != 3 && selectedCurrencyToBeExchangedFor != 4 && selectedCurrencyToBeExchangedFor != 5 && selectedCurrencyToBeExchangedFor != 6);
    }

    public static void amountMenu() {

        int amount;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Enter amount: ");
            amount = scan.nextInt();
        } while (amount < 0);

        int scanner;
        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("The operation has been completed successfully. The account balance has been updated");
            System.out.println("0. Exit to client panel");
            scanner = scan.nextInt();
        } while (scanner != 0);

        afterLoginMenu();
    }

    public static void amountToBeExchangeMenu() {

        int amount;

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Enter amount: ");

            amount = scan.nextInt();
        } while (amount < 0);
        currencyToBeExchangedForMenu();
    }

    public static void theCurrencyHasBeenExchangeMenu() {
        int scanner;
        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("The currency has been exchanged");
            System.out.println("0. Exit to client panel");
            scanner = scan.nextInt();
        } while (scanner != 0);
        afterLoginMenu();
    }

    private static void balanceHistoryMenu() {
        int scanner;
        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("History of transactions (last 3):");
            System.out.println("18-10-2022 +200 PLN; balance after operation: 10 500 PLN");
            System.out.println("16-10-2022 +100 PLN; balance after operation: 10 300 PLN");
            System.out.println("10-10-2022 +100 PLN; balance after operation: 10 200 PLN");
            System.out.println("0. Exit to client panel");
            scanner = scan.nextInt();
        } while (scanner != 0);
        afterLoginMenu();
    }

    public static void printCurrencySelectionMenu() {
            System.out.println("1. PLN");
            System.out.println("2. USD");
            System.out.println("3. EUR");
            System.out.println("4. CZK");
            System.out.println("5. NOK");
            System.out.println("6. DKK");
    }
}