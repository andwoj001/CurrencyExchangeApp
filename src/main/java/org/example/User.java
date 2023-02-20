package org.example;

public class User {

    public static String userName, userPassword;
    public static int userNumber;
    public static double PLN;
    public static double USD;
    public static double EUR;
    public static double CZK;
    public static double NOK;
    public static double DKK;

    public User(String userName, int userNumber, String userPassword) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userPassword = userPassword;
    }

    public static void addToUserAccountBalance(double amount, String currency) {

        switch (currency) {

            case "PLN":
                PLN = PLN + amount;
                break;

            case "USD":
                USD = USD + amount;
                break;

            case "EUR":
                EUR = EUR + amount;
                break;

            case "CZK":
                CZK = CZK + amount;
                break;

            case "NOK":
                NOK = NOK + amount;
                break;

            case "DKK":
                DKK = DKK + amount;
                break;

        }
        Excel.refreshValuesInExcel();
    }

    public void removeFromUserAccountBalance(double amount, String currency) {


        switch (currency) {

            case "PLN":
                PLN = PLN - amount;
                break;

            case "USD":
                USD = USD - amount;
                break;

            case "EUR":
                EUR = EUR - amount;
                break;

            case "CZK":
                CZK = CZK - amount;
                break;

            case "NOK":
                NOK = NOK - amount;
                break;

            case "DKK":
                DKK = DKK - amount;
                break;

        }
        Excel.refreshValuesInExcel();
    }
}
