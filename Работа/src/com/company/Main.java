package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void min(String[] args) {
	// write your code here
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> myArray = operationsWithArray(10,0,100);
        System.out.println("Вот ваш случайный массив: ");
        System.out.println(myArray);
        System.out.println("Вот ваш отсортированный массив: ");
        selectionSort(myArray);
        System.out.println("Какой элемент хотите найти?");
        int usersInput = scn.nextInt();
        System.out.println("Вот индекс искомого элемента: " + binarySearch(usersInput,myArray));
    }

        public static ArrayList<Integer> operationsWithArray(int quantity, int bottom, int top) { //Задание случайного массива.
            Random rnd = new Random();
            ArrayList<Integer> myArray = new ArrayList<>();
            if ( quantity > 0 && bottom <= top ) {
                for (int k = 0; k < quantity; k++) {
                    myArray.add(k , rnd.nextInt(top-bottom)+bottom);
                }
            }
            else {
                System.out.println("Вы некорректно ввели значения. Попробуйте снова!:)");
            }
            return myArray;
        }

        public static void selectionSort(ArrayList<Integer> myArray) {//сортировка массива
            for(int k = 0; k < myArray.size(); k++) {
                int minimal = findMinElement(k,myArray);
                int index = findIndexOfMin(minimal,myArray);
                swap(k, index,myArray);
            }
            System.out.println(myArray);
        }

        private static int findIndexOfMin(int theSmallest, ArrayList<Integer> myArray) {//поиск индекса минимального элемента
            int indexOfTheSmallest = -1;
            for(int k = 0; k < myArray.size(); k++) {
                if (myArray.get(k).equals(theSmallest)) {
                    indexOfTheSmallest = k;

                }
            }
            return indexOfTheSmallest;
        }

//        public String toString() {//вывод массива
//            String myStr = "";
//            for(int k = 0; k < myArray.size(); k++) {
//                myStr = myStr + " " + myArray.get(k);
//            }
//            return myStr;
//        }

        private static int findMinElement(int myIndex, ArrayList<Integer> myArray) {//поиск минимального элемента с определённого индекса
            int min = myArray.get(myIndex);
            for (int k = myIndex; k < myArray.size(); k++) {
                if (myArray.get(k) < min) {
                    min = myArray.get(k);

                }
            }
            return min;
        }

        private static void swap(int index1, int index2, ArrayList<Integer> myArray) {//меняет значения элементов маасива под индексами "индекс1" и "индекс2"
            int c = myArray.get(index1);
            myArray.set(index1, myArray.get(index2));
            myArray.set(index2, c);
        }

        public static int binarySearch(int element, ArrayList<Integer> myArray) {//поиска индекса заданного элемента в отсортированном массиве
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
