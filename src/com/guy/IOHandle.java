package com.guy;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by aphis on 28-Nov-16.
 */
public class IOHandle {

     public static void writeOverExcel(int[][] table,String pathFile){
         try{
             FileInputStream fileInputStream = new FileInputStream(pathFile);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
             XSSFSheet sheet = workbook.getSheetAt(0);
             Cell cell;
//        workbook.createCellStyle();

             Object[][] bookData = new Object[9][9];
             for(int i = 0 ; i < 9 ; i++){
                 for(int j = 0 ; j < 9 ; j++){
                     bookData[i][j] = table[i][j];
                 }
             }

             int rowCount = 0;

             for(Object[] aBook : bookData){
                 XSSFRow sheetRow = sheet.getRow(rowCount++);
                 //Row row = sheet.createRow(rowCount++);

                 int columnCount = 0;

                 for(Object field : aBook){
                     //Cell cell = row.createCell(columnCount++);
                     //Cell cell = workbook
                     cell = sheetRow.getCell(columnCount++);
                     cell.setCellValue((Integer) field);
                 }
             }


            FileOutputStream outputStream = new FileOutputStream(pathFile);
            workbook.write(outputStream);
            System.out.println("Write success");
            File file = new File(pathFile);
            Desktop.getDesktop().open(file);
        }catch (Exception e){
            System.out.println("Can not write file");
        }
    }

    public static void writeNewExcel(int[][] table,String pathFile){
        try{
            //FileInputStream fileInputStream = new FileInputStream(pathFile);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            Cell cell;

            Object[][] bookData = new Object[9][9];
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    bookData[i][j] = table[i][j];
                }
            }

            int rowCount = 0;

            for(Object[] aBook : bookData){
                XSSFRow sheetRow = sheet.getRow(rowCount++);
                //Row row = sheet.createRow(rowCount++);

                int columnCount = 0;

                for(Object field : aBook){
                    //Cell cell = row.createCell(columnCount++);
                    //Cell cell = workbook
                    cell = sheetRow.getCell(columnCount++);
                    cell.setCellValue((Integer) field);
                }
            }


            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\aphis\\Desktop\\write.xlsx");
            workbook.write(outputStream);
            System.out.println("Done");

        }catch (Exception e){
            System.out.println("Can not write file");
        }
    }

    public static int[][] readExcel(String tempFile){
        try {
            //Read File
            FileInputStream file = new FileInputStream(tempFile);

            //Get the workbook instance for excel file
            Workbook workbook = new XSSFWorkbook(file);
            //get first sheet from tje work book
            Sheet firstSheet = workbook.getSheetAt(0);
            //get iterator to all the rows in current sheet
            Iterator<Row> iterator = firstSheet.iterator();

            //get iterator to all cell of current row

            int[][] table = new int[9][9];
            int i,j;

            // && iterator.hasNext()
            for(i = 0; i < 9 ; i++){
            //while (iterator.hasNext()){
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                //For each row, iterator through each column

                //&& cellIterator.hasNext()
                for(j = 0; j < 9 ; j++){
                    //declare cell get data from table
                    Cell cell = cellIterator.next();
                    //put value from cell to arrays
                    table[i][j] = (int) cell.getNumericCellValue();
                }
            }
            workbook.close();
            return table;

        }catch (IllegalStateException e){
            JOptionPane.showMessageDialog(null,"Some cell in table is not Number");
            //e.printStackTrace();
            return null;
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"File not found");
            return null;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Something went wrong, please try again !!!");
            return null;
        }
    }
}
