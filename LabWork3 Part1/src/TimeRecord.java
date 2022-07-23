import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;
public class TimeRecord{
                                    //сортировка Хоара (быстрая)
    private static void quickSort(int[] array, int left, int right) {
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
                                    //сортиовка пузырьком
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int a = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = a;
                }
            }
        }
    }
    public static void main(String[] args) {
    int[] arrayOfNumbers = new int[100000];
    Random randomizer = new Random(1000000);
    for (int i = 0; i < arrayOfNumbers.length; i++) {
        arrayOfNumbers[i] = randomizer.nextInt();
    }
    long startTime = System.currentTimeMillis();
    quickSort(arrayOfNumbers,0, arrayOfNumbers.length-1);
    long stopTime = System.currentTimeMillis();
    System.out.println("Elapsed time for quick sorting was " + (stopTime - startTime) + " miliseconds.");

    long startTime2 = System.currentTimeMillis();
    bubbleSort(arrayOfNumbers);
    long stopTime2 = System.currentTimeMillis();
    System.out.println("Elapsed time for bubble sorting was " + (stopTime2 - startTime2) + " miliseconds.");

    long difference= (stopTime-startTime)-(stopTime2-startTime2);
    if (difference>0) System.out.println("Сортировка пузырьком оказалась быстрее в результате однократного тестирования");
    if (difference<0) System.out.println("Сортировка Хоара (быстрая) оказалась быстрее в результате однократного тестирования");
    else System.out.println("В результате однократного тестровния оба вида сортировки заняли одинаковое количетсво времени");
}
}
