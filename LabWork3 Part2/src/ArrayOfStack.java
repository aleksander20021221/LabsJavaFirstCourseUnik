import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
public class ArrayOfStack {
    int top;
    int size;
    int [] array;
    public ArrayOfStack(int n){
        size=n;
        top=-1;
        array= new int[size];
    }
    public boolean isEmpty(){
        return (top==-1);
    }
    public void push(int k){
        int i=++top;
        array[i]=k;
        System.out.println("Top is "+top);
    }
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        else {
            System.out.println("Top is " + top);
            return array[top--];
        }
    }
    public int pick(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            System.out.println("Top is "+top);
            return array[top];
        }
    }
                                               //метод печати всех элементов стека
    public void print(ArrayOfStack stack){
        ArrayList<Integer> list= new ArrayList<>();
        int []ar= new int[stack.array.length];
        for (int i=0;i<array.length;i++)
            list.add(stack.array[i]);
        System.out.println(list.toString());
    }
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        //System.out.println("Введите размер стека");
        //ArrayOfStack stack = new ArrayOfStack(input.nextByte());
        ArrayOfStack stack = new ArrayOfStack(5);
        stack.push(1);
        stack.push(5);
        stack.push(-4);
        stack.pick();
        stack.push(3);
        stack.push(-7);
        System.out.print("\n");
        for (int i=0;i<7;i++)
            stack.pop();
        stack.print(stack);
    }
}
