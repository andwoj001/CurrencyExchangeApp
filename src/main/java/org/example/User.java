package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class User {

    public static String userName, userPassword;
    public static int userNumber;
    public static double PLN;
    public static double USD;
    public static double EUR;
    public static double CZK;
    public static double NOK;
    public static double DKK;

    static Excel excel = new Excel();

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

            case "CZK":
                CZK = CZK + amount;

            case "NOK":
                NOK = NOK + amount;

            case "DKK":
                DKK = DKK + amount;
                break;
        }
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

            case "CZK":
                CZK = CZK - amount;

            case "NOK":
                NOK = NOK - amount;

            case "DKK":
                DKK = DKK - amount;
                break;

        }

    }
}
