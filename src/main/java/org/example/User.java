package org.example;

public class User {

    public static String userName, userPassword;
    public static int userNumber;

    public String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        User.userName = userName;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static void setUserPassword(String userPassword) {
        User.userPassword = userPassword;
    }

    public static int getUserNumber() {
        return userNumber;
    }

    public static void setUserNumber(int userNumber) {
        User.userNumber = userNumber;
    }

    public User(String userName, int userNumber, String userPassword) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userPassword = userPassword;
    }


}
