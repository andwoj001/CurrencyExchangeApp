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

    static Workbook workbook1 = new XSSFWorkbook();

    static Sheet sheet1 = workbook1.createSheet("Andrzej Wojciechowski");
    static Row row1 = sheet1.createRow(0);
    static Row row2 = sheet1.createRow(1);

    public User(String userName, int userNumber, String userPassword) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userPassword = userPassword;


    }

    public static void creatingExcelFile() {


        row1.createCell(0).setCellValue("Account balance ->");
        row1.createCell(1).setCellValue("PLN");
        row1.createCell(2).setCellValue("USD");
        row1.createCell(3).setCellValue("EUR");
        row1.createCell(4).setCellValue("CZK");
        row1.createCell(5).setCellValue("NOK");
        row1.createCell(6).setCellValue("DKK");

        row2.createCell(1).setCellValue(PLN);
        row2.createCell(2).setCellValue(USD);
        row2.createCell(3).setCellValue(EUR);
        row2.createCell(4).setCellValue(CZK);
        row2.createCell(5).setCellValue(NOK);
        row2.createCell(6).setCellValue(DKK);

        try (FileOutputStream outputStream = new FileOutputStream("workbook1.xlsx")) {
            workbook1.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static void addToUserAccountBalance(double amount, String currency) {
        switch (currency) {

            case "PLN":
                PLN = PLN + amount;
                row1.createCell(1).setCellValue(PLN);
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
