package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static org.example.RomanConverter.toArabic;
import static org.example.RomanConverter.toRoman;

public class Main {
    final public static int FIRST_INDEX = 0;
    final public static int OPERATION_INDEX = 1;
    final public static int LAST_INDEX = 2;
    final public static String[] ARITHMETICS = {"+", "-", "*", "/"};

    public static void main(String[] arg) {
        String input = new Scanner(System.in).nextLine();

        System.out.println(calc(input));
    }

    public static String calc(String input) {
        int firstNumber;
        int lastNumber;
        int result;
        // Делим выражение на строки разделенные пробелом
        String[] exp = input.split("\\s+");
        inputCorrect(exp);
        String operation = exp[OPERATION_INDEX];
        try {
            // Пробуем сначала парсить в числа
            firstNumber = Integer.parseInt(exp[FIRST_INDEX]);
            lastNumber = Integer.parseInt(exp[LAST_INDEX]);
            result = calcArabic(firstNumber, lastNumber, operation);
            return "" + result;
        } catch (NumberFormatException e) {
            // Если не получилось, пробуем работать с римсими
            firstNumber = toArabic(exp[FIRST_INDEX]);
            lastNumber = toArabic(exp[LAST_INDEX]);
            result = calcArabic(firstNumber, lastNumber, operation);
            return toRoman(result);
        }
    }
// Метод проверки на корректность ввода
    public static void inputCorrect(String[] input) {
        if (input.length != 3)
            if (input.length == 1) throw new IllegalArgumentException("Строка не является математической операцией.");
            else
                throw new IllegalArgumentException("Введен не верный формат выражения.");

        if (!Arrays.stream(ARITHMETICS).toList().contains(input[OPERATION_INDEX]))
            throw new IllegalArgumentException("Присутствует не существующая операция.");
    }
    // Метод расчета
    public static int calcArabic(int firstNumber, int lastNumber, String operation) {
        return switch (operation) {
            case "+" -> firstNumber + lastNumber;
            case "-" -> firstNumber - lastNumber;
            case "*" -> firstNumber * lastNumber;
            default -> firstNumber / lastNumber;
        };
    }
}
