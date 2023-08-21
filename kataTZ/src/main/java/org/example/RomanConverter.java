package org.example;

import java.util.Arrays;

public class RomanConverter {
    // Массивы с римскими и арабскими числами
    private static final String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private static final int[] arabicNumerals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    // Метод для конвертации из римских чисел в арабские
    public static int toArabic(String romanNumeral) {
        romanNumeral = romanNumeral.toUpperCase();
        for(char s:romanNumeral.toCharArray())
            if(!Arrays.stream(romanNumerals).toList().contains(""+s)) throw new IllegalArgumentException("ввел какую-то дичь");

        int result = 0;
        int i = 0;

        // Проверяем каждую римскую цифру и добавляем соответствующее арабское число
        while (i < romanNumerals.length) {
            if (romanNumeral.startsWith(romanNumerals[i])) {
                result += arabicNumerals[i];
                romanNumeral = romanNumeral.substring(romanNumerals[i].length());
            } else {
                i++;
            }
        }

        return result;
    }

    // Метод для конвертации из арабских чисел в римские
    public static String toRoman(int arabicNumeral) {
        StringBuilder result = new StringBuilder();

        // Проверяем каждое арабское число и добавляем соответствующую римскую цифру
        for (int i = 0; i < arabicNumerals.length; i++) {
            while (arabicNumeral >= arabicNumerals[i]) {
                result.append(romanNumerals[i]);
                arabicNumeral -= arabicNumerals[i];
            }
        }

        return result.toString();
    }
}
