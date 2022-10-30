package org.example;
// skroty klawiaturowe:
// Ctrl+Shift+NumPad - / Ctrl+Shift+NumPad + -> zwijanie / rozwijanie metod
// Shift+F10 -> Run metody Main
// Ctrl+/ -> zakomentowanie zaznaczonego obszaru

//todo: login i haslo maja byc jeden po drugim a nie rownolegle <- done
//todo: po zdeponowaniu kwoty jakiejs waluty balance powinien sie powiekszac <- done
//todo: gdy wyplacam wieksza kwote niz jest na koncie, to balance powinien sie zrobic na 0 <- done
//todo: przeliczanie walut i odpowiednie odejmowanie i dodawanie do kont <- done
//todo: wyswietlanie historii 3 ostatnich transakcji dla danej waluty w formacie np.:
// "DD-MM-RRRR +200 WALUTA: acc. balance after operation: XXXX.XX WALUTA"

// dopisac warunki if not null to get dla kazdego, else println "no transacion yet"
//            System.out.println(stack.get(1));
//            System.out.println(stack.get(2));


import java.text.DecimalFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Stack;


public class Menu {
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    static Stack<String> stack = new Stack<String>();

    static int clientNumber = 0;
    static char clientPassword = '0';
    static Scanner scan = new Scanner(System.in);
    static String currencySelectedToCalculation_Deposit;
    static String currencySelectedToCalculation_Withdrawal;

    static double amount;

    static double balancePLN = 0;
    static double balanceUSD = 0;
    static double balanceEUR = 0;
    static double balanceCZK = 0;
    static double balanceNOK = 0;
    static double balanceDKK = 0;

    static String currencyToBeExchange;
    static String currencyToBeExchangeFor;
    static double amountOfCurrencyToBeExchange;

