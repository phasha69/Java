package org.example;

import java.util.Scanner;

import static org.example.RomanConverter.toArabic;
import static org.example.RomanConverter.toRoman;


public class Main {
    public static void main(String[] arg) {
        String input = new Scanner(System.in).nextLine();
            int x;
        try{
            x = Integer.parseInt(input);
            System.out.println(toRoman(x));
        }catch (NumberFormatException e){
            x = toArabic(input);
            System.out.println("оу, вы решили ввести римские)");
            System.out.println(x);
        }
    }
}
