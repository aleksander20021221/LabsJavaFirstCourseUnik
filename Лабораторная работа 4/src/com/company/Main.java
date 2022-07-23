package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;
public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println("Введите количество элементов массива");
        Scanner input= new Scanner (System.in);
        int n=input.nextInt();
        int [] arrayOfNumbers= new int [n];
        //ввод с использованием рандомайзера
        {
            System.out.println("введите нижнюю границу диапазона");
            int low=input.nextInt();
            System.out.println("введите верхнюю границу диапазона");
            int high=input.nextInt();
            int diff = high - low;
            Random randomizer = new Random();
            for (int i = 0; i < n; i++) {
                arrayOfNumbers[i] = randomizer.nextInt(diff+1)+low;
            }
//            for (int i = 0; i < n; i++) arrayOfNumbers[i] = input.nextInt();
                if (n > 15) {
                    int[] arrOne = new int[4];
                    for (int i = 0; i < 4; i++) {
                        arrOne[i] = arrayOfNumbers[i];
                    }
                    String numOne = Arrays.toString(arrOne);

                    int[] arrTwo = new int[4];
                    for (int i = 0; i < 4; i++) {
                        arrTwo[i] = arrayOfNumbers[arrayOfNumbers.length - 4+i];
                    }
                    String numTwo = Arrays.toString(arrTwo);
                    System.out.println("Введенный массив: " + numOne + "..." + numTwo);
                }
                else {
                    String numbersString = Arrays.toString(arrayOfNumbers);
                    System.out.println("Введенный массив: " + numbersString);
                }
        }
        //сортировка массива
        sorting(arrayOfNumbers);
        System.out.println("Введите проверяемое число");
        int x=input.nextInt();
        //проверка входа числа в массив
        if (search(arrayOfNumbers,0, arrayOfNumbers.length-1,x)==1)
            System.out.println("Введённое число нашлось");
        else if (search(arrayOfNumbers,0, arrayOfNumbers.length-1,x)==0)
            System.out.println("Введённое число не нашлось");
    }
    //ПОИСК МИНИМУМА В МАССИВЕ, НАЧИНАЯ С УКАЗАННОГО НОМЕРА
    private static int min (int[]arr, int start){
        int min =arr[start];
        for (int i=start;i<arr.length;i++)
            if (arr[i]<min)
                min=arr[i];
        return min;
    }
    //СОРТРОВКА МАССИВА ЗАДАННЫМ СПОСОБОМ
    private static void sorting(int [] arr){
        int counter=0;
        while (counter<arr.length-1) {
            for (int i = counter; i < arr.length; i++) {
                if (arr[i] == min(arr, counter)) {
                    int c = arr[i];
                    arr[i] = arr[counter];
                    arr[counter] = c;
                    counter++;
                }
            }
        }
        //ВЫВОД ОТСОРТИРОВАННОГО МАССИВА
        {
            if (arr.length > 15) {
                int[] arrOne = new int[4];
                for (int i = 0; i < 4; i++) {
                    arrOne[i] = arr[i];
                }
                String numOne = Arrays.toString(arrOne);
                int[] arrTwo = new int[4];

                for (int i = 0; i < 4; i++) {
                    arrTwo[i] = arr[arr.length - 4 + i];
                }
                String numTwo = Arrays.toString(arrTwo);
                System.out.println("Отсортированный массив: " + numOne + "..." + numTwo);
            }
            else {
                String numbersString = Arrays.toString(arr);
                System.out.println("Отсортированный массив: " + numbersString);
            }
        }
    }
    //ПОИСК ДАННОГО ЧИСЛА В РЕКУРСИВНОЙ РЕАЛИЗАЦИИ
    private static int search(int[]arr, int left, int right, int a) {
        if (left>right) {
            return 0;
        }
        int base = (left + right) / 2;
        if (arr[base] < a) {
            return search(arr, base + 1, right, a);
        }
        if (arr[base] > a) {
            return search(arr, left, base - 1, a);
        }
        if (arr[base]==a) {
            return 1;
        }
        return 0;
    }
}