    static String currencyToCheckItsBalanceHistory;
    static boolean isDepositBalanceHistory;
    boolean isWithdrawalBalanceHistory;
    boolean isAddedAfterCurrencyExchangeBalanceHistory;
    boolean isDeductedAfterCurrencyExchangeBalanceHistory;

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
                    currencyToCheckItsBalanceHistory = "PLN";
                    balanceHistoryMenu();
                    break;
                case 2:
                    currencyToCheckItsBalanceHistory = "USD";
                    balanceHistoryMenu();
                    break;
                case 3:
                    currencyToCheckItsBalanceHistory = "EUR";
                    balanceHistoryMenu();
                    break;
                case 4:
                    currencyToCheckItsBalanceHistory = "CZK";
                    balanceHistoryMenu();
                    break;
                case 5:
                    currencyToCheckItsBalanceHistory = "NOK";
                    balanceHistoryMenu();
                    break;
                case 6:
                    currencyToCheckItsBalanceHistory = "DKK";
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
                    afterLoginMenu();
                    break;
            }
        } while (selectedCurrencyToWithdrawal != 0 && selectedCurrencyToWithdrawal != 1 && selectedCurrencyToWithdrawal != 2 && selectedCurrencyToWithdrawal != 3 && selectedCurrencyToWithdrawal != 4 && selectedCurrencyToWithdrawal != 5 && selectedCurrencyToWithdrawal != 6);
    }

    public static void checkAccountBalanceMenu() {

        int selection;

        DecimalFormat df = new DecimalFormat("####0.00");

        do {
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Your account balance:");
            System.out.println("PLN  " + df.format(balancePLN));
            System.out.println("USD  " + df.format(balanceUSD));
            System.out.println("EUR  " + df.format(balanceEUR));
            System.out.println("CZK  " + df.format(balanceCZK));
            System.out.println("NOK  " + df.format(balanceNOK));
            System.out.println("DKK  " + df.format(balanceDKK));
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
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Enter amount: ");
            amount = scan.nextDouble();
        } while (amount < 0);

        if (isDeposit == true) {
            calculateAccountBalance_Deposit(currencySelectedToCalculation_Deposit, amount);
            balanceHistoryCalculation(currencySelectedToCalculation_Deposit, true, false, false, false);
        } else if (isWithdrawal == true) {
            calculateAccountBalance_Withdrawal(currencySelectedToCalculation_Withdrawal, amount);
            balanceHistoryCalculation(currencySelectedToCalculation_Withdrawal, false, true, false, false);
        }

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

        amountOfCurrencyToBeExchange = amount;

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
            if (stack.size() > 0) {
                System.out.println(stack.get(stack.size() - 1));
                if (stack.size() > 1) {
                    System.out.println(stack.get(stack.size() - 2));
                    if (stack.size() > 2) {
                        System.out.println(stack.get(stack.size() - 3));
                    }
                }
            }
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

    public static void calculateAccountBalance_Deposit(String currencySelectedToCalculation_Deposit, double amount) {

        if ("PLN".contains(String.valueOf(currencySelectedToCalculation_Deposit))) {
            balancePLN = balancePLN + amount;
        } else if ("USD".contains(String.valueOf(currencySelectedToCalculation_Deposit))) {
            balanceUSD = balanceUSD + amount;
        }   else if ("EUR".contains(String.valueOf(currencySelectedToCalculation_Deposit))) {
            balanceEUR = balanceEUR + amount;
        }   else if ("CZK".contains(String.valueOf(currencySelectedToCalculation_Deposit))) {
            balanceCZK = balanceCZK + amount;
        }   else if ("NOK".contains(String.valueOf(currencySelectedToCalculation_Deposit))) {
            balanceNOK = balanceNOK + amount;
        }   else if ("DKK".contains(String.valueOf(currencySelectedToCalculation_Deposit))) {
            balanceDKK = balanceDKK + amount;
        }

    }

    public static void calculateAccountBalance_Withdrawal(String currencySelectedToCalculation_Withdrawal, double amount) {

        if ("PLN".contains(String.valueOf(currencySelectedToCalculation_Withdrawal))) {
            balancePLN = balancePLN - amount;
            if (balancePLN < 0) {
                balancePLN = 0;
            }
        } else if ("USD".contains(String.valueOf(currencySelectedToCalculation_Withdrawal))) {
            balanceUSD = balanceUSD - amount;
            if (balanceUSD < 0) {
                balanceUSD = 0;
            }
        }   else if ("EUR".contains(String.valueOf(currencySelectedToCalculation_Withdrawal))) {
            balanceEUR = balanceEUR - amount;
            if (balanceEUR < 0) {
                balanceEUR = 0;
            }
        }   else if ("CZK".contains(String.valueOf(currencySelectedToCalculation_Withdrawal))) {
            balanceCZK = balanceCZK - amount;
            if (balanceCZK < 0) {
                balanceCZK = 0;
            }
        }   else if ("NOK".contains(String.valueOf(currencySelectedToCalculation_Withdrawal))) {
            balanceNOK = balanceNOK - amount;
            if (balanceNOK < 0) {
                balanceNOK = 0;
            }
        }   else if ("DKK".contains(String.valueOf(currencySelectedToCalculation_Withdrawal))) {
            balanceDKK = balanceDKK - amount;
            if (balanceDKK < 0) {
                balanceDKK = 0;
            }
        }

    }

    public static void currencyExchangeCalculation(String currencyToBeExchange, String currencyToBeExchangeFor, double amountOfCurrencyToBeExchange) {
        double PLNtoUSD = 0.21; double PLNtoEUR = 0.21;  double PLNtoCZK = 5.20; double PLNtoNOK = 2.17; double PLNtoDKK = 1.58;
        double USDtoPLN = 4.73; double USDtoEUR = 1.00;  double USDtoCZK = 24.59; double USDtoNOK = 10.31; double USDtoDKK = 7.47;
        double EURtoPLN = 4.72; double EURtoUSD = 1.00;  double EURtoCZK = 24.51; double EURtoNOK = 10.26; double EURtoDKK = 7.44;
        double CZKtoPLN = 0.19; double CZKtoUSD = 0.041;  double CZKtoEUR = 0.041; double CZKtoNOK = 0.42; double CZKtoDKK = 0.30;
        double NOKtoPLN = 0.45; double NOKtoUSD = 0.096;  double NOKtoEUR = 0.097; double NOKtoCZK = 2.36; double NOKtoDKK = 0.72;
        double DKKtoPLN = 0.63; double DKKtoUSD = 0.13;  double DKKtoEUR = 0.13; double DKKtoCZK = 3.29; double DKKtoNOK = 1.38;

        if ("PLN".contains(String.valueOf(currencyToBeExchange)) && "USD".contains(String.valueOf(currencyToBeExchangeFor))) {
            balancePLN = balancePLN - amountOfCurrencyToBeExchange;
            balanceUSD = balanceUSD + (amountOfCurrencyToBeExchange * PLNtoUSD);
        } else if ("PLN".contains(String.valueOf(currencyToBeExchange)) && "EUR".contains(String.valueOf(currencyToBeExchangeFor))) {
            balancePLN = balancePLN - amountOfCurrencyToBeExchange;
            balanceEUR = balanceEUR + (amountOfCurrencyToBeExchange * PLNtoEUR);
        } else if ("PLN".contains(String.valueOf(currencyToBeExchange)) && "CZK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balancePLN = balancePLN - amountOfCurrencyToBeExchange;
            balanceCZK = balanceCZK + (amountOfCurrencyToBeExchange * PLNtoCZK);
        } else if ("PLN".contains(String.valueOf(currencyToBeExchange)) && "NOK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balancePLN = balancePLN - amountOfCurrencyToBeExchange;
            balanceNOK = balanceNOK + (amountOfCurrencyToBeExchange * PLNtoNOK);
        } else if ("PLN".contains(String.valueOf(currencyToBeExchange)) && "DKK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balancePLN = balancePLN - amountOfCurrencyToBeExchange;
            balanceDKK = balanceDKK + (amountOfCurrencyToBeExchange * PLNtoDKK);
        }


        else if ("USD".contains(String.valueOf(currencyToBeExchange)) && "PLN".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceUSD = balanceUSD - amountOfCurrencyToBeExchange;
            balancePLN = balancePLN + (amountOfCurrencyToBeExchange * USDtoPLN);
        } else if ("USD".contains(String.valueOf(currencyToBeExchange)) && "EUR".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceUSD = balanceUSD - amountOfCurrencyToBeExchange;
            balanceEUR = balanceEUR + (amountOfCurrencyToBeExchange * USDtoEUR);
        } else if ("USD".contains(String.valueOf(currencyToBeExchange)) && "CZK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceUSD = balanceUSD - amountOfCurrencyToBeExchange;
            balanceCZK = balanceCZK + (amountOfCurrencyToBeExchange * USDtoCZK);
        } else if ("USD".contains(String.valueOf(currencyToBeExchange)) && "NOK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceUSD = balanceUSD - amountOfCurrencyToBeExchange;
            balanceNOK = balanceNOK + (amountOfCurrencyToBeExchange * USDtoNOK);
        } else if ("USD".contains(String.valueOf(currencyToBeExchange)) && "DKK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceUSD = balanceUSD - amountOfCurrencyToBeExchange;
            balanceDKK = balanceDKK + (amountOfCurrencyToBeExchange * USDtoDKK);
        }


        else if ("EUR".contains(String.valueOf(currencyToBeExchange)) && "PLN".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceEUR = balanceEUR - amountOfCurrencyToBeExchange;
            balancePLN = balancePLN + (amountOfCurrencyToBeExchange * EURtoPLN);
        } else if ("EUR".contains(String.valueOf(currencyToBeExchange)) && "USD".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceEUR = balanceEUR - amountOfCurrencyToBeExchange;
            balanceUSD = balanceUSD + (amountOfCurrencyToBeExchange * EURtoUSD);
        } else if ("EUR".contains(String.valueOf(currencyToBeExchange)) && "CZK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceEUR = balanceEUR - amountOfCurrencyToBeExchange;
            balanceCZK = balanceCZK + (amountOfCurrencyToBeExchange * EURtoCZK);
        } else if ("EUR".contains(String.valueOf(currencyToBeExchange)) && "NOK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceEUR = balanceEUR - amountOfCurrencyToBeExchange;
            balanceNOK = balanceNOK + (amountOfCurrencyToBeExchange * EURtoNOK);
        } else if ("EUR".contains(String.valueOf(currencyToBeExchange)) && "DKK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceEUR = balanceEUR - amountOfCurrencyToBeExchange;
            balanceDKK = balanceDKK + (amountOfCurrencyToBeExchange * EURtoDKK);
        }


        else if ("CZK".contains(String.valueOf(currencyToBeExchange)) && "PLN".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceCZK = balanceCZK - amountOfCurrencyToBeExchange;
            balancePLN = balancePLN + (amountOfCurrencyToBeExchange * CZKtoPLN);
        } else if ("CZK".contains(String.valueOf(currencyToBeExchange)) && "USD".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceCZK = balanceCZK - amountOfCurrencyToBeExchange;
            balanceUSD = balanceUSD + (amountOfCurrencyToBeExchange * CZKtoUSD);
        } else if ("CZK".contains(String.valueOf(currencyToBeExchange)) && "EUR".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceCZK = balanceCZK - amountOfCurrencyToBeExchange;
            balanceEUR = balanceEUR + (amountOfCurrencyToBeExchange * CZKtoEUR);
        } else if ("CZK".contains(String.valueOf(currencyToBeExchange)) && "NOK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceCZK = balanceCZK - amountOfCurrencyToBeExchange;
            balanceNOK = balanceNOK + (amountOfCurrencyToBeExchange * CZKtoNOK);
        } else if ("CZK".contains(String.valueOf(currencyToBeExchange)) && "DKK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceCZK = balanceCZK - amountOfCurrencyToBeExchange;
            balanceDKK = balanceDKK + (amountOfCurrencyToBeExchange * CZKtoDKK);
        }


        else if ("NOK".contains(String.valueOf(currencyToBeExchange)) && "PLN".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceNOK = balanceNOK - amountOfCurrencyToBeExchange;
            balancePLN = balancePLN + (amountOfCurrencyToBeExchange * NOKtoPLN);
        } else if ("NOK".contains(String.valueOf(currencyToBeExchange)) && "USD".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceNOK = balanceNOK - amountOfCurrencyToBeExchange;
            balanceUSD = balanceUSD + (amountOfCurrencyToBeExchange * NOKtoUSD);
        } else if ("NOK".contains(String.valueOf(currencyToBeExchange)) && "EUR".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceNOK = balanceNOK - amountOfCurrencyToBeExchange;
            balanceEUR = balanceEUR + (amountOfCurrencyToBeExchange * NOKtoEUR);
        } else if ("NOK".contains(String.valueOf(currencyToBeExchange)) && "CZK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceNOK = balanceNOK - amountOfCurrencyToBeExchange;
            balanceCZK = balanceCZK + (amountOfCurrencyToBeExchange * NOKtoCZK);
        } else if ("NOK".contains(String.valueOf(currencyToBeExchange)) && "DKK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceNOK = balanceNOK - amountOfCurrencyToBeExchange;
            balanceDKK = balanceDKK + (amountOfCurrencyToBeExchange * NOKtoDKK);
        }


        else if ("DKK".contains(String.valueOf(currencyToBeExchange)) && "PLN".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceDKK = balanceDKK - amountOfCurrencyToBeExchange;
            balancePLN = balancePLN + (amountOfCurrencyToBeExchange * DKKtoPLN);
        } else if ("DKK".contains(String.valueOf(currencyToBeExchange)) && "USD".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceDKK = balanceDKK - amountOfCurrencyToBeExchange;
            balanceUSD = balanceUSD + (amountOfCurrencyToBeExchange * DKKtoUSD);
        } else if ("DKK".contains(String.valueOf(currencyToBeExchange)) && "EUR".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceDKK = balanceDKK - amountOfCurrencyToBeExchange;
            balanceEUR = balanceEUR + (amountOfCurrencyToBeExchange * DKKtoEUR);
        } else if ("DKK".contains(String.valueOf(currencyToBeExchange)) && "CZK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceDKK = balanceDKK - amountOfCurrencyToBeExchange;
            balanceCZK = balanceCZK + (amountOfCurrencyToBeExchange * DKKtoCZK);
        } else if ("DKK".contains(String.valueOf(currencyToBeExchange)) && "DKK".contains(String.valueOf(currencyToBeExchangeFor))) {
            balanceDKK = balanceDKK - amountOfCurrencyToBeExchange;
            balanceNOK = balanceNOK + (amountOfCurrencyToBeExchange * DKKtoNOK);
        }
    }

    public static void balanceHistoryCalculation(String currencyToCheckItsBalanceHistory, boolean isDepositBalanceHistory, boolean isWithdrawalBalanceHistory, boolean isAddedAfterCurrencyExchangeBalanceHistory, boolean isDeductedAfterCurrencyExchangeBalanceHistory) {
        String sign;
        String amountString = Double.toString(amount);
        String deposit = "deposit";
        String withdrawal = "withdrawal";
        String addedAfterTransfer = "added from transfer";
        String deductedAfterTransfer = "deducted after transfer";

        if ("PLN".contains(String.valueOf(currencyToCheckItsBalanceHistory))) {
            if (isDepositBalanceHistory) {
                sign = "+";
                stack.push(now() + sign + amountString + currencyToCheckItsBalanceHistory + deposit);
            } else if (isWithdrawalBalanceHistory) {
                sign = "-";
                stack.push(now() + sign + amountString + currencyToCheckItsBalanceHistory + withdrawal);
            } else if (isAddedAfterCurrencyExchangeBalanceHistory) {
                sign = "+";
                stack.push(now() + sign + amountString + currencyToCheckItsBalanceHistory + addedAfterTransfer);
            } else if (isDeductedAfterCurrencyExchangeBalanceHistory) {
                sign = "-";
                stack.push(now() + sign + amountString + currencyToCheckItsBalanceHistory + deductedAfterTransfer);
            }
        }

    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

}