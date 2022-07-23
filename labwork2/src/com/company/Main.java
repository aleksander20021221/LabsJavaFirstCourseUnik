package com.company;
import java.lang.String;
import java.util.*;
public class Main {
    public static void main(String[] args) {
	// write your code here
        System.out.println("Введите количество элементов массива");
        Scanner input= new Scanner (System.in);
        int n=input.nextInt();
        System.out.println("если Вы хотите ввести массив вручную, введите 0, если рандомно- введите 1");
        byte choice=input.nextByte();
        int [] arrayOfNumbers= new int [n];
        //ввод массива вручную
        if (choice==0){
            System.out.println("Введите числа");
            for (int i = 0; i < n; i++) arrayOfNumbers[i] = input.nextInt();
            String numbersString =Arrays.toString((arrayOfNumbers));
            System.out.println("Введенный массив: "+numbersString);
        }
        //ввод с использованием рандомайзера
        if (choice==1){
            System.out.println("введите нижнюю границу диапазона");
            int low=input.nextInt();
            System.out.println("введите верхнюю границу диапазона");
            int high=input.nextInt();
            int diff = high - low;
            Random randomizer = new Random();
            for (int i = 0; i < n; i++) {
                    arrayOfNumbers[i] = randomizer.nextInt(diff+1)+low;
            }
            String numbersString =Arrays.toString((arrayOfNumbers));
            System.out.println("Введенный массив: "+numbersString);
        }
        System.out.println("Выберите способ обработки массива. \nПервый- с помощью сортировки. Введите 1.\nВторой-с помощью сокращения массива. Нажмите 2.\nТретий-с помощью библиотечных функций. Нажмите 3.");
        int m=input.nextInt();
        if (m==1)
            theFirstWay(arrayOfNumbers);
        if (m==2)
            theSecondWay(arrayOfNumbers);
        if (m==3)
            theThirdWay(arrayOfNumbers);
    }
    //метод сортировки массива разбиением Хоара
    public static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[(i + j) / 2];
        do {
            while (array[i] < base) {
                i++;
            }
            while (array[j] > base) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < right) {
            quickSort(array, i, right);
        }
        if (left < j) {
            quickSort(array, left,j);
        }
    }



    //универсальный метод поиска в массиве всех индексов какого-либо его элемента
    public static ArrayList<Integer> indexesSearch(int [] examinedArray, int x){
        ArrayList<Integer> listOfIndexes= new ArrayList<>();
        for (int i=0; i<examinedArray.length;i++){
            if (examinedArray[i]==x)
                listOfIndexes.add(i);
        }
        return listOfIndexes;
    }


    //первый способ обработки массива- с сортировкой
    public static void theFirstWay(int[] arr){
        //создание копии массива
        int [] arrCopy= arr.clone();
        //вызов быстрой сортировки массива
        quickSort(arr,0,arr.length-1);
        //поиск минимума/максимума в массиве
        System.out.println("min= "+arr[0]+" max= "+arr[arr.length-1]);
        //обработка индексов минимумов
        if (arr[0]!=arr[1])
            System.out.println("Минимум один, его индекс "+indexesSearch(arrCopy,arr[0]).toString());
        else
            System.out.println("Индексы минимума "+indexesSearch(arrCopy,arr[0]).toString());
        //обработка индексов максимумов
        if (arr[arr.length-1]!=arr[arr.length-2])
            System.out.println("Максимум один, его индекс "+indexesSearch(arrCopy,arr[arr.length-1]).toString());
        else
            System.out.println("Индексы максимума "+indexesSearch(arrCopy,arr[arr.length-1]).toString());

        //проверка наличия более одного различного элемента
        if (arr[0]!=arr[arr.length-1]) {
        //поиск индексов элементов, больших минимума на единицу  в массиве
        if (indexesSearch(arrCopy,arr[0]+1).size()==0)
            System.out.println("Элементов, на 1 больших минимума, не существует");
        else
            System.out.println("Индексы элементов, на 1 больших минимума: "+indexesSearch(arrCopy,arr[0]+1).toString());
        //поиск индексов элементов, следующих по величине после минимального
        int i=0;
        while (arr[i]==arr[0])
            i++;
        System.out.println("Индексы элементов, следующих по величине после минимального: "+indexesSearch(arrCopy,arr[i]).toString());
        //счетчик для проверки наличия более двух различных элементов
        int y=0;
        for (int x=1;x<arr.length-1;x++)
            if ((arr[x]!=arr[0])&&(arr[x]!=arr[arr.length-1]))
                y++;
        //поиск индексов элементов, следующих по величине после следующих по величине после минимума
        if (y>0) {
            int k = i;
            while (arr[k] == arr[i])
                k++;
            System.out.println("Индексы элементов, следующих по величине после следующих после минимума" + indexesSearch(arrCopy, arr[k]).toString());
        }
        //поиск индексов элементов, меньших максимума на единицу
        if (indexesSearch(arrCopy, arr[arr.length - 1] - 1).size() == 0)
            System.out.println("Элементов, на 1 меньших максиммума, не существует");
        else
            System.out.println("Индексы элементов, на 1 меньших максимума: " + indexesSearch(arrCopy, arr[arr.length - 1] - 1).toString());
        //поиск индексов элементов, предшествующих по величине максимуму
        int j = arr.length - 1;
        while (arr[j] == arr[arr.length - 1])
            j--;
        System.out.println("Индексы элементов, предшествующих по величине максимуму: " + indexesSearch(arrCopy, arr[j]).toString());
        //поиск индексов элементов, предшествующих по величине предшествующим перед максимумом
        if (y>0) {
            int l = arr.length - 1;
            while (arr[l] >= arr[j])
                l--;
            System.out.println("Индексы элементов, предшествующих по величине предшествующим перед максимумом" + indexesSearch(arrCopy, arr[l]).toString());
        }
        }
    }
    //второй способ обработки массива- с сокращением массива, без использования сортировки
    public static void theSecondWay(int[] theArr){
        //создаем копию массива в виде листа
        ArrayList<Integer>theArrList= new ArrayList<>();
        for (int j : theArr) theArrList.add(j);
        //создание копии листа для дальнейшего использования её в поиске максимумов
        ArrayList <Integer> copyTheArrList= new ArrayList<>(theArrList);
        //обработка всех видов минимумов с орининалом листа
        System.out.println("Минимум равен: "+min(theArrList));
        //корректная обработка минимума
        if (count(theArrList,min(theArrList))==1)
            System.out.println("Индекс минимума один: "+indexesSearch(theArr,min(theArrList)));
        else
            System.out.println("Индексы минимума: "+indexesSearch(theArr,min(theArrList)));
        //проверка нахождения в листе более одного различного элемента
        int y=0;
        for (int x=0;x<theArrList.size()-1;x++)
            if (!theArrList.get(x).equals(theArrList.get(0)))
                y++;
        int z=0;
        for (int x=1; x<theArrList.size()-2;x++)
            for(int w=2; w<theArrList.size()-1;w++)
                if ((!theArrList.get(0).equals(theArrList.get(x)))&&(!theArrList.get(x).equals(theArrList.get(w))))
                    z++;
        //поиск индексов элементов, на 1 больших минимума
        if (y>0) {
            if (count(theArrList, min(theArrList) + 1) > 0)
                System.out.println("Индексы элемента, на 1 большего минимума: " + indexesSearch(theArr, min(theArrList) + 1));
            else
                System.out.println("Элементов, на 1 больших минимума, не найдено");
            //очистка листа от предыдущих минимумов
            clear(theArrList, min(theArrList));
            //поиск элементов, следующих по величине после минимума
            System.out.println("Индексы элементов, следующих по величине после минимума: " + indexesSearch(theArr, min(theArrList)));
            clear(theArrList, min(theArrList));
            if (z>0)
                //поиск элементов, величина которых следует за величиной элементов после минимума
                System.out.println("Индексы элементов, следующих по значению после элементов после минимума: " + indexesSearch(theArr, min(theArrList)));
        }
        //обработка всех максимумов с созданной копией листа (из оригинала были удалены элементы)
        //все виды обработок аналогичны обработке минимумов
        System.out.println("Максимум равен: "+max(copyTheArrList));
        if (count(copyTheArrList,max(copyTheArrList))==1)
            System.out.println("Индекс максимума один: "+indexesSearch(theArr,max(copyTheArrList)));
        else
            System.out.println("Индексы максимума: "+indexesSearch(theArr,max(copyTheArrList)));
        if (y>0) {
            if (count(copyTheArrList, max(copyTheArrList) - 1) > 0)
                System.out.println("Индексы элемента, на 1 меньшего максимума: " + indexesSearch(theArr, max(copyTheArrList) - 1));
            else
                System.out.println("Элементов, на 1 меньших максимума, не найдено");
            clear(copyTheArrList, max(copyTheArrList));
            System.out.println("Индексы элементов, предыдущих по значению перед максимумом: " + indexesSearch(theArr, max(copyTheArrList)));
            clear(copyTheArrList, max(copyTheArrList));
            if (z>0)
                System.out.println("Индексы элементов, предыдущих по значению перед предыдущими перед максимумом: " + indexesSearch(theArr, max(copyTheArrList)));
        }
    }
    //третий способ обработки массива- с использованием библиотечных функций
    public static void theThirdWay(int[] massive){
        //преобразование массива в список
        ArrayList<Integer>massiveList= new ArrayList<>();
        for (int l : massive) massiveList.add(l);
        //поиск и обработка минимума и максимума в списке
        int rateMin=Collections.frequency(massiveList,Collections.min(massiveList));
        int rateMax=Collections.frequency(massiveList,Collections.max(massiveList));
        System.out.println("Минимум равен: "+Collections.min(massiveList));
        if  (rateMin==1)
            System.out.println("Минимум один, его индекс: "+indexesSearch(massive,Collections.min(massiveList)));
        else
            System.out.println("Индексы минимума: "+indexesSearch(massive,Collections.min(massiveList)));
        System.out.println("Максимум равен: "+Collections.max(massiveList));
        if (rateMax==1)
            System.out.println("Максимум один, его индекс: "+indexesSearch(massive,Collections.max(massiveList)));
        else
            System.out.println("Индексы максимума: "+indexesSearch(massive,Collections.max(massiveList)));
        //удаление дублирующихся элементов списка
        Set<Integer> set = new HashSet<>(massiveList);
        massiveList.clear();
        massiveList.addAll(set);
        //сортировка получившегося списка
        Collections.sort(massiveList);
        //обработка всех видов минимума
        if (massiveList.size()!=1) {
            if (massiveList.get(1) == massiveList.get(0) + 1)
                System.out.println("Индексы элементов, на 1 превосходящих минимум: " + indexesSearch(massive, massiveList.get(1)));
            else
                System.out.println("Элементов, на 1 превосходящих минимум, не найдено");
            System.out.println("Индексы минимального элемента, превосходящего минимум: " + indexesSearch(massive, massiveList.get(1)));
            if (massiveList.size()>2)
                System.out.println("Индексы минимального элемента, превосходящего минимальный элемент, превосходящего минимум: " + indexesSearch(massive, massiveList.get(2)));
        //делаем реверс листа для удобства
        Collections.reverse(massiveList);
        //обработка всех видов максимума
            if (massiveList.get(1) == massiveList.get(0) - 1)
                System.out.println("Индексы элементов, на 1 меньших максимума: " + indexesSearch(massive, massiveList.get(1)));
            else
                System.out.println("Элементов, на 1 меньших максимум, не найдено");
            System.out.println("Индексы максимального элемента, не равняющегося максимуму: " + indexesSearch(massive, massiveList.get(1)));
            if (massiveList.size()>2)
                System.out.println("Индексы максимального элемента, не равняющегося максимуму и его предшественнику: " + indexesSearch(massive, massiveList.get(2)));
        }
    }
    public static int min(ArrayList<Integer>newList){
        int m=newList.get(0);
        for (Integer integer : newList) {
            if (integer < m)
                m = integer;
        }
        return m;
    }
    public static int max(ArrayList<Integer>newList){
        int m=newList.get(0);
        for (Integer integer : newList) {
            if (integer > m)
                m = integer;
        }
        return m;
    }
    public static void clear(ArrayList<Integer>newList,int c){
        for (int i=0;i<newList.size();i++)
            if (newList.get(i)==c)
                newList.remove(i);
    }
    //считает кол-во повторений элемента
    public static int count(ArrayList<Integer>newList,int c){
        int d=0;
        for (Integer integer : newList) {
            if (integer == c)
                d++;
        }
        return d;
    }
}
