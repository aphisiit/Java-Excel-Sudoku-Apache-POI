package com.guy;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * Created by aphis on 29-Nov-16.
 */
public class Main {
    public static void main(String[] args){
        try{
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Document Files","xlsx");
            JFileChooser chooser= new JFileChooser();
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(null);
            File chosenFile = chooser.getSelectedFile();

            int[][] table = IOHandle.readExcel(chosenFile.getPath());
            //display(table);

            Sudoku sudoku = new Sudoku(table);
            System.out.println("Before solve");
            sudoku.printSudooku();

            sudoku.initSubsets();
            sudoku.solve();
//        System.out.println(sudoku.solve());

            System.out.println("After solve");
            sudoku.printSudooku();

//            table = sudoku.getSududo();
            //IOHandle.writeNewExcel(table,chosenFile.getPath());

            int dialogResult = JOptionPane.showConfirmDialog(null,"Would you like to over write file ?");
            if(dialogResult == JOptionPane.YES_OPTION){
                IOHandle.writeOverExcel(table,chosenFile.getPath());
            }
            else{
                JFileChooser folderChooser = new JFileChooser();
                folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                folderChooser.setFileFilter(filter);
                folderChooser.showSaveDialog(null);
                IOHandle.writeNewExcel(table,folderChooser.getSelectedFile().getPath() + ".xlsx");
                //System.out.println(folderChooser.getSelectedFile().getPath() + ".xlsx");
            }

        }catch (NullPointerException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,"You not choose file.");
            JOptionPane.showMessageDialog(null, "Program exist");
        }catch (Exception e){

        }
    }
}
