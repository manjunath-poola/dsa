package com.manju.interview.questions.leetcode;

public class AsciiValue {

    public static void main(String[] args) {

        char ch = '-';
        int ascii = ch;
        // You can also cast char to int
        int castAscii = (int) ch;

        System.out.println("The ASCII value of " + ch + " is: " + ascii);
        System.out.println("The ASCII value of " + ch + " is: " + castAscii);
    }
}