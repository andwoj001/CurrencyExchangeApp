package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Excel {

    public static void readFromExcel() throws IOException {

        FileInputStream file = new FileInputStream("D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication/PlikDoOdczytu.xlsx");
        XSSFWorkbook wb;
        wb = new XSSFWorkbook(file);

        String d = String.valueOf(wb.getSheetAt(0).getRow(0).getCell(0));

        System.out.println(d);

    }

    public static void createNewExcel() throws IOException {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a new sheet
        Sheet sheet = workbook.createSheet("Andrzej Wojciechowski");

        // Create a new row
        Row row = sheet.createRow(0);

        // Create a new cell
        Cell cell = row.createCell(0);
        // Set the value of the cell
        cell.setCellValue("Hello, World!");

        // Write the workbook to a file
        FileOutputStream fileOut = new FileOutputStream("PlikDoOdczytu.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Close the workbook
        workbook.close();

        String d = String.valueOf(workbook.getSheet("Andrzej Wojciechowski").getRow(0).getCell(0));
        System.out.println(d);
    }

    public static void checkFileExistence() {
        String filename = "PlikDoOdczytu.xlsx";
        String directory = "D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication";

        File file = new File(directory + File.separator + filename);

        //ponizej z chatu GPT, powyzej tylko do sprawdzania istnienia pliku
        try {
        FileInputStream file2 = new FileInputStream(new File("D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication/PlikDoOdczytu.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file2);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);

        //skonczylem na tym, ze odczytalem z pliku wartosc 1000 jako PLN

        switch (cell.getCellType()) {
            case NUMERIC:
                System.out.println("Cell Value: " + cell.getNumericCellValue());
                break;
            case STRING:
                System.out.println("Cell Value: " + cell.getStringCellValue());
                break;
            case BLANK:
                System.out.println("Cell is Blank");
                break;
            default:
                System.out.println("Cell Type not supported");
                break;
        }

            workbook.close();
            file2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//                if (file.exists()) {
//                    System.out.println("The file exists.");
//
//                    return true;
//                } else {
//                    System.out.println("The file does not exist.");
//                    return false;
//                }
    }
}
