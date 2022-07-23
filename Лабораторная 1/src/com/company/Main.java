package com.company;
import java.lang.String;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {
//главный метод:
    public static void main(String[] args) {
        System.out.println("введите количество чисел");
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        System.out.println("введите диапазон");
        int m=input.nextInt();
        if (n>0){
            int[] randomArray =new int[n];
            Random rnd = new Random();
            for (int i = 0; i < n; i++) {
                randomArray[i] = rnd.nextInt(m);
            }
            String randomArrayString = Arrays.toString(randomArray);
            System.out.println("Числа в массиве сгенерированы "+randomArrayString);
            int[] numbers = new int[n];
            System.out.println("Введите числа");
            for (int i = 0; i < n; i++) numbers[i] = input.nextInt();
            String numbersString =Arrays.toString((numbers));
            System.out.println("Введенный массив: "+numbersString);
            if (oneMax(numbers,n)!=oneMin(numbers,n)) {
                System.out.println("Минимальное значение среди элементов: " + oneMin(numbers, n));
                System.out.println("Максимальное значение среди элементов: " + oneMax(numbers, n));
                manyMinAndMax(numbers, n);
                minAndMaxPlusMinusOne(numbers, n);
                indexesOfNumbersBeforeMinAndMax(numbers, n);
                afterBefore(numbers, n);
            }
            else System.out.println("Все введённые в массив числа оказались одинаковыми. Результат обработки некорректен.");
        }
    }

    //метод для вычисления минимума:
    public static int oneMin(int[] array, int size){
        int min=array[0];
        for (int i=0;i<size;i++){
            if (array[i]<=min) min=array[i];
        }
        return(min);
    }

    //метод для вычисления максимума:
    public static int oneMax(int[] array, int size){
        int max=array[0];
        for (int i=0;i<size;i++){
            if (array[i]>=max) max=array[i];
        }
        return(max);
    }

    //метод для вычисления индексов максимумов и минимумов:
    public static void manyMinAndMax(int[] array,int size){
        int min=array[0];
        int max=array[0];
        int k=0;
        int l=0;
        for (int i=0;i<size;i++){
            if (array[i]<=min) min=array[i];
            if (array[i]>=max) max=array[i];
        }
        for (int i=0;i<size;i++){
            if (array[i]<=min) k++;
            if (array[i]>=max) l++;
        }
        if (k==1)
            for (int i=0;i<size;i++){
                if (array[i]==min) System.out.println("минимум один, его индекс: "+i);
            }
        else if (k>1) {
            System.out.print("индексы минимумов: ");
            for (int i = 0; i < size; i++) {
                if (array[i] == min)
                    System.out.print(i+" ");
            }
            System.out.println("\n");
        }
        if (l==1)
            for (int i=0;i<size;i++){
                if (array[i]==max) System.out.println("максимум один, его индекс: "+i);
            }
        else if (l>1) {
            System.out.print("индексы максимумов: ");
            for (int i = 0; i < size; i++) {
                if (array[i] == max)
                    System.out.print(i+" ");
            }
            System.out.println("\n");
        }
    }
    //метод для высчитывания индексов элементов, на 1 меньших максимума и на 1 больших минимума
    public static void minAndMaxPlusMinusOne(int[] array, int size){
        int k=0;
        int l=0;
        for (int i=0; i<size;i++) {
            if (array[i]==oneMin(array, size)+1) {
                System.out.println("индекс элемента, на 1 большего минимума, равен: "+i);
                k++;
            }
        }
        if (k==0) System.out.println("элемента, на единицу большего минимума не найдено");
        for (int i=0; i<size;i++) {
            if (array[i]==oneMax(array, size)-1) {
                System.out.println("индекс элемента, на 1 меньшего максимума, равен: "+i);
                l++;
            }
        }
        if (l==0) System.out.println("элемента, на единицу меньшего максимума не найдено");
    }
    //метод для высчитывания элементов, предыдущих перед максимумом по значению
    public static int peredMax(int[] array,int size){
        int min=array[0];
        int max=array[0];
        for (int i=0;i<size;i++){
            if (array[i]<=min) min=array[i];
            if (array[i]>=max) max=array[i];
        }
        int beforeMax=min;
        for (int i=0;i<size;i++){
            if ((array[i]!=max)&&(array[i]>=beforeMax)) beforeMax=array[i];
        }
        return(beforeMax);
    }
    //метод для высчитывания элементов, следующих после минимумом по значению
    public static int posleMin(int[] array,int size){
        int min=array[0];
        int max=array[0];
        for (int i=0;i<size;i++){
            if (array[i]<=min) min=array[i];
            if (array[i]>=max) max=array[i];
        }
        int afterMin=max;
        for (int i=0;i<size;i++){
            if ((array[i]!=min)&&(array[i]<=afterMin)) afterMin=array[i];
        }
        return(afterMin);
    }

    public static void indexesOfNumbersBeforeMinAndMax(int[] array,int size){
        for (int i=0;i<size;i++) {
            if (array[i]==posleMin(array, size))
                System.out.println("Индекс элемента, следующего по величине после минимума, равен: " + i);
        }
        for (int i=0;i<size;i++) {
            if (array[i]==peredMax(array, size))
                System.out.println("Индекс элемента, предшествующего по величине максимуму, равен: " + i);
        }
    }
    //метод для распечатки индексов элементов, предыдущих перед предыдущими перед максимумом и последующих после
    //последующих после минимумом
    public static void afterBefore(int[] array,int size){
        int afterAfter=peredMax(array, size);
        int beforeBefore=posleMin(array, size);
        for (int i=0;i<size;i++){
            if ((array[i]!=oneMin(array, size))&&(array[i]!=posleMin(array, size)&&(array[i]<=afterAfter)))
                afterAfter=array[i];
        }
        for (int i=0;i<size;i++){
            if ((array[i]!=oneMax(array, size))&&(array[i]!=peredMax(array, size)&&(array[i]>=beforeBefore)))
                beforeBefore=array[i];
        }
        for (int i=0;i<size;i++) {
            if (array[i]==afterAfter)
                System.out.println("Индекс элемента, следующего по величине после следующего после минимума, равен: " + i);
        }
        for (int i=0;i<size;i++) {
            if (array[i]==beforeBefore)
                System.out.println("Индекс элемента, предшествующего предшествующему по величине максимуму, равен: " + i);
        }
    }
}
