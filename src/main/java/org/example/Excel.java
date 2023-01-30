package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import static org.example.Menu.*;

public class Excel {

    public static void test() {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet1 = workbook.createSheet("Andrzej Wojciechowski");

        Row row1 = sheet1.createRow(0);

        row1.createCell(0).setCellValue("Account balance ->");
        row1.createCell(1).setCellValue("PLN");
        row1.createCell(2).setCellValue("USD");
        row1.createCell(3).setCellValue("EUR");
        row1.createCell(4).setCellValue("CZK");
        row1.createCell(5).setCellValue("NOK");
        row1.createCell(6).setCellValue("DKK");

        Row row2 = sheet1.createRow(1);
        row2.createCell(1).setCellValue(balancePLN);
        row2.createCell(2).setCellValue(balanceUSD);
        row2.createCell(3).setCellValue(balanceEUR);
        row2.createCell(4).setCellValue(balanceCZK);
        row2.createCell(5).setCellValue(balanceNOK);
        row2.createCell(6).setCellValue(balanceDKK);

        Sheet sheet2 = workbook.createSheet("Jan Nowak");
        Row row11 = sheet2.createRow(0);

        row11.createCell(0).setCellValue("Account balance ->");
        row11.createCell(1).setCellValue("PLN");
        row11.createCell(2).setCellValue("USD");
        row11.createCell(3).setCellValue("EUR");
        row11.createCell(4).setCellValue("CZK");
        row11.createCell(5).setCellValue("NOK");
        row11.createCell(6).setCellValue("DKK");

        Row row22 = sheet2.createRow(1);
        row22.createCell(1).setCellValue(balancePLN);
        row22.createCell(2).setCellValue(balanceUSD);
        row22.createCell(3).setCellValue(balanceEUR);
        row22.createCell(4).setCellValue(balanceCZK);
        row22.createCell(5).setCellValue(balanceNOK);
        row22.createCell(6).setCellValue(balanceDKK);

        try {
            workbook.write(new FileOutputStream("ExcelSample.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }
