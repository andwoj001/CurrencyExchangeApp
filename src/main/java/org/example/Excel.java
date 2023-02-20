package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import static org.example.Menu.user1;

public class Excel {

    public static boolean checkFileExistence() {
        String filename = "PlikDoOdczytu.xlsx";
        String directory = "D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication";

        File file = new File(directory + File.separator + filename);

        if (file.exists()) {
            System.out.println("The file exists.");

            return true;
        } else {
            System.out.println("The file does not exist.");
            return false;
        }
    }

    public static void readFromFileIfExists (){

        try {
            FileInputStream file = new FileInputStream(new File("D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication/PlikDoOdczytu.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(1);
//            Cell cell = row.getCell(1);
//            cell.getNumericCellValue();

            user1.PLN = workbook.getSheetAt(0).getRow(1).getCell(1).getNumericCellValue();
            user1.USD = workbook.getSheetAt(0).getRow(1).getCell(2).getNumericCellValue();
            user1.EUR = workbook.getSheetAt(0).getRow(1).getCell(3).getNumericCellValue();
            user1.CZK = workbook.getSheetAt(0).getRow(1).getCell(4).getNumericCellValue();
            user1.DKK = workbook.getSheetAt(0).getRow(1).getCell(5).getNumericCellValue();
            user1.NOK = workbook.getSheetAt(0).getRow(1).getCell(6).getNumericCellValue();

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void createNewFileIfNotExists() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("Andrzej Wojciechowski");
        Row row0 = sheet1.createRow(0);

        Cell cell00 = row0.createCell(0);
        Cell cell01 = row0.createCell(1);
        Cell cell02 = row0.createCell(2);
        Cell cell03 = row0.createCell(3);
        Cell cell04 = row0.createCell(4);
        Cell cell05 = row0.createCell(5);
        Cell cell06 = row0.createCell(6);

        cell00.setCellValue("Currency:");
        cell01.setCellValue("PLN");
        cell02.setCellValue("USD");
        cell03.setCellValue("EUR");
        cell04.setCellValue("CZK");
        cell05.setCellValue("DKK");
        cell06.setCellValue("NOK");

        Row row1 = sheet1.createRow(1);
        Cell cell10 = row1.createCell(0);
        Cell cell11 = row1.createCell(1);
        Cell cell12 = row1.createCell(2);
        Cell cell13 = row1.createCell(3);
        Cell cell14 = row1.createCell(4);
        Cell cell15 = row1.createCell(5);
        Cell cell16 = row1.createCell(6);

        cell10.setCellValue("Balance:");
        cell11.setCellValue(user1.PLN);
        cell12.setCellValue(user1.USD);
        cell13.setCellValue(user1.EUR);
        cell14.setCellValue(user1.CZK);
        cell15.setCellValue(user1.DKK);
        cell16.setCellValue(user1.NOK);

        FileOutputStream fileOut = new FileOutputStream("PlikDoOdczytu.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }

    public static void refreshValuesInExcel(){
        try {
            FileInputStream file = new FileInputStream(new File("D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication/PlikDoOdczytu.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);


//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row = sheet.getRow(1);
//            Cell cell = row.getCell(1);
//            cell.getNumericCellValue();

//            workbook.close();
//            file.close();

            workbook.getSheetAt(0).getRow(1).getCell(1).setCellValue(user1.PLN);
            workbook.getSheetAt(0).getRow(1).getCell(2).setCellValue(user1.USD);
            workbook.getSheetAt(0).getRow(1).getCell(3).setCellValue(user1.EUR);
            workbook.getSheetAt(0).getRow(1).getCell(4).setCellValue(user1.CZK);
            workbook.getSheetAt(0).getRow(1).getCell(5).setCellValue(user1.DKK);
            workbook.getSheetAt(0).getRow(1).getCell(6).setCellValue(user1.NOK);

            FileOutputStream fileOut = new FileOutputStream("PlikDoOdczytu.xlsx");
            workbook.write(fileOut);

            fileOut.close();

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
