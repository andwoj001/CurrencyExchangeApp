package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTest {

    public static void test() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet1 = workbook.createSheet("test");
        Row row1 = sheet1.createRow(0);
        row1.createCell(0).setCellValue("Header 1");
        row1.createCell(1).setCellValue("Header 2");
        row1.createCell(2).setCellValue("Header 3");

        Row row2 = sheet1.createRow(1);
        row2.createCell(0).setCellValue("Value1");
        row2.createCell(1).setCellValue("Value2");
        row2.createCell(2).setCellValue("Value3");

        try {
            workbook.write(new FileOutputStream("ExcelSample.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
