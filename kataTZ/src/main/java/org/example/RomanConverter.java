package org.example;

import java.util.Arrays;

class RomanConverter {
    // Массивы с римскими и арабскими числами
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ARABIC_NUMERALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final Character[] NUMERALS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // Метод для конвертации из римских чисел в арабские
    public static int toArabic(String romanNumeral) {
        romanNumeral = romanNumeral.toUpperCase();
        // Ищем не существующие символы
        for (char s : romanNumeral.toCharArray())
            if (!Arrays.stream(ROMAN_NUMERALS).toList().contains("" + s)) {
                if (Arrays.stream(NUMERALS).toList().contains(s)) { // Посмотрим, нет ли арабских цифр
                    throw new IllegalArgumentException("Введены разные системы счисления.");
                }
                throw new IllegalArgumentException("Введено несуществующее число.");
            }

        int result = 0;
        int i = 0;

        // Проверяем каждую римскую цифру и добавляем соответствующее арабское число
        while (i < ROMAN_NUMERALS.length) {
            if (romanNumeral.startsWith(ROMAN_NUMERALS[i])) {
                result += ARABIC_NUMERALS[i];
                // И отсекаем обработанное
                romanNumeral = romanNumeral.substring(ROMAN_NUMERALS[i].length());
            } else {
                i++;
            }
        }

        return result;
    }

    // Метод для конвертации из арабских чисел в римские
    public static String toRoman(int arabicNumeral) {
        if (arabicNumeral<=0) throw new IllegalArgumentException("В римской системе счисления отсутствуют числа меньше 1.");
        StringBuilder result = new StringBuilder();

        // Проверяем каждое арабское число и добавляем соответствующую римскую цифру
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (arabicNumeral >= ARABIC_NUMERALS[i]) {
                result.append(ROMAN_NUMERALS[i]);
                arabicNumeral -= ARABIC_NUMERALS[i];
            }
        }

        return result.toString();
    }
}
