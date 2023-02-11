package org.example;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Excel {

    public static void readFromExcel() {
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
