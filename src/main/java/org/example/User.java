package org.example;

public class User {

    public String userName;
    public static String userPassword;
    public static int userNumber;
    public static boolean isLoggedIn;
    public double PLN;
    public double USD;
    public double EUR;
    public double CZK;
    public double NOK;
    public double DKK;

    public User(String userName, int userNumber, String userPassword) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userPassword = userPassword;
    }

    public void addToUserAccountBalance(double amount, String currency) {

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

    public static boolean isUserNumberAndUserPasswordCorrectSetLogIn(int userNumber, String userPassword){
        for (User user : UsersList.usersList) { // przeszukujemy listę użytkowników
            if (user.userNumber == userNumber && user.userPassword.equals(userPassword)) {
                user.isLoggedIn = true;
                return true;
            }
        } return false;
    }

    public static User getLoggedInUser() {
        for (User user : UsersList.usersList) { // Przechodzimy przez wszystkich użytkowników w liście usersList
            if (user.isLoggedIn) { // Sprawdzamy czy użytkownik jest zalogowany
                return user; // Jeśli tak, to zwracamy ten obiekt User
            }
        } return null; // Jeśli nie znaleziono użytkownika zalogowanego, to zwracamy null
    }

    public static void setIsLoggedInForAllUsersToFalse(){
        for (User user : UsersList.usersList) {
            user.isLoggedIn = false; // ustaw pole isLoggedIn na false
        }
    }
}
