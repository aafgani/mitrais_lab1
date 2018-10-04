package com.mitrais.lab1others;

public class Binary {
    public  static void main(String args[]){
        int num = 156;
        String binary = calcBinary(num);
        System.out.println(String.format("%d = %s",num,binary));
    }

    private static String calcBinary(int n) {
        String s = "";
        while (n > 0)
        {
            s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
            n = n / 2;
        }
        return s;
    }
}
