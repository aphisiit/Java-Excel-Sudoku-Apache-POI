package com.guy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by aphis on 28-Nov-16.
 */
public class Test {
    public static void main(String[] args){
        Random random = new Random();
        int max = 9;
        int min = 1;
        System.out.println(random.nextInt((max - min) + 1) + min);
    }
}
