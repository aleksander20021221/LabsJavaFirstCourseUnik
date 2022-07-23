package com.company;
import java.lang.String;
import java.util.Scanner;
public class Main {
    //Main Algorithm
    public static void main(String[] args) {
        System.out.println("Введите кол-во чисел");
        Scanner reader= new Scanner(System.in);
        int x= reader.nextInt();
        if (x>0) {
            int[] numbers = new int[x];
            System.out.println("Введите числа");
            for (int i = 0; i < x; i++) numbers[i] = reader.nextInt();
            while (checking(numbers, x)) {
                if (verification(numbers, x)) {
                    System.out.println("Минимальное число: "+ Min(numbers, x));
                            System.out.println("Максимальное число: "+ Max(numbers, x));
                                    middles(numbers, x);
                } else System.out.println("Плохие числа");
                for (int i = 0; i < x; i++) numbers[i] = reader.nextInt();
            }
            System.out.println("Успешно");
        }
        else System.out.println("Некорректный ввод");
    }
    //End of Main Algorithm
    //Methods:
    public static Integer Max(int [] array,int size) {    //Максимальный элемент
        int maximum = array[0];
        for (int m = 0; m < size; m++) {
            if (array[m] >= maximum) maximum = array[m];
        }
        return maximum;
    }
    public static Integer Min(int [] array,int size) {    //Минимальный элемент
        int minimum = array[0];
        for (int m = 0; m < size; m++) {
            if (array[m] <= minimum) minimum = array[m];
        }
        return minimum;
    }
    public static boolean checking(int [] array,int size){    //Проверка "все ли нули" при вводе
        int t=0;
        for (int m=0;m<size;m++){
            if (array[m]==0)
                t++;
        }
        return t != size;
    }
    public static boolean verification(int [] array,int size){    //Проверка хотя бы одного совпадения при вводе
        int t=0;
        for (int m=0;m<size;m++){
            for(int i=m+1;i<size;i++){
                if (array[i]==array[m])
                    t++;
            }
        }
        return t == 0;
    }
    public static void middles(int[] array, int size) {    //Вывод всех "средних чисел"
        System.out.println("Средние числа:");
        for (int i = 0; i < size; i++) {
            if ((array[i] != Min(array, size) && (array[i] != Max(array, size))))
                System.out.println(array[i]);
        }
    }
}