package org.example;
// skroty klawiaturowe:
// Ctrl+Shift+NumPad - / Ctrl+Shift+NumPad + -> zwijanie / rozwijanie metod
// Shift+F10 -> Run metody Main
// Ctrl+/ -> zakomentowanie zaznaczonego obszaru


//todo: jesli wystapi wyjatek wypisac tekst o co chodzi z wyjatkiem i wyswietlic go na kilka sekund w kosnsoli

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Menu {

    // mogę działać na polach dopiero gdy jestem w metodzie ;)

    //postgreSQL

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    static Stack<String> stackHistoryPLN = new Stack<>();
    static Stack<String> stackHistoryUSD = new Stack<>();
    static Stack<String> stackHistoryEUR = new Stack<>();
    static Stack<String> stackHistoryCZK = new Stack<>();
    static Stack<String> stackHistoryDKK = new Stack<>();
    static Stack<String> stackHistoryNOK = new Stack<>();

    static int clientNumber = 0;
    static String clientPassword = "0";
    static Scanner scan = new Scanner(System.in);
    static String currencySelectedToCalculation_Deposit;
    static String currencySelectedToCalculation_Withdrawal;

    static double amount;

    static String currencyToBeExchange;
    static String currencyToBeExchangeFor;
    static double amountOfCurrencyToBeExchange;

    static String currencyToCheckItsBalanceHistory;

    static User user1;

    public static void mainMenu() {

        int selection = 001;
        User.isLoggedIn = false;
        do {
            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("*** Currency Exchange ***");
                    System.out.println("1. Login");
                    System.out.println("0. Exit");

                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

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
        int selection = 001;

        do {
            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println(">> Enter your client number and password to activate client panel <<" + "\n");
                    System.out.println("1. Enter your client number");
                    System.out.println("0. Cancel to previous menu");
                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selection) {
                case 1:
                    boolean isCatch2;
                    do {
                        try {
                            isCatch2 = false;
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Enter your 6-digit client number: ");
                            clientNumber = scan.nextInt();
                        } catch (InputMismatchException e) {
                            isCatch2 = true;
                            scan.nextLine();
                        }
                    } while (isCatch2 == true);
                    clientPasswordLoginMenu();
                    break;
                case 0:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    mainMenu();
                    break;
            }
        } while (selection != 0 && selection != 1);
    }

    public static void clientPasswordLoginMenu() {
        int selection = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("1. Enter your client password");
                    System.out.println("0. Cancel to previous menu");

                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selection) {
                case 1:
                    boolean isCatch2;
                    do {
                        try {
                            isCatch2 = false;
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Enter your client password: ");
                            clientPassword = scan.next();
                        } catch (InputMismatchException e) {
                            isCatch2 = true;
                            scan.nextLine();
                        }
                    } while (isCatch2 == true);

                    if (clientNumber == 111222 && "Admin123".equals(clientPassword)) {
                        UserAdmin.displayAdminPanelMenu();
                    } else if (User.isUserNumberAndUserPasswordCorrectSetLogIn(clientNumber, clientPassword)){
                        clientPanelMenu();
                }
                    break;
                case 0:
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    mainMenu();
                    break;
            }
        } while (selection != 0 && selection != 1);
    }

    public static void clientPanelMenu() {

        int selection = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("*** Client panel ***");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdrawal");
                    System.out.println("3. Check account balance");
                    System.out.println("4. Check account balance history");
                    System.out.println("5. Currency exchange");
                    System.out.println("0. Cancel to previous menu");

                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

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
                    clientPassword = "0";
                    mainMenu();
                    break;
            }
        } while (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);
    }

    public static void depositMenu() {

        int selectedCurrencyToDeposit = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Select currency to deposit:");
                    printCurrencySelectionMenu();
                    System.out.println("0. Cancel to previous menu");

                    selectedCurrencyToDeposit = scan.nextInt();

                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selectedCurrencyToDeposit) {
                case 1:
                    currencySelectedToCalculation_Deposit = "PLN";
                    amountMenu(true, false);
                    break;
                case 2:
                    currencySelectedToCalculation_Deposit = "USD";
                    amountMenu(true, false);
                    break;
                case 3:
                    currencySelectedToCalculation_Deposit = "EUR";
                    amountMenu(true, false);
                    break;
                case 4:
                    currencySelectedToCalculation_Deposit = "CZK";
                    amountMenu(true, false);
                    break;
                case 5:
                    currencySelectedToCalculation_Deposit = "NOK";
                    amountMenu(true, false);
                    break;
                case 6:
                    currencySelectedToCalculation_Deposit = "DKK";
                    amountMenu(true, false);
                    break;
                case 0:
                    clientPanelMenu();
                    break;
            }
        } while (selectedCurrencyToDeposit != 0 && selectedCurrencyToDeposit != 1 && selectedCurrencyToDeposit != 2 && selectedCurrencyToDeposit != 3 && selectedCurrencyToDeposit != 4 && selectedCurrencyToDeposit != 5 && selectedCurrencyToDeposit != 6);
    }

    public static void checkAccountBalanceHistoryMenu() {
        int selection = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Select currency to check its balance history:");
                    printCurrencySelectionMenu();
                    System.out.println("0. Cancel to previous menu");

                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selection) {
                case 1:
                    currencyToCheckItsBalanceHistory = "PLN";
                    balanceHistoryMenu("PLN");
                    break;
                case 2:
                    currencyToCheckItsBalanceHistory = "USD";
                    balanceHistoryMenu("USD");
                    break;
                case 3:
                    currencyToCheckItsBalanceHistory = "EUR";
                    balanceHistoryMenu("EUR");
                    break;
                case 4:
                    currencyToCheckItsBalanceHistory = "CZK";
                    balanceHistoryMenu("CZK");
                    break;
                case 5:
                    currencyToCheckItsBalanceHistory = "NOK";
                    balanceHistoryMenu("NOK");
                    break;
                case 6:
                    currencyToCheckItsBalanceHistory = "DKK";
                    balanceHistoryMenu("DKK");
                    break;
                case 0:
                    clientPanelMenu();
                    break;
            }
        } while (selection != 0 && selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6);
    }

    public static void withdrawalMenu() {

        int selectedCurrencyToWithdrawal = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Select currency to withdrawal:");
                    printCurrencySelectionMenu();
                    System.out.println("0. Cancel to previous menu");

                    selectedCurrencyToWithdrawal = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selectedCurrencyToWithdrawal) {
                case 1:
                    currencySelectedToCalculation_Withdrawal = "PLN";
                    amountMenu(false, true);
                    break;
                case 2:
                    currencySelectedToCalculation_Withdrawal = "USD";
                    amountMenu(false, true);
                    break;
                case 3:
                    currencySelectedToCalculation_Withdrawal = "EUR";
                    amountMenu(false, true);
                    break;
                case 4:
                    currencySelectedToCalculation_Withdrawal = "CZK";
                    amountMenu(false, true);
                    break;
                case 5:
                    currencySelectedToCalculation_Withdrawal = "NOK";
                    amountMenu(false, true);
                    break;
                case 6:
                    currencySelectedToCalculation_Withdrawal = "DKK";
                    amountMenu(false, true);
                    break;
                case 0:
                    clientPanelMenu();
                    break;
            }
        } while (selectedCurrencyToWithdrawal != 0 && selectedCurrencyToWithdrawal != 1 && selectedCurrencyToWithdrawal != 2 && selectedCurrencyToWithdrawal != 3 && selectedCurrencyToWithdrawal != 4 && selectedCurrencyToWithdrawal != 5 && selectedCurrencyToWithdrawal != 6);
    }

    public static void checkAccountBalanceMenu() {

        int selection = 001;

        DecimalFormat df = new DecimalFormat("####0.00");

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Your account balance:");
                    System.out.println("PLN  " + df.format(User.getLoggedInUser().PLN));
                    System.out.println("USD  " + df.format(User.getLoggedInUser().USD));
                    System.out.println("EUR  " + df.format(User.getLoggedInUser().EUR));
                    System.out.println("CZK  " + df.format(User.getLoggedInUser().CZK));
                    System.out.println("NOK  " + df.format(User.getLoggedInUser().NOK));
                    System.out.println("DKK  " + df.format(User.getLoggedInUser().DKK));
                    System.out.println("0. Cancel to previous menu");

                    selection = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            if (selection == 0) {
                clientPanelMenu();
            }
        } while (selection != 0);
    }

    public static void currencyToBeExchangeMenu() {

        int selectedCurrencyToBeExchange = 001;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Select currency to be exchange:");
                    printCurrencySelectionMenu();
                    System.out.println("0. Cancel to previous menu");

                    selectedCurrencyToBeExchange = scan.nextInt();

                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selectedCurrencyToBeExchange) {
                case 1:
                    Menu.currencyToBeExchange = "PLN";
                    amountToBeExchangeMenu();
                    break;
                case 2:
                    Menu.currencyToBeExchange = "USD";
                    amountToBeExchangeMenu();
                    break;
                case 3:
                    Menu.currencyToBeExchange = "EUR";
                    amountToBeExchangeMenu();
                    break;
                case 4:
                    Menu.currencyToBeExchange = "CZK";
                    amountToBeExchangeMenu();
                    break;
                case 5:
                    Menu.currencyToBeExchange = "NOK";
                    amountToBeExchangeMenu();
                    break;
                case 6:
                    Menu.currencyToBeExchange = "DKK";
                    amountToBeExchangeMenu();
                    break;
                case 0:
                    clientPanelMenu();
                    break;
            }
        } while (selectedCurrencyToBeExchange != 0 && selectedCurrencyToBeExchange != 1 && selectedCurrencyToBeExchange != 2 && selectedCurrencyToBeExchange != 3 && selectedCurrencyToBeExchange != 4 && selectedCurrencyToBeExchange != 5 && selectedCurrencyToBeExchange != 6);
    }

    public static void currencyToBeExchangedForMenu() {

        int selectedCurrencyToBeExchangedFor = 0;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Select currency to be exchanged for:");
                    printCurrencySelectionMenu();
                    System.out.println("0. Cancel to previous menu");

                    selectedCurrencyToBeExchangedFor = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

            switch (selectedCurrencyToBeExchangedFor) {

                case 1:
                    Menu.currencyToBeExchangeFor = "PLN";
                    currencyExchangeCalculation(currencyToBeExchange, currencyToBeExchangeFor, amountOfCurrencyToBeExchange);
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 2:
                    Menu.currencyToBeExchangeFor = "USD";
                    currencyExchangeCalculation(currencyToBeExchange, currencyToBeExchangeFor, amountOfCurrencyToBeExchange);
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 3:
                    Menu.currencyToBeExchangeFor = "EUR";
                    currencyExchangeCalculation(currencyToBeExchange, currencyToBeExchangeFor, amountOfCurrencyToBeExchange);
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 4:
                    Menu.currencyToBeExchangeFor = "CZK";
                    currencyExchangeCalculation(currencyToBeExchange, currencyToBeExchangeFor, amountOfCurrencyToBeExchange);
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 5:
                    Menu.currencyToBeExchangeFor = "NOK";
                    currencyExchangeCalculation(currencyToBeExchange, currencyToBeExchangeFor, amountOfCurrencyToBeExchange);
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 6:
                    Menu.currencyToBeExchangeFor = "DKK";
                    currencyExchangeCalculation(currencyToBeExchange, currencyToBeExchangeFor, amountOfCurrencyToBeExchange);
                    theCurrencyHasBeenExchangeMenu();
                    break;
                case 0:
                    currencyToBeExchangeMenu();
                    break;
            }
        } while (selectedCurrencyToBeExchangedFor != 0 && selectedCurrencyToBeExchangedFor != 1 && selectedCurrencyToBeExchangedFor != 2 && selectedCurrencyToBeExchangedFor != 3 && selectedCurrencyToBeExchangedFor != 4 && selectedCurrencyToBeExchangedFor != 5 && selectedCurrencyToBeExchangedFor != 6);
    }

    public static void amountMenu(boolean isDeposit, boolean isWithdrawal) {

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter amount: ");
                    amount = scan.nextDouble();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

        } while (amount < 0);

        if (isDeposit == true) {
            User.getLoggedInUser().addToUserAccountBalance(amount, currencySelectedToCalculation_Deposit);



//          user1.addToUserAccountBalance(amount, currencySelectedToCalculation_Deposit);
            balanceHistoryCalculation(currencySelectedToCalculation_Deposit, true, false, false, false, amount);
        } else if (isWithdrawal == true) {
            user1.removeFromUserAccountBalance(amount, currencySelectedToCalculation_Withdrawal);
            balanceHistoryCalculation(currencySelectedToCalculation_Withdrawal, false, true, false, false, amount);
        }

        int scanner = 001;
        do {

            boolean isCatch2;
            do {
                try {
                    isCatch2 = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("The operation has been completed successfully. The account balance has been updated");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch2 = true;
                    scan.nextLine();
                }
            } while (isCatch2 == true);

        } while (scanner != 0);

        clientPanelMenu();
    }

    public static void amountToBeExchangeMenu() {

        int amount = 0;

        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Enter amount: ");

                    amount = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

        } while (amount < 0);

        amountOfCurrencyToBeExchange = amount;

        currencyToBeExchangedForMenu();
    }

    public static void theCurrencyHasBeenExchangeMenu() {
        int scanner = 001;
        do {

            boolean isCatch;
            do {
                try {
                    isCatch = false;
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("The currency has been exchanged");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

        } while (scanner != 0);
        clientPanelMenu();
    }

    private static void balanceHistoryMenu(String currency) {
        int scanner = 001;

        do {
            boolean isCatch;
            do {
                try {
                    isCatch = false;

                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("History of transactions (last 3):");
                    if ("PLN".equals(currency)) {
                        if (stackHistoryPLN.size() > 0) {
                            System.out.println(stackHistoryPLN.get(stackHistoryPLN.size() - 1));
                            if (stackHistoryPLN.size() > 1) {
                                System.out.println(stackHistoryPLN.get(stackHistoryPLN.size() - 2));
                                if (stackHistoryPLN.size() > 2) {
                                    System.out.println(stackHistoryPLN.get(stackHistoryPLN.size() - 3));
                                }
                            }
                        }
                    } else if ("USD".equals(currency)) {
                        if (stackHistoryUSD.size() > 0) {
                            System.out.println(stackHistoryUSD.get(stackHistoryUSD.size() - 1));
                            if (stackHistoryUSD.size() > 1) {
                                System.out.println(stackHistoryPLN.get(stackHistoryUSD.size() - 2));
                                if (stackHistoryUSD.size() > 2) {
                                    System.out.println(stackHistoryUSD.get(stackHistoryUSD.size() - 3));
                                }
                            }
                        }
                    } else if ("EUR".equals(currency)) {
                        if (stackHistoryEUR.size() > 0) {
                            System.out.println(stackHistoryEUR.get(stackHistoryEUR.size() - 1));
                            if (stackHistoryEUR.size() > 1) {
                                System.out.println(stackHistoryEUR.get(stackHistoryEUR.size() - 2));
                                if (stackHistoryEUR.size() > 2) {
                                    System.out.println(stackHistoryEUR.get(stackHistoryEUR.size() - 3));
                                }
                            }
                        }
                    } else if ("CZK".equals(currency)) {
                        if (stackHistoryCZK.size() > 0) {
                            System.out.println(stackHistoryCZK.get(stackHistoryCZK.size() - 1));
                            if (stackHistoryCZK.size() > 1) {
                                System.out.println(stackHistoryCZK.get(stackHistoryCZK.size() - 2));
                                if (stackHistoryCZK.size() > 2) {
                                    System.out.println(stackHistoryCZK.get(stackHistoryCZK.size() - 3));
                                }
                            }
                        }
                    } else if ("DKK".equals(currency)) {
                        if (stackHistoryDKK.size() > 0) {
                            System.out.println(stackHistoryDKK.get(stackHistoryDKK.size() - 1));
                            if (stackHistoryDKK.size() > 1) {
                                System.out.println(stackHistoryDKK.get(stackHistoryDKK.size() - 2));
                                if (stackHistoryDKK.size() > 2) {
                                    System.out.println(stackHistoryDKK.get(stackHistoryDKK.size() - 3));
                                }
                            }
                        }
                    } else if ("NOK".equals(currency)) {
                        if (stackHistoryNOK.size() > 0) {
                            System.out.println(stackHistoryNOK.get(stackHistoryNOK.size() - 1));
                            if (stackHistoryNOK.size() > 1) {
                                System.out.println(stackHistoryNOK.get(stackHistoryNOK.size() - 2));
                                if (stackHistoryNOK.size() > 2) {
                                    System.out.println(stackHistoryNOK.get(stackHistoryNOK.size() - 3));
                                }
                            }
                        }
                    }
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();


                } catch (InputMismatchException e) {
                    isCatch = true;
                    scan.nextLine();
                }
            } while (isCatch == true);

        } while (scanner != 0);
        clientPanelMenu();
    }

    public static void printCurrencySelectionMenu() {
        System.out.println("1. PLN");
        System.out.println("2. USD");
        System.out.println("3. EUR");
        System.out.println("4. CZK");
        System.out.println("5. NOK");
        System.out.println("6. DKK");
    }

    public static void currencyExchangeCalculation(String currencyToBeExchange, String currencyToBeExchangeFor, double amountOfCurrencyToBeExchange) {
        double PLNtoUSD = 0.21;
        double PLNtoEUR = 0.21;
        double PLNtoCZK = 5.20;
        double PLNtoNOK = 2.17;
        double PLNtoDKK = 1.58;
        double USDtoPLN = 4.73;
        double USDtoEUR = 1.00;
        double USDtoCZK = 24.59;
        double USDtoNOK = 10.31;
        double USDtoDKK = 7.47;
        double EURtoPLN = 4.72;
        double EURtoUSD = 1.00;
        double EURtoCZK = 24.51;
        double EURtoNOK = 10.26;
        double EURtoDKK = 7.44;
        double CZKtoPLN = 0.19;
        double CZKtoUSD = 0.041;
        double CZKtoEUR = 0.041;
        double CZKtoNOK = 0.42;
        double CZKtoDKK = 0.30;
        double NOKtoPLN = 0.45;
        double NOKtoUSD = 0.096;
        double NOKtoEUR = 0.097;
        double NOKtoCZK = 2.36;
        double NOKtoDKK = 0.72;
        double DKKtoPLN = 0.63;
        double DKKtoUSD = 0.13;
        double DKKtoEUR = 0.13;
        double DKKtoCZK = 3.29;
        double DKKtoNOK = 1.38;

        int scanner;

        if ("PLN".equals(currencyToBeExchange) && "USD".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.PLN) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.PLN = user1.PLN - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("PLN", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.USD = user1.USD + (amountOfCurrencyToBeExchange * PLNtoUSD);
            balanceHistoryCalculation("USD", false, false, true, false, amountOfCurrencyToBeExchange * PLNtoUSD);
        } else if ("PLN".equals(currencyToBeExchange) && "EUR".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.PLN) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.PLN = user1.PLN - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("PLN", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.EUR = user1.EUR + (amountOfCurrencyToBeExchange * PLNtoEUR);
            balanceHistoryCalculation("EUR", false, false, true, false, amountOfCurrencyToBeExchange * PLNtoEUR);
        } else if ("PLN".equals(currencyToBeExchange) && "CZK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.PLN) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.PLN = user1.PLN - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("PLN", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.CZK = user1.CZK + (amountOfCurrencyToBeExchange * PLNtoCZK);
            balanceHistoryCalculation("CZK", false, false, true, false, amountOfCurrencyToBeExchange * PLNtoCZK);
        } else if ("PLN".equals(currencyToBeExchange) && "NOK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.PLN) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.PLN = user1.PLN - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("PLN", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.NOK = user1.NOK + (amountOfCurrencyToBeExchange * PLNtoNOK);
            balanceHistoryCalculation("NOK", false, false, true, false, amountOfCurrencyToBeExchange * PLNtoNOK);
        } else if ("PLN".equals(currencyToBeExchange) && "DKK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.PLN) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.PLN = user1.PLN - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("PLN", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.DKK = user1.DKK + (amountOfCurrencyToBeExchange * PLNtoDKK);
            balanceHistoryCalculation("DKK", false, false, true, false, amountOfCurrencyToBeExchange * PLNtoDKK);
        } else if ("USD".equals(currencyToBeExchange) && "PLN".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.USD) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.USD = user1.USD - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("USD", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.PLN = user1.PLN + (amountOfCurrencyToBeExchange * USDtoPLN);
            balanceHistoryCalculation("PLN", false, false, true, false, amountOfCurrencyToBeExchange * USDtoPLN);
        } else if ("USD".equals(currencyToBeExchange) && "EUR".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.USD) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.USD = user1.USD - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("USD", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.EUR = user1.EUR + (amountOfCurrencyToBeExchange * USDtoEUR);
            balanceHistoryCalculation("EUR", false, false, true, false, amountOfCurrencyToBeExchange * USDtoEUR);
        } else if ("USD".equals(currencyToBeExchange) && "CZK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.USD) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.USD = user1.USD - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("USD", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.CZK = user1.CZK + (amountOfCurrencyToBeExchange * USDtoCZK);
            balanceHistoryCalculation("CZK", false, false, true, false, amountOfCurrencyToBeExchange * USDtoCZK);
        } else if ("USD".equals(currencyToBeExchange) && "NOK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.USD) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.USD = user1.USD - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("USD", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.NOK = user1.NOK + (amountOfCurrencyToBeExchange * USDtoNOK);
            balanceHistoryCalculation("NOK", false, false, true, false, amountOfCurrencyToBeExchange * USDtoNOK);
        } else if ("USD".equals(currencyToBeExchange) && "DKK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.USD) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.USD = user1.USD - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("USD", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.DKK = user1.DKK + (amountOfCurrencyToBeExchange * USDtoDKK);
            balanceHistoryCalculation("DKK", false, false, true, false, amountOfCurrencyToBeExchange * USDtoDKK);
        } else if ("EUR".equals(currencyToBeExchange) && "PLN".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.EUR) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.EUR = user1.EUR - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("EUR", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.PLN = user1.PLN + (amountOfCurrencyToBeExchange * EURtoPLN);
            balanceHistoryCalculation("PLN", false, false, true, false, amountOfCurrencyToBeExchange * EURtoPLN);
        } else if ("EUR".equals(currencyToBeExchange) && "USD".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.EUR) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.EUR = user1.EUR - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("EUR", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.USD = user1.USD + (amountOfCurrencyToBeExchange * EURtoUSD);
            balanceHistoryCalculation("USD", false, false, true, false, amountOfCurrencyToBeExchange * EURtoUSD);
        } else if ("EUR".equals(currencyToBeExchange) && "CZK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.EUR) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.EUR = user1.EUR - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("EUR", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.CZK = user1.CZK + (amountOfCurrencyToBeExchange * EURtoCZK);
            balanceHistoryCalculation("CZK", false, false, true, false, amountOfCurrencyToBeExchange * EURtoCZK);
        } else if ("EUR".equals(currencyToBeExchange) && "NOK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.EUR) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.EUR = user1.EUR - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("EUR", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.NOK = user1.NOK + (amountOfCurrencyToBeExchange * EURtoNOK);
            balanceHistoryCalculation("NOK", false, false, true, false, amountOfCurrencyToBeExchange * EURtoNOK);
        } else if ("EUR".equals(currencyToBeExchange) && "DKK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.EUR) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.EUR = user1.EUR - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("EUR", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.DKK = user1.DKK + (amountOfCurrencyToBeExchange * EURtoDKK);
            balanceHistoryCalculation("DKK", false, false, true, false, amountOfCurrencyToBeExchange * EURtoDKK);
        } else if ("CZK".equals(currencyToBeExchange) && "PLN".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.CZK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.CZK = user1.CZK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("CZK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.PLN = user1.PLN + (amountOfCurrencyToBeExchange * CZKtoPLN);
            balanceHistoryCalculation("PLN", false, false, true, false, amountOfCurrencyToBeExchange * CZKtoPLN);
        } else if ("CZK".equals(currencyToBeExchange) && "USD".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.CZK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.CZK = user1.CZK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("CZK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.USD = user1.USD + (amountOfCurrencyToBeExchange * CZKtoUSD);
            balanceHistoryCalculation("USD", false, false, true, false, amountOfCurrencyToBeExchange * CZKtoUSD);
        } else if ("CZK".equals(currencyToBeExchange) && "EUR".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.CZK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.CZK = user1.CZK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("CZK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.EUR = user1.EUR + (amountOfCurrencyToBeExchange * CZKtoEUR);
            balanceHistoryCalculation("EUR", false, false, true, false, amountOfCurrencyToBeExchange * CZKtoEUR);
        } else if ("CZK".equals(currencyToBeExchange) && "NOK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.CZK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.CZK = user1.CZK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("CZK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.NOK = user1.NOK + (amountOfCurrencyToBeExchange * CZKtoNOK);
            balanceHistoryCalculation("NOK", false, false, true, false, amountOfCurrencyToBeExchange * CZKtoNOK);
        } else if ("CZK".equals(currencyToBeExchange) && "DKK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.CZK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.CZK = user1.CZK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("CZK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.DKK = user1.DKK + (amountOfCurrencyToBeExchange * CZKtoDKK);
            balanceHistoryCalculation("DKK", false, false, true, false, amountOfCurrencyToBeExchange * CZKtoDKK);
        } else if ("NOK".equals(currencyToBeExchange) && "PLN".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.NOK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.NOK = user1.NOK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("NOK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.PLN = user1.PLN + (amountOfCurrencyToBeExchange * NOKtoPLN);
            balanceHistoryCalculation("PLN", false, false, true, false, amountOfCurrencyToBeExchange * NOKtoPLN);
        } else if ("NOK".equals(currencyToBeExchange) && "USD".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.NOK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.NOK = user1.NOK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("NOK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.USD = user1.USD + (amountOfCurrencyToBeExchange * NOKtoUSD);
            balanceHistoryCalculation("USD", false, false, true, false, amountOfCurrencyToBeExchange * NOKtoUSD);
        } else if ("NOK".equals(currencyToBeExchange) && "EUR".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.NOK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.NOK = user1.NOK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("NOK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.EUR = user1.EUR + (amountOfCurrencyToBeExchange * NOKtoEUR);
            balanceHistoryCalculation("EUR", false, false, true, false, amountOfCurrencyToBeExchange * NOKtoEUR);
        } else if ("NOK".equals(currencyToBeExchange) && "CZK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.NOK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.NOK = user1.NOK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("NOK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.CZK = user1.CZK + (amountOfCurrencyToBeExchange * NOKtoCZK);
            balanceHistoryCalculation("CZK", false, false, true, false, amountOfCurrencyToBeExchange * NOKtoCZK);
        } else if ("NOK".equals(currencyToBeExchange) && "DKK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.NOK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.NOK = user1.NOK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("NOK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.DKK = user1.DKK + (amountOfCurrencyToBeExchange * NOKtoDKK);
            balanceHistoryCalculation("DKK", false, false, true, false, amountOfCurrencyToBeExchange * NOKtoDKK);
        } else if ("DKK".equals(currencyToBeExchange) && "PLN".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.DKK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.DKK = user1.DKK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("DKK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.PLN = user1.PLN + (amountOfCurrencyToBeExchange * DKKtoPLN);
            balanceHistoryCalculation("PLN", false, false, true, false, amountOfCurrencyToBeExchange * DKKtoPLN);
        } else if ("DKK".equals(currencyToBeExchange) && "USD".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.DKK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.DKK = user1.DKK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("DKK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.USD = user1.USD + (amountOfCurrencyToBeExchange * DKKtoUSD);
            balanceHistoryCalculation("USD", false, false, true, false, amountOfCurrencyToBeExchange * DKKtoUSD);
        } else if ("DKK".equals(currencyToBeExchange) && "EUR".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.DKK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.DKK = user1.DKK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("DKK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.EUR = user1.EUR + (amountOfCurrencyToBeExchange * DKKtoEUR);
            balanceHistoryCalculation("EUR", false, false, true, false, amountOfCurrencyToBeExchange * DKKtoEUR);
        } else if ("DKK".equals(currencyToBeExchange) && "CZK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.DKK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.DKK = user1.DKK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("DKK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.CZK = user1.CZK + (amountOfCurrencyToBeExchange * DKKtoCZK);
            balanceHistoryCalculation("CZK", false, false, true, false, amountOfCurrencyToBeExchange * DKKtoCZK);
        } else if ("DKK".equals(currencyToBeExchange) && "NOK".equals(currencyToBeExchangeFor)) {
            if (amountOfCurrencyToBeExchange > user1.DKK) {
                do {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("You do not have enough funds to complete this operation");
                    System.out.println("0. Exit to client panel");
                    scanner = scan.nextInt();
                } while (scanner != 0);
                clientPanelMenu();
            }
            user1.DKK = user1.DKK - amountOfCurrencyToBeExchange;
            balanceHistoryCalculation("DKK", false, false, false, true, amountOfCurrencyToBeExchange);
            user1.NOK = user1.NOK + (amountOfCurrencyToBeExchange * DKKtoNOK);
            balanceHistoryCalculation("DKK", false, false, true, false, amountOfCurrencyToBeExchange * DKKtoNOK);
        }
    }

    public static void balanceHistoryCalculation(String currency, boolean isDepositBalanceHistory, boolean isWithdrawalBalanceHistory, boolean isAddedAfterCurrencyExchangeBalanceHistory, boolean isDeductedAfterCurrencyExchangeBalanceHistory, double amount) {
        String sign;
        String amountString = Double.toString(amount);
        String deposit = "deposit";
        String withdrawal = "withdrawal";
        String addedAfterTransfer = "added from transfer";
        String deductedAfterTransfer = "deducted after transfer";

        if ("PLN".equals(currency)) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stackHistoryPLN.push(now() + " | " + sign + amountString + " " + currency + " | " + deposit + " || " + "Account balance after transaction: " + user1.PLN + " " + currency);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stackHistoryPLN.push(now() + " | " + sign + amountString + " " + currency + " | " + withdrawal + " || " + "Account balance after transaction: " + user1.PLN + " " + currency);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stackHistoryPLN.push(now() + " | " + sign + amountString + " " + currency + " | " + addedAfterTransfer + " || " + "Account balance after transaction: " + user1.PLN + " " + currency);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stackHistoryPLN.push(now() + " | " + sign + amountString + " " + currency + " | " + deductedAfterTransfer + " || " + "Account balance after transaction: " + user1.PLN + " " + currency);
            }
        } else if ("USD".equals(currency)) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stackHistoryUSD.push(now() + " | " + sign + amountString + " " + currency + " | " + deposit + " || " + "Account balance after transaction: " + user1.USD + " " + currency);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stackHistoryUSD.push(now() + " | " + sign + amountString + " " + currency + " | " + withdrawal + " || " + "Account balance after transaction: " + user1.USD + " " + currency);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stackHistoryUSD.push(now() + " | " + sign + amountString + " " + currency + " | " + addedAfterTransfer + " || " + "Account balance after transaction: " + user1.USD + " " + currency);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stackHistoryUSD.push(now() + " | " + sign + amountString + " " + currency + " | " + deductedAfterTransfer + " || " + "Account balance after transaction: " + user1.USD + " " + currency);
            }
        } else if ("EUR".equals(currency)) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stackHistoryEUR.push(now() + " | " + sign + amountString + " " + currency + " | " + deposit + " || " + "Account balance after transaction: " + user1.EUR + " " + currency);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stackHistoryEUR.push(now() + " | " + sign + amountString + " " + currency + " | " + withdrawal + " || " + "Account balance after transaction: " + user1.EUR + " " + currency);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stackHistoryEUR.push(now() + " | " + sign + amountString + " " + currency + " | " + addedAfterTransfer + " || " + "Account balance after transaction: " + user1.EUR + " " + currency);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stackHistoryEUR.push(now() + " | " + sign + amountString + " " + currency + " | " + deductedAfterTransfer + " || " + "Account balance after transaction: " + user1.EUR + " " + currency);
            }
        } else if ("CZK".equals(currency)) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stackHistoryCZK.push(now() + " | " + sign + amountString + " " + currency + " | " + deposit + " || " + "Account balance after transaction: " + user1.CZK + " " + currency);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stackHistoryCZK.push(now() + " | " + sign + amountString + " " + currency + " | " + withdrawal + " || " + "Account balance after transaction: " + user1.CZK + " " + currency);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stackHistoryCZK.push(now() + " | " + sign + amountString + " " + currency + " | " + addedAfterTransfer + " || " + "Account balance after transaction: " + user1.CZK + " " + currency);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stackHistoryCZK.push(now() + " | " + sign + amountString + " " + currency + " | " + deductedAfterTransfer + " || " + "Account balance after transaction: " + user1.CZK + " " + currency);
            }
        } else if ("NOK".equals(currency)) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stackHistoryNOK.push(now() + " | " + sign + amountString + " " + currency + " | " + deposit + " || " + "Account balance after transaction: " + user1.NOK + " " + currency);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stackHistoryNOK.push(now() + " | " + sign + amountString + " " + currency + " | " + withdrawal + " || " + "Account balance after transaction: " + user1.NOK + " " + currency);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stackHistoryNOK.push(now() + " | " + sign + amountString + " " + currency + " | " + addedAfterTransfer + " || " + "Account balance after transaction: " + user1.NOK + " " + currency);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stackHistoryNOK.push(now() + " | " + sign + amountString + " " + currency + " | " + deductedAfterTransfer + " || " + "Account balance after transaction: " + user1.NOK + " " + currency);
            }
        } else if ("DKK".equals(currency)) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stackHistoryDKK.push(now() + " | " + sign + amountString + " " + currency + " | " + deposit + " || " + "Account balance after transaction: " + user1.DKK + " " + currency);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stackHistoryDKK.push(now() + " | " + sign + amountString + " " + currency + " | " + withdrawal + " || " + "Account balance after transaction: " + user1.DKK + " " + currency);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stackHistoryDKK.push(now() + " | " + sign + amountString + " " + currency + " | " + addedAfterTransfer + " || " + "Account balance after transaction: " + user1.DKK + " " + currency);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stackHistoryDKK.push(now() + " | " + sign + amountString + " " + currency + " | " + deductedAfterTransfer + " || " + "Account balance after transaction: " + user1.DKK + " " + currency);
            }
        }

    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

}