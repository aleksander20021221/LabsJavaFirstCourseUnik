package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args)  {
        String s= "4 2 3 + * 5 1 2 + * +";
        String[] strArray;
        strArray= s.split(" ");
        ArrayList <String>list = new ArrayList();
        for(int i = 0; i < strArray.length; i++) {
            list.add(strArray[i]);
        }
        System.out.println(list);
        Stack<String>numbers = new Stack<>();

        for(int i = 0; i < strArray.length; i++) {
            numbers.push(strArray[i]);
            processing(numbers);

        }
        System.out.println("jgngj   "+numbers.pop());

    }
    private static boolean isNumber(String string){
        if ((string!="+")&&(string!="-")&&(string!="*")&&(string!="/"))
            return true;
        else return false;
    }
    private static boolean isSign(String string){
        if ((string=="+")||(string=="-")||(string=="*")||(string=="/"))
            return true;
        else return false;
    }

private static void processing (Stack<String> stack) {
    if (stack.size()>=3) {
        String tmp1 = stack.pop();
        String tmp2 = stack.pop();
        String tmp3 = stack.pop();
        int k;
        if ((isSign(tmp1) == true) && (isNumber(tmp2) == true) && (isNumber(tmp3) == true)) {
            System.out.println("YES");
            if (tmp1=="+") {
                k=(Integer.parseInt(tmp3)) + (Integer.parseInt(tmp2));
                System.out.println(k);
                stack.push(String.valueOf(k));
            }
            if (tmp1=="-") {
                k=(Integer.parseInt(tmp3)) - (Integer.parseInt(tmp2));
                System.out.println(k);
                stack.push(String.valueOf(k));
            }
            if (tmp1=="*") {
                k=(Integer.parseInt(tmp3)) * (Integer.parseInt(tmp2));
                System.out.println(k);
                stack.push(String.valueOf(k));
            }
            if (tmp1=="/") {
                k=(Integer.parseInt(tmp3)) / (Integer.parseInt(tmp2));
                System.out.println(k);
                stack.push(String.valueOf(k));
            }
            }
        else {
            stack.push(tmp3);
            stack.push(tmp2);
            stack.push(tmp1);
        }
        }
    }
}


