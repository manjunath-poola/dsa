package com.manju.interview.questions.leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        if (x == 0 && x > Integer.MAX_VALUE && x < Integer.MIN_VALUE) {
            return 0;
        }
        String strNum = String.valueOf(x);
        StringBuilder newNum = new StringBuilder();
        int startIndex = strNum.charAt(0) == '-' ? 1 : 0;
        if (1 == startIndex) {
            newNum.append("-");
        }
        for (int i = strNum.length() - 1; i >= startIndex; i--) {
            newNum.append(strNum.charAt(i));
        }

        try {
            return Integer.parseInt(newNum.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
//        System.out.println(reverse(9646324351 ));
    }
}