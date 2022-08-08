package com.manju.interview.questions;

public class EvilNum {
    public static void main(String args[]) {
        int i = 16;
//        if (binary(i) % 2 == 0) {
//            System.out.println(i + " is evil number");
//        } else {
//            System.out.println(i + " is not evil number");
//        }

        System.out.println(binaryToDecimal("10000"));
    }

    public static int binary(int i) {
        if (i == 0) {
            return i;
        }
        int count = 0;
        for (int num = i; num > 0; num = num / 2) {
            System.out.print(num % 2);
            if (num % 2 != 0) {
                // 10000  --> 0+1 decimal has to be taken from right to left
                // formula for conversion is 10000    (1 × 2⁴) + (0 × 2³) + (0 × 2²) + (0 × 2¹) + (0 × 2⁰)
                count++;
            }

        }
        System.out.println();
        return count;
    }

    public static int binaryToDecimal(String binaryStr){
        int val=0;
        int pow=0;
        for (int i=binaryStr.length()-1;i>=0;i--){
            val+= (Integer.parseInt(String.valueOf(binaryStr.charAt(i))))*Math.pow(2,pow++);
        }
        return val;
    }

}