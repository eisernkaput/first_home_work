package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
        forthTask();
        fifthTask();
        sixthTask();
        seventhTask();
        eighthTask();
    }

    //Сравнение чисел: Напишите программу, которая сравнивает два числа и определяет, равны ли они или одно больше другого.
    private static void firstTask() {
        System.out.println("Введи поочередно два числа для сравнения.");
        System.out.println(compareTwoNumbers(inputNumRead(), inputNumRead()));
    }

    private static String compareTwoNumbers(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return "Первое число больше второго.";
        } else if (firstNum == secondNum) {
            return "Числа равны.";
        } else {
            return "Первое число меньше второго.";
        }
    }

    //Проверка на четность: Напишите программу, которая определяет, является ли введенное число четным или нечетным.
    private static void secondTask() {
        System.out.println("Введи одно число для определения его четности");
        System.out.println(isEvenNumber(inputNumRead()));
    }

    private static String isEvenNumber(int inputNum) {
        return inputNum % 2 == 0 ? "Число четное." : "Число не четное.";
    }

    //Калькулятор: Напишите программу-калькулятор, которая выполняет арифметические операции (сложение, вычитание, умножение, деление)
    // над двумя числами в зависимости от выбора пользователя.
    private static void thirdTask() {
        String operand;

        List<String> validOperandList = new ArrayList<>(List.of("+", "-", "*", "/"));
        System.out.println("Введи поочередно два натуральных числа и знак арифметической операции (+,-,*,/) для её проведения.");
        int fistNum = inputNumRead();
        int secondNum = inputNumRead();
        try {
            while (true) {
                operand = reader.readLine();
                if (!validOperandList.contains(operand)) {
                    System.out.println("Введен некорректный символ операнда. Введи повторно символ из списка: +,-,*,/");
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
        System.out.println(calculateTwoNumbers(fistNum, secondNum, operand));
    }

    private static String calculateTwoNumbers(int firstNum, int secondNum, String operand) {
        int result = switch (operand) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> firstNum / secondNum;
        };
        return String.valueOf(result);
    }

    //Определение високосного года: Напишите программу, которая определяет, является ли заданный год високосным.
    private static void forthTask() {
        System.out.println("Введи год, для определения високосный ли он.");
        System.out.println(isLeapYear(inputNumRead()));
    }

    private static String isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return "Год високосный.";
        }
        return "Год не високосный.";
    }

    //Расчет факториала: Пользователь вводит число, программа должна вычислить его факториал.
    private static void fifthTask() {
        System.out.println("Введи натуральное число для определения факториала");
        System.out.println(factorial());
    }

    private static Long factorial() {
        int inputNum = inputNumRead();
        try {
            long factorial = 1L;
            for (long i = 1L; i <= inputNum; i++) {
                factorial = Math.multiplyExact(factorial, i);
            }
            return factorial;
        } catch (ArithmeticException e) {
            System.out.println("Произошло переполнение переменной. Введи число меньше");
            return factorial();
        }
    }

    //Определение времени суток: Пользователь вводит текущее время (часы), программа должна определить, утро, день, вечер или ночь.
    private static void sixthTask() {
        System.out.println("Введи текущее время (часы) в формате 24ч, для определения времени суток");
        System.out.println(dayPeriod(inputNumRead()));
    }

    private static String dayPeriod(int hour) {
        if (hour > 24) return "Введите корректное время.";
        if (4 < hour && hour < 12) {
            return "утро";
        } else if (12 <= hour && hour < 17) {
            return "день";
        } else if (17 <= hour && hour <= 23) {
            return "вечер";
        } else {
            return "ночь";
        }
    }

    //Перевод числа в римскую систему: Напишите программу, которая преобразует введенное число в римскую систему счисления.
    private static void seventhTask() {
        System.out.println("Введи целое число, для преобразования в число в римcкой системе счисления");
        System.out.println(toRomanNum(inputNumRead()));
    }

    private static String toRomanNum(int inputNum) {
        String romanNum = "";

        if (inputNum > 1000) {
            for (int i = 0; i < inputNum / 1000; i++) {
                romanNum = romanNum.concat("M");
            }
        }
        if (inputNum > 100) {
            romanNum = romanNum.concat(bitUnitToRoman((inputNum / 100) % 10, new String[]{"C", "D", "M"}));
        }
        if (inputNum > 10) {
            romanNum = romanNum.concat(bitUnitToRoman((inputNum / 10) % 10, new String[]{"X", "L", "C"}));
        }
        romanNum = romanNum.concat(bitUnitToRoman((inputNum % 10), new String[]{"I", "V", "X"}));
        return romanNum;
    }

    private static String bitUnitToRoman(int bitUnit, String[] romanIntArr) {
        if (bitUnit > 9) throw new RuntimeException("В преобразование попала не цифра разряда");
        else if (bitUnit == 4) {
            return romanIntArr[0].concat(romanIntArr[1]);
        } else if (bitUnit == 9) {
            return romanIntArr[0].concat(romanIntArr[romanIntArr.length - 1]);
        } else {
            String romanNum;
            int startIndex;
            if (bitUnit < 4) {
                romanNum = romanIntArr[0];
                startIndex = 1;
            } else {
                romanNum = romanIntArr[1];
                startIndex = 5;
            }
            while (startIndex < bitUnit) {
                romanNum = romanNum.concat(romanIntArr[0]);
                startIndex++;
            }
            return romanNum;
        }
    }

    //Проверка на простое число: Напишите программу, которая определяет, является ли заданное число простым.
    //Результат "Число является простым".
    //Просто́е число́ — натуральное число, имеющее ровно два различных натуральных делителя. Другими словами, натуральное
    //число 𝑝 является простым, если оно отлично от 1 и делится без остатка только на 1 и на само 𝑝
    //Пример: число 2 простое (делится на 1 и на 2), а 4 не является простым, так как, помимо 1 и 4,
    // делится на 2 — имеет три натуральных делителя.
    private static void eighthTask() {
        System.out.println("Введи целое число, для определения простое оно или составное");
        System.out.println(isSimpleNum(inputNumRead()));
    }

    private static String isSimpleNum(long inputNum) {
        int naturalNum = 2;

        if (inputNum >= 0) {
            if (inputNum <= 1) return "Числа 0 и 1 не относятся к простым или составным";
            else {
                while (naturalNum < inputNum) {
                    if (inputNum % naturalNum == 0) return "Число является составным";
                    naturalNum++;
                }
                return "Число является простым";
            }
        } else if (inputNum == -1) return "Числа 0 и -1 не относятся к простым или составным";
        else {
            while (naturalNum > inputNum) {
                if (inputNum % naturalNum == 0) return "Число является составным";
                naturalNum--;
            }
            return "Число является простым";
        }
    }

    // утилитный метод ввода данных с консоли
    private static int inputNumRead() throws RuntimeException {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
    }
}
