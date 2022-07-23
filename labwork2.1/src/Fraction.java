import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;
public class Fraction {
        int numerator;
        int denominator;
        Fraction(int num,int div) {
            numerator= num;
            denominator= div;
        }
        Fraction(String s) {
            String str1 = s.substring(0, s.indexOf("/"));
            numerator = Integer.parseInt(str1);
            String str2 = s.substring(s.indexOf("/") + 1, s.length());
            denominator = Integer.parseInt(str2);
        }
        //возведение целого числа в неотрицательную целую степень
        public static int pow(int value, int powValue) {
        if (powValue==0)
            return 1;
        if (powValue == 1)
            return value;
        else
            return value * pow(value, powValue - 1);
    }
        //поиск НОДа
        public int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        else
            return (greatestCommonDivisor (b, a % b));
    }
        //поиск НОКа
        public int leastCommonMultiple(int a, int b) {
            return a * (b / greatestCommonDivisor(a, b));
        }
        //приведение дробей к стандартному виду
        void betterForm(){
            if (denominator!=0) {
                int c = numerator;
                int sign=1;
                if ((numerator*denominator)<0) sign=-1;
                numerator = sign*numerator / greatestCommonDivisor(numerator, denominator);
                denominator = Math.abs(denominator / greatestCommonDivisor(c, denominator));
                if (denominator==1)
                    System.out.println(numerator);
                else print();
            }
        }
        //печать дроби
        void print() {System.out.println(numerator + "/" + denominator);}
        //умножение двух дробей
        void mult(Fraction f){
           numerator= numerator*f.numerator;
           denominator = denominator*f.denominator;
        }
        //разность двух дробей
        void difference (Fraction f){
            int c=denominator;
            denominator=leastCommonMultiple(c, f.denominator);
            numerator=numerator*(denominator/c)-f.numerator*(denominator/f.denominator);
        }
//        //сумма двух дробей
        void sum (Fraction f){
            int c=denominator;
            denominator=leastCommonMultiple(c, f.denominator);
            numerator=numerator*(denominator/c)+f.numerator*(denominator/f.denominator);
        }
        //частное двух дробей
        void division (Fraction f){
            numerator=numerator*f.denominator;
            denominator=denominator*f.numerator;
        }
        //возведение дроби в степень
        void power (int i){
            if (i>=0) {
                numerator = pow(numerator, i);
                denominator = pow(denominator, i);
            }
            else {
                int c=numerator;
                numerator = pow(denominator, -i);
                denominator= pow(c,-i);
            }
        }
        //взятие обратной дроби
        void inverse(){
            int c=numerator;
            numerator=denominator;
            denominator=c;
        }

        void sum (Fraction f,int c){
            f.numerator=f.numerator+c*f.denominator;
            f.denominator=f.denominator*c;
        }


        public void main(String[] args){
            Scanner input=new Scanner(System.in);
            Scanner inputStrings=new Scanner(System.in);
            System.out.println("Введите количестов элементов массива");
            int n= input.nextInt();
            System.out.println("Введите дроби через знак "+"/");
            Fraction[] arrayOfFractions = new Fraction[n];
            for (int i = 0; i < arrayOfFractions.length; i++) {
                String fracInput = inputStrings.nextLine();
                arrayOfFractions[i] = new Fraction(fracInput);
            }
            ArrayList <String> theList=new ArrayList<>();
            for (int i=0;i< arrayOfFractions.length;i++){
                theList.add((arrayOfFractions[i].numerator+"/"+arrayOfFractions[i].denominator).toString() );
            }
            System.out.println("Введенный массив дробей: "+theList);
            System.out.println("Сумма всех дробей в массиве: ");

            for (Fraction arrayOfFraction : arrayOfFractions) {
                sum(arrayOfFraction, 1);
                arrayOfFraction.print();
            }

        }
}
