import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackList {
    static class Fractions{
        int numerator;
        int denominator;
        Fractions(String s) {
            String str1 = s.substring(0, s.indexOf("/"));
            numerator = Integer.parseInt(str1);
            String str2 = s.substring(s.indexOf("/") + 1);
            denominator = Integer.parseInt(str2);
        }
    }
    private List<Fractions> elements = new ArrayList<>();

    public void pop() {
        if (elements.size()==0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top is "+(elements.size()-1));
        elements.remove(elements.size() - 1);
    }

    public void push(Fractions element) {
        elements.add(element);
        System.out.println("Top is "+(elements.size()-1));
    }

    public static void main(String[] args) {
        Scanner inputStrings=new Scanner(System.in);
        StackList stack = new StackList();
        System.out.println("Stack is empty");
        System.out.println("Введите дроби через знак "+"/"+"\n"+"Закончите ввод, введя дробь с нулевым знаменателем.");
                                                    //ввод дробей
        String fracInput = inputStrings.nextLine();
        while (new Fractions(fracInput).denominator!=0){
            stack.push(new Fractions(fracInput));
            fracInput = inputStrings.nextLine();
        }
        ArrayList <String> theList=new ArrayList<>();
        for (int i=0;i<stack.elements.size();i++) {
            theList.add((stack.elements.get(i).numerator + "/" + stack.elements.get(i).denominator));
        }
        System.out.print("\n");
        System.out.println("Введенный стек из дробей: "+theList);
        System.out.print("\n");
        int k=stack.elements.size();
        for (int i=0; i<k+2; i++)
            stack.pop();
    }
}
