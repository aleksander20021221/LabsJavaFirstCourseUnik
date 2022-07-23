package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class Fractions {
    int numerator;
    int denominator;
    Fractions(String s) {
        String str1 = s.substring(0, s.indexOf("/"));
        numerator = Integer.parseInt(str1);
        String str2 = s.substring(s.indexOf("/") + 1);
        denominator = Integer.parseInt(str2);
    }
    //поиск НОДа
    private int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        else
            return (greatestCommonDivisor (b, a % b));
    }
    //приведение дробей к стандартному виду
    void betterForm(){
        if (denominator!=0) {
            int c = numerator;
            byte sign;
            if (numerator*denominator<0)
                sign=-1;
            else sign=1;
            numerator = sign*Math.abs(numerator / greatestCommonDivisor(numerator, denominator));
            denominator = Math.abs(denominator / greatestCommonDivisor(c, denominator));
        }
    }
    //печать дроби
    void print() {System.out.println(numerator + "/" + denominator);}
                                     //сравнение двух дробей: больше ли дробь другой дроби
    private boolean compareBigger (Fractions f){
        return f.denominator * numerator > f.numerator * denominator;
    }
                                        //меньше ли текущая дробь-элемент массива- другого элемента
    private boolean compareLess (Fractions f){
        return f.denominator * numerator < f.numerator * denominator;
    }
                                                                 //равны ли две дроби
    private boolean compareEquality (Fractions f){
        return f.denominator*numerator==f.numerator*denominator;
    }
                                                                            //Quick sort
    private static void quickSort(Fractions[] f, int left, int right) {
        int i = left;
        int j = right;
        Fractions base = f[(i + j) / 2];
        do {
            while (f[i].compareLess(base)) {
                i++;
            }
            while (f[j].compareBigger(base)) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    Fractions tmp = f[i];
                    f[i] = f[j];
                    f[j] = tmp;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < right) {
            quickSort(f, i, right);
        }
        if (left < j) {
            quickSort(f, left,j);
        }
    }

    static Fractions sum(Fractions f, int c){
        f.numerator=f.numerator+c*f.denominator;
        return f;
    }
    //универсальный метод поиска в массиве всех индексов какого-либо его элемента

    private static ArrayList<Integer> indexesSearch(Fractions [] examinedArray, Fractions x){
        ArrayList<Integer> listOfIndexes= new ArrayList<>();
        for (int i=0; i<examinedArray.length;i++){
            if (examinedArray[i].compareEquality(x))
                listOfIndexes.add(i);
        }
        return listOfIndexes;
    }


    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Scanner inputStrings=new Scanner(System.in);
        System.out.println("Введите количестов элементов массива");
        int n= input.nextInt();
        System.out.println("Введите дроби через знак "+"/");
        Fractions[] arrayOfFractions = new Fractions[n];
        for (int i=0;i<arrayOfFractions.length;i++) {
            String fracInput = inputStrings.nextLine();
            arrayOfFractions[i] = new Fractions(fracInput);
        }
        ArrayList <String> theList=new ArrayList<>();
        for (Fractions j : arrayOfFractions) {
            theList.add((j.numerator + "/" + j.denominator));
        }
        System.out.println("Введенный массив дробей: "+theList);
                                                 //создание копии массива

        for (Fractions i : arrayOfFractions)
            i.betterForm();
        Fractions[] copyArrayOfFractions=arrayOfFractions.clone();
        quickSort(arrayOfFractions,0,arrayOfFractions.length-1);    //вызов быстрой сортировки

        ArrayList <String> theList2=new ArrayList<>();
        for (Fractions j : arrayOfFractions) {
            theList2.add((j.numerator + "/" + j.denominator));
        }
        System.out.println("Sorted массив дробей: "+theList2);
        Fractions min=arrayOfFractions[0];
        Fractions max=arrayOfFractions[arrayOfFractions.length-1];
                                                                             //поиск минимума/максимума в массиве
        System.out.print("min= ");
        min.print();
        System.out.print("max= ");
        max.print();
                                                                          //обработка индексов минимумов
        if (!min.compareEquality(arrayOfFractions[1]))
            System.out.println("Минимум один, его индекс "+indexesSearch(copyArrayOfFractions,min).toString());
        else
            System.out.println("Индексы минимума "+indexesSearch(copyArrayOfFractions,min).toString());
                                                                           //обработка индексов максимумов
        if (!max.compareEquality(arrayOfFractions[arrayOfFractions.length - 2]))
            System.out.println("Максимум один, его индекс "+indexesSearch(copyArrayOfFractions,max).toString());
        else
            System.out.println("Индексы максимума "+indexesSearch(copyArrayOfFractions,max).toString());

        //проверка наличия более одного различного элемента
        if (!min.compareEquality(max)) {
                                                                           //поиск в массиве индексов элементов, больших минимума на единицу
            Fractions frac=sum(min,1 );
            if ((indexesSearch(copyArrayOfFractions,frac).size()>0)&&(!frac.compareEquality(min)))
                System.out.println("Индексы элементов, на 1 больших минимума: "+indexesSearch(copyArrayOfFractions,frac).toString());
            else
                System.out.println("Элементов, на 1 больших минимума, не существует");

                                                                            //поиск индексов элементов, следующих по величине после минимального
            int i=1;
            while (arrayOfFractions[i].compareEquality(min))
                i++;
            System.out.println("Индексы элементов, следующих по величине после минимального: "+indexesSearch(copyArrayOfFractions,arrayOfFractions[i]).toString());
            //флажок для проверки наличия более двух различных элементов
            int y=0;
            if (!arrayOfFractions[i].compareEquality(max))
                y++;
                                                          //поиск индексов элементов, следующих по величине после следующих по величине после минимума
            if (y>0) {
                int k = i;
                while (arrayOfFractions[k].compareEquality(arrayOfFractions[i]))
                    k++;
                System.out.println("Индексы элементов, следующих по величине после следующих после минимума" + indexesSearch(copyArrayOfFractions, arrayOfFractions[k]).toString());
            }
                                                                                   //поиск индексов элементов, меньших максимума на единицу
            if (indexesSearch(copyArrayOfFractions, sum(max,-1)).size() == 0)
                System.out.println("Элементов, на 1 меньших максиммума, не существует");
            else
                System.out.println("Индексы элементов, на 1 меньших максимума: "+indexesSearch(copyArrayOfFractions,sum(max,-1)).toString());
                                                                      //поиск индексов элементов, предшествующих по величине максимуму
            int j = arrayOfFractions.length - 2;
            while (arrayOfFractions[j].compareEquality(max))
                j--;
            System.out.println("Индексы элементов, предшествующих по величине максимуму: "+indexesSearch(copyArrayOfFractions, arrayOfFractions[j]).toString());
                                                              //поиск индексов элементов, предшествующих по величине предшествующим перед максимумом
            if (y>0) {
                int l = j;
                while (arrayOfFractions[l].compareEquality(arrayOfFractions[j]))
                    l--;
                System.out.println("Индексы элементов, предшествующих по величине предшествующим перед максимумом"+indexesSearch(copyArrayOfFractions, arrayOfFractions[l]).toString());
            }
        }
    }
}

