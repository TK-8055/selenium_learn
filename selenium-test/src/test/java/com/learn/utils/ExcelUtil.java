package com.learn.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtil {

    public static String readCell(String filePath, String sheetName, int rowNum, int colNum) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            String value = cell.getStringCellValue();
            wb.close();
            return value;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeCell(String filePath, String sheetName, int rowNum, int colNum, String value) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.createCell(colNum);
            cell.setCellValue(value);

            FileOutputStream fos = new FileOutputStream(filePath);
            wb.write(fos);
            wb.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
