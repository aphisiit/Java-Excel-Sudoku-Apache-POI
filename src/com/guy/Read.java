//package com.guy;
//
///**
// * Created by aphis on 28-Nov-16.
// */
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.util.Iterator;
//
//public class Read {
//    public static void main(String[] args){
//        try {
//            //Read File
//            FileInputStream file = new FileInputStream("C:\\Users\\aphis\\Desktop\\sudoku1.xlsx");
//
//            //Get the workbook instance for excel file
//            Workbook workbook = new XSSFWorkbook(file);
//            //get first sheet from tje work book
//            Sheet firstSheet = workbook.getSheetAt(0);
//            //get iterator to all the rows in current sheet
//            Iterator<Row> iterator = firstSheet.iterator();
//
//            //get iterator to all cell of current row
//
//            while (iterator.hasNext()){
//                Row nextRow = iterator.next();
//                Iterator<Cell> cellIterator = nextRow.cellIterator();
//                //For each row, iterator through each column
//
//                while (cellIterator.hasNext()){
//                    Cell cell = cellIterator.next();
//
//                    switch (cell.getCellType()){
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.print(cell.getStringCellValue());
//                            break;
//                        case Cell.CELL_TYPE_BOOLEAN:
//                            System.out.print(cell.getBooleanCellValue());
//                            break;
//                        case  Cell.CELL_TYPE_NUMERIC:
//                            System.out.print(cell.getNumericCellValue());
//                            break;
//                    }
//                    System.out.print(" | ");
//                }
//                System.out.println();
//            }
//            workbook.close();
//
//        }
//        catch (Exception e){
//            System.out.println("File not found");
//        }
//    }
//}
