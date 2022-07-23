package com.company;
import java.util.ArrayList;
import java.util.Random;
public class operationsWithArray {
    private int quantity;
    private int bottom;
    private int top;
    private ArrayList<Integer> myArray = new ArrayList <>();
    private Random rnd = new Random();

    public operationsWithArray(int quantity, int bottom, int top) { //Задание случайного массива.
        this.quantity = quantity;
        this.bottom = bottom;
        this.top = top;
        if ( quantity > 0 && bottom <= top ) {
            for (int k = 0; k < quantity; k++) {
                this.myArray.add(k , rnd.nextInt(top-bottom)+bottom);
            }
        }
        else {
            System.out.println("Вы некорректно ввели значения. Попробуйте снова!:)");
        }
    }

    public void selectionSort() {//сортировка массива
        for(int k = 0; k < myArray.size(); k++) {
            int minimal = findMinElement(k);
            int index = findIndexOfMin(minimal);
            swap(k, index);
        }
        System.out.println(myArray);
    }

    private int findIndexOfMin(int theSmallest) {//поиск индекса минимального элемента
        int indexOfTheSmallest = -1;
        for(int k = 0; k < myArray.size(); k++) {
            if (myArray.get(k) == theSmallest) {
                indexOfTheSmallest = k;

            }
        }
        return indexOfTheSmallest;
    }

    public String toString() {//вывод массива
        String myStr = "";
        for(int k = 0; k < myArray.size(); k++) {
            myStr = myStr + " " + myArray.get(k);
        }
        return myStr;

    }

    private int findMinElement(int myIndex) {//поиск минимального элемента с определённого индекса
        int min = myArray.get(myIndex);
        for (int k = myIndex; k < myArray.size(); k++) {
            if (myArray.get(k) < min) {
                min = myArray.get(k);

            }
        }
        return min;
    }

    private void swap(int index1, int index2) {//меняет значения элементов маасива под индексами "индекс1" и "индекс2"
        int c;
        c = myArray.get(index1);
        myArray.set(index1, myArray.get(index2));
        myArray.set(index2, c);
    }

    public int binarySearch(int element) {//поиска индекса заданного элемента в отсортированном массиве
        int indexOfElement = -1;
        int start = 0;
        int end = myArray.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(myArray.get(mid) == element) {
                indexOfElement = mid;
                break;
            }
            if(myArray.get(mid) < element) {
                start = mid+1;
            }
            if(myArray.get(mid) > element) {
                end = mid-1;
            }
        }
        return indexOfElement;
    }
}
