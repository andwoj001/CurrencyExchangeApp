package org.example;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    public static void readFromExcel() throws IOException {

        FileInputStream file = new FileInputStream("D:/JAVA/221004_CurrencyExchangeApplication/CurrencyExchangeApplication/PlikDoOdczytu.xlsx");
        XSSFWorkbook wb;
        wb = new XSSFWorkbook(file);

        String d = String.valueOf(wb.getSheetAt(0).getRow(0).getCell(0));

        System.out.println(d);

//            Sheet sheet1 = wb.getSheetAt(0);
//            Row row = sheet1.getRow(0);
//            Cell cell = row.getCell(0);


//        String howMuchEur = cell.getStringCellValue();


//        String excel2007File = "plik.xlsx";//Plik z którego pobieramy dane
//        XSSFWorkbook wb;
//        wb = new XSSFWorkbook(excel2007File);
//        Sheet sheet = wb.getSheetAt(0);
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);


    }
}
