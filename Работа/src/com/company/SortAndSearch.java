package com.company;
import java.util.*;
public class SortAndSearch {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        operationsWithArray myArray = new operationsWithArray(5,0,100);
        System.out.println("Вот ваш случайный массив: ");
        System.out.println(myArray);
        System.out.println("Вот ваш отсортированный массив: ");
        myArray.selectionSort();
        System.out.println("Какой элемент хотите найти?");
        int usersInput = scn.nextInt();
        System.out.println("Вот индекс искомого элемента: " + myArray.binarySearch(usersInput));
    }
}
