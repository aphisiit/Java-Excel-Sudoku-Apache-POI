//package com.guy;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//public class Write {

//    public static void main(String[] args) {
//	// write your code here
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("JAVA BOOKS");
//
//        Object[][] bookData = {
//                {1,null,3},
//                {4,5,6},
//                {7,8,9}
//        };
//
//        int rowCount = 0;
//
//        for(Object[] aBook : bookData){
//            Row row = sheet.createRow(++rowCount);
//
//            int columnCount = 0;
//
//            for(Object field : aBook){
//                Cell cell = row.createCell(++columnCount);
//                if(field instanceof String){
//                    cell.setCellValue((String) field);
//                }else if(field instanceof Integer){
//                    cell.setCellValue((Integer) field);
//                }
//            }
//        }
//
//        try{
//            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\aphis\\Desktop\\write.xlsx");
//            workbook.write(outputStream);
//            System.out.println("Done");
//        }catch (Exception e){
//            System.out.println("Can not write file");
//        }
//    }
//}
