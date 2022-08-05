package com.manju.interview.questions.leetcode;

public class ReverseIntegerOptimized {
    public static int reverse(int number) {
        int reverse = 0;
        while (number != 0) {
            int remainder = number % 10;
            number /= 10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            reverse = reverse * 10 + remainder;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345789));
    }
}