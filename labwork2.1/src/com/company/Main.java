package com.company;
class Fraction {
    int numerator;
    int divider;

    public Fraction(int num, int div) {
        numerator= num;
        divider= div;

    }
    public void print(){
        System.out.println(numerator+"/"+divider);
    }
    public static void main(String[] args){
        System.out.println("asddff");
        Fraction f1,f2;
        f1=new Fraction(1,2);
        f1.print();
    }
}
