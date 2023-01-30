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



    public String getUserName() {
        return userName;
    }

    public User(String userName, int userNumber, String userPassword) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userPassword = userPassword;
    }

    public void addToUserAccountBalance (double amount) {
        PLN = PLN + amount;
        USD = USD + amount;
        EUR = EUR + amount;
        CZK = CZK + amount;
        NOK = NOK + amount;
        DKK = DKK + amount;
    }

    public void removeFromUserAccountBalance (double amount) {

    }

}
