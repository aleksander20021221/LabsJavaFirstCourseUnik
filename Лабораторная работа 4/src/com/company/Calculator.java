package com.company;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Calculator {
    private static class Fractions {
        int numerator;
        int denominator;

        Fractions(String s) {
            if (s.contains("/")) {
                String str1 = s.substring(0, s.indexOf("/"));
                numerator = Integer.parseInt(str1);
                String str2 = s.substring(s.indexOf("/") + 1);
                denominator = Integer.parseInt(str2);
            } else {
                numerator = Integer.parseInt(s);
                denominator = 1;
            }
        }

        //        Fractions(int num, int div) {
//            numerator = num;
//            denominator = div;
//        }
        //поиск НОДа
        private static int greatestCommonDivisor(int a, int b) {
            if (b == 0)
                return a;
            else
                return (greatestCommonDivisor(b, a % b));
        }
        //поиск НОКа
        private static int leastCommonMultiple(int a, int b) {
            return a * (b / greatestCommonDivisor(a, b));
        }
        //умножение двух дробей
        void mult(Fractions f) {
            numerator = numerator * f.numerator;
            denominator = denominator * f.denominator;
        }
        //разность двух дробей
        void difference(Fractions f) {
            int c = denominator;
            denominator = leastCommonMultiple(c, f.denominator);
            numerator = numerator * (denominator / c) - f.numerator * (denominator / f.denominator);
        }
        //сумма двух дробей
        void sum(Fractions f) {
            int c = denominator;
            denominator = leastCommonMultiple(c, f.denominator);
            numerator = numerator * (denominator / c) + f.numerator * (denominator / f.denominator);
        }
        //частное двух дробей
        void division(Fractions f) {
            numerator = numerator * f.denominator;
            denominator = denominator * f.numerator;
        }
        //печать дроби
        void print() {
            System.out.println(numerator + "/" + denominator);
        }
        //перевод дроби в строку
        private String toStr(){
            String s=String.valueOf(numerator)+"/"+String.valueOf(denominator);
            return s;
        }
        void betterForm(){
            if (denominator!=0) {
                int c = numerator;
                int sign=1;
                if ((numerator*denominator)<0) sign=-1;
                numerator = sign*Math.abs(numerator / greatestCommonDivisor(numerator, denominator));
                denominator = Math.abs(denominator / greatestCommonDivisor(c, denominator));
                if (denominator==1)
                    System.out.println(numerator);
                else print();
            }
        }

    }
    private static void shorterFirstly(ArrayList<String> parts) {
        String umnoz = "*";
        String del = "/";
        while ((parts.contains(umnoz) | parts.contains(del))) {
            if ((parts.contains(umnoz) | parts.contains(del))) {
                for (int i = 1; i < parts.size(); i++) {
                    if (parts.get(i).equals(umnoz)) {
                        Fractions f1 = new Fractions(parts.get(i - 1));
                        Fractions f2 = new Fractions(parts.get(i + 1));
                        f1.mult(f2);
                        parts.set(i - 1, f1.toStr());
                        parts.remove(i + 1);
                        parts.remove(i);
                    } else if (parts.get(i).equals(del)) {
                        Fractions f1 = new Fractions(parts.get(i - 1));
                        Fractions f2 = new Fractions(parts.get(i + 1));
                        f1.division(f2);
                        parts.set(i - 1, f1.toStr());
                        parts.remove(i + 1);
                        parts.remove(i);
                    }
                }
            }
        }

    }
    private static void shorterSecondly(ArrayList<String> parts){
        String minus = "-";
        String plus = "+";
        while ((parts.contains(plus) | parts.contains(minus))) {
            if ((parts.contains(plus) | parts.contains(minus))) {
                for (int i = 1; i < parts.size(); i++) {
                    if (parts.get(i).equals(plus)) {
                        Fractions f1 = new Fractions(parts.get(i - 1));
                        Fractions f2 = new Fractions(parts.get(i + 1));
                        f1.sum(f2);
                        parts.set(i - 1, f1.toStr());
                        parts.remove(i + 1);
                        parts.remove(i);
                    }
                    else if (parts.get(i).equals(minus)) {
                        Fractions f1 = new Fractions(parts.get(i - 1));
                        Fractions f2 = new Fractions(parts.get(i + 1));
                        f1.difference(f2);
                        parts.set(i - 1, f1.toStr());
                        parts.remove(i + 1);
                        parts.remove(i);
                    }
                }
            }

        }
    }

    public static void main(String args[]) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Введите выражение через пробелы");
        String expression = inputString.nextLine();
        ArrayList<String> parts = new ArrayList<>();
        for (String substring : expression.split(" ")) {
            parts.add(substring);
        }
        parts.removeAll(Collections.singleton(""));
        System.out.println(parts);
        shorterFirstly(parts);
        shorterSecondly(parts);
        Fractions f= new Fractions(parts.get(0));
        System.out.println("Ответ: ");
        f.betterForm();
        System.out.println(parts);








    }
}
