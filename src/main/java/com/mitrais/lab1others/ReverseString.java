package com.mitrais.lab1others;

public class ReverseString {
    public static void main(String args[]){
        String str = "ANDRYA AFGANI";
        String reversed = reverseString(str);
        System.out.println(reversed);
    }

    private static String reverseString(String str) {
        if ((str==null)||(str.length()<=1)){
            return  str;
        }
        System.out.println(str.substring(1));
        return reverseString(str.substring(1))+str.charAt(0);
    }
}

