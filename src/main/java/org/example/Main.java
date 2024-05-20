package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
//        firstTask();
//        secondTask();
//        thirdTask();
//        forthTask();
        fifthTask();
    }

//Сравнение чисел: Напишите программу, которая сравнивает два числа и определяет, равны ли они или одно больше другого.
    private void firstTask(){
        int firstNum;
        int secondNum;

        System.out.println("Введи поочередно два числа для сравнения.");
        try {
            firstNum = Integer.parseInt(reader.readLine());
            secondNum = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
        System.out.println(compareTwoNumbers(firstNum,secondNum));
    }

    private static String compareTwoNumbers(int firstNum, int secondNum){
        if (firstNum > secondNum) {
            return "Первое число больше второго.";
        } else {
            return "Первое число меньше второго.";
        }
    }

//Проверка на четность: Напишите программу, которая определяет, является ли введенное число четным или нечетным.
    private static void secondTask(){
        int inputNum;

        System.out.println("Введи одно число для определения его четности");
        try {
            inputNum = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
        System.out.println(isEvenNumber(inputNum));
    }

    private static String isEvenNumber(int inputNum){
        return inputNum % 2 == 0
                ? "Число четное."
                : "Число не четное.";
    }

//Калькулятор: Напишите программу-калькулятор, которая выполняет арифметические операции (сложение, вычитание, умножение, деление)
// над двумя числами в зависимости от выбора пользователя.
    private static void thirdTask(){
        int firstNum;
        int secondNum;
        String operand;

        List<String> validOperandList = new ArrayList<>(List.of("+", "-", "*", "/"));

        System.out.println("Введи поочередно два натуральных числа и знак арифметической операции (+,-,*,/) для её проведения.");
        try {
            firstNum = Integer.parseInt(reader.readLine());
            secondNum = Integer.parseInt(reader.readLine());
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
        System.out.println(calculateTwoNumbers(firstNum, secondNum, operand));
    }

    private static String calculateTwoNumbers(int firstNum, int secondNum, String operand) {
        int result;
        switch (operand) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            default:
                result = firstNum / secondNum;
                break;
        }
        return String.valueOf(result);
    }

//Определение високосного года: Напишите программу, которая определяет, является ли заданный год високосным.
    private static void forthTask(){
        int inputNum;

        System.out.println("Введи год, для определения високосный ли он.");
        try {
            inputNum = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
        System.out.println(isLeapYear(inputNum));
    }


    private static String isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return "Год високосный.";
        }
        return "Год не високосный.";
    }

//Расчет факториала: Пользователь вводит число, программа должна вычислить его факториал.
    private static void fifthTask(){
        int inputNum;

        System.out.println("Введи натуральное число для определения факториала");
        try {
            inputNum = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
        System.out.println(factorial(inputNum));
    }


    private static String factorial(int inputNum) {
        int factorial = 1;
        for (int i = 1; i <= inputNum; i++) {
            factorial = factorial * i;
        }
        return String.valueOf(factorial);
    }

//    Определение времени суток: Пользователь вводит текущее время (часы), программа должна определить, утро, день, вечер или ночь.

}
