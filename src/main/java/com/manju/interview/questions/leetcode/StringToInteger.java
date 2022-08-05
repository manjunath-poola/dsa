package com.manju.interview.questions.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("45"));
    }

    public static int myAtoi(String s) {
        if (null == s || s.isEmpty() || s.isBlank()) {
            return 0;
        }
        String[] givenStr = s.trim()
                             .split(" ");
        StringBuilder numricChars = new StringBuilder();
        String str;
        try {
            str = givenStr[0];
            if (isInvalidNumber(str)) {
                return 0;
            }
            String[] dotStrArray = str.split("\\.");
            int j = 0;
            String intStr = dotStrArray[0].trim();
            if (dotStrArray.length > 1 && intStr.trim()
                                                .isEmpty()) {
                intStr = "0";
            }
            if (intStr.charAt(0) == '-' || intStr.charAt(0) == '+') {
                j = 1;
                if (intStr.charAt(0) == '-') {
                    numricChars.append("-");
                }
            }
            for (int i = j; i < intStr.length(); i++) {
                int ascii = intStr.charAt(i);
                if (!(ascii >= 48 && ascii <= 57)) {
                    break;
                } else {
                    numricChars.append(intStr.charAt(i));
                }

            }
            if (isInvalidNumber(numricChars.toString())) {
                return 0;
            }
            return Integer.parseInt(numricChars.toString());
        } catch (Exception e) {
            if (givenStr[0].charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }

        }

    }

    private static boolean isInvalidNumber(String str) {
        return (str.isBlank() || str.isEmpty() || (str.length() == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+')));
    }
}