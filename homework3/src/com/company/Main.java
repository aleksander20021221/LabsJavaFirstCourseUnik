package com.company;
import java.lang.String;
import java.util.Scanner;
public class Main {
    //НАЧАЛО ОСНОВНОГО АЛГОРИТМА
    public static void main(String[] args) {
        System.out.println("Введите количество чисел");
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();
        if (n>0) {
            int[] numbers = new int[n];
            System.out.println("Введите числа");


            for (int i = 0; i < n; i++) numbers[i] = input.nextInt();
            while (check(numbers, n)) {
                if (proverka(numbers, n)) {
                    System.out.println("Минимальное число:\n" + min(numbers, n));
                    System.out.println("Максимальное число:\n" + max(numbers, n));
                    printMiddles(numbers, n);
                } else System.out.println("Плохие числа");
                for (int i = 0; i < n; i++) numbers[i] = input.nextInt();
            }
            System.out.println("Программа успешно завершена");
        }
        else System.out.println("некорректный ввод\nпрограмма завершена");
    }
//КОНЕЦ ОСНОВНОГО АЛГОРИТМА
    //ВСПОМОГАТЕЛЬНЫЕ АЛГОРИТМЫ-МЕТОДЫ:
    public static Integer min(int [] array,int size) {      //метод для высчитывания минимального элемента
        int minimum = array[0];
        for (int j = 0; j < size; j++) {
            if (array[j] <= minimum) minimum = array[j];
        }
        return minimum;
    }
    public static Integer max(int [] array,int size) {       //метод для высчитывания максимального элемента
        int maximum = array[0];
        for (int j = 0; j < size; j++) {
            if (array[j] >= maximum) maximum = array[j];
        }
        return maximum;
    }
    public static boolean proverka(int [] array,int size){     //метод для проверки хотя бы одного совпадения при вводе
        int k=0;
        for (int j=0;j<size;j++){
            for(int i=j+1;i<size;i++){
                if (array[i]==array[j])
                    k++;
            }
        }
        return k == 0;
    }
    public static boolean check(int [] array,int size){     //метод для проверки условия "все ли нули?" при вводе
        int k=0;
        for (int j=0;j<size;j++){
            if (array[j]==0)
                k++;
        }
        return k != size;
    }
    public static void printMiddles(int[] array, int size) {//метод для вывода всех т.н. "средних" чисел
        System.out.println("Средние числа:");
        for (int i = 0; i < size; i++) {
            if ((array[i] != min(array, size) && (array[i] != max(array, size))))
                System.out.println(array[i]);
        }
    }
}