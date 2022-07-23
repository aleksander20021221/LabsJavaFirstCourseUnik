package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;
import java.util.ArrayList;

public class Fractions {
    int numerator;
    int denominator;
    Fractions(String s) {
        String str1 = s.substring(0, s.indexOf("/"));
        numerator = Integer.parseInt(str1);
        String str2 = s.substring(s.indexOf("/") + 1);
        denominator = Integer.parseInt(str2);
    }
    Fractions(int num, int div) {
        numerator = num;
        denominator = div;
    }
    private static Integer randDenom(int min, int max, int block){
        Random randomizer= new Random();
        int randDenom=block;
        while (randDenom==block)
            randDenom=randomizer.nextInt(max-min)+min;
        return randDenom;
    }
    void betterForm() {
        int sign;
        if ((numerator * denominator) < 0)
            sign = -1;
        else
            sign = 1;
        numerator = sign * Math.abs(numerator);
        denominator = Math.abs(denominator);
    }
    //меньше ли текущая дробь-элемент массива- другого элемента
    private boolean compareLess (Fractions f){
        return f.denominator * numerator < f.numerator * denominator;
    }
    //равны ли две дроби
    private boolean compareEquality (Fractions f){
        return f.denominator*numerator==f.numerator*denominator;
    }
    //поск минимума в массиве, начиная с определенного элемента
    private static Fractions min (Fractions[]arr, int start){
        Fractions min =arr[start];
        for (int i=start;i<arr.length;i++)
            if (arr[i].compareLess(min))
                min=arr[i];
        return min;
    }
    //сортировка массива заданным способом
    private static void sorting(Fractions [] arr){
        int counter=0;
        while (counter<arr.length-1) {
            for (int i = counter; i < arr.length; i++) {
                if (arr[i].compareEquality(min(arr, counter))) {
                    Fractions c = arr[i];
                    arr[i] = arr[counter];
                    arr[counter] = c;
                    counter++;
                }
            }
        }
        //ВЫВОД ОТСОРТИРОВАННОГО МАССИВА
        {
            if (arr.length > 10) {
                ArrayList <String> listOne= new ArrayList<>();
                ArrayList <String> listTwo= new ArrayList<>();
                for (int i=0;i<5;i++){
                    listOne.add(arr[i].numerator+"/"+arr[i].denominator);
                }
                for (int j=arr.length-5;j<arr.length;j++){
                    listTwo.add(arr[j].numerator+"/"+arr[j].denominator);
                }
                System.out.println("Отсортированный массив: " + listOne+ "..."+listTwo);
            }
            else {
                ArrayList <String> listWhole= new ArrayList<>();
                for (Fractions fractions : arr) {
                    listWhole.add(fractions.numerator + "/" + fractions.denominator);
                }
                System.out.println("Отсортированный массив: " + listWhole);
            }
        }
    }
    //поиск данной дроби
    private static int search(Fractions[]arr, int left, int right, Fractions a) {
        if (left>right) {
            return 0;
        }
        int base = (left + right) / 2;
        if (arr[base].compareLess(a)) {
            return search(arr, base + 1, right, a);
        }
        if (a.compareLess(arr[base])) {
            return search(arr, left, base - 1, a);
        }
        if (arr[base].compareEquality(a)) {
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner inputString= new Scanner(System.in);
        System.out.println("Введите количестов элементов массива");
        int n = input.nextInt();
        System.out.println("введите нижнюю границу диапазона");
        int low=input.nextInt();
        System.out.println("введите верхнюю границу диапазона");
        int high=input.nextInt();
        int diff = high - low;
        Random randomizer = new Random();
        Fractions[] arrayOfFractions = new Fractions[n];
        for (int i = 0; i < arrayOfFractions.length; i++) {
            int numer=randomizer.nextInt(diff+1)+low;
            int denomer=randDenom(low,high,0);
            arrayOfFractions[i] = new Fractions(numer,denomer);
            //arrayOfFractions[i].print();
        }
        if (arrayOfFractions.length > 10) {
            ArrayList <String> listOne= new ArrayList<>();
            ArrayList <String> listTwo= new ArrayList<>();
            for (int i=0;i<5;i++){
                listOne.add(arrayOfFractions[i].numerator+"/"+arrayOfFractions[i].denominator);
            }
            for (int j=arrayOfFractions.length-5;j<arrayOfFractions.length;j++){
                listTwo.add(arrayOfFractions[j].numerator+"/"+arrayOfFractions[j].denominator);
            }
            System.out.println("Введенный массив: " + listOne+ "..."+listTwo);
        }
        else {
            ArrayList <String> listWhole= new ArrayList<>();
            for (Fractions arrayOfFraction : arrayOfFractions) {
                listWhole.add(arrayOfFraction.numerator + "/" + arrayOfFraction.denominator);
            }
            System.out.println("Введенный массив: " + listWhole);
        }
        for (Fractions arrayOfFraction : arrayOfFractions)
            arrayOfFraction.betterForm();
        //СОРТИРОВКА
        sorting(arrayOfFractions);
        //ВВОД ДРОБИ ДЛЯ ПОИСКА
        System.out.println("Введите проверяемую дробь через знак /");
        String fracString =inputString.nextLine();
        Fractions frac = new Fractions(fracString);
        frac.betterForm();
        //БИНАРНЫЙ ПОИСК В РЕКУРСИВНОЙ РЕАЛИЗАЦИИ
        if (search(arrayOfFractions,0, arrayOfFractions.length-1,frac)==1)
            System.out.println("Введённая дробь нашлась");
        else if (search(arrayOfFractions,0, arrayOfFractions.length-1,frac)==0)
            System.out.println("Введённая дробь не нашлась");

    }
}