package com.manju.interview.questions;

import java.util.*;
import java.util.stream.Collectors;

public class FicoTest {
    /*
    *
    *
    *
        list of integers

        Input    -> [ 3, 456, 23190, 87, 9 ]
        Output -> [ 9, 87, 456, 3, 23190 ]

        Input    -> [ 1135, 25, 789, 456, 89, 9882 ]
        Output -> [ 98812, 89, 789, 456, 25, 135 ]

        Input    -> [ 35699, 36, 13, 9, 8 ]
        Output -> [ 9, 8, 36, 35699, 13 ]
*
*/

    public static void main(String[] args) {
        System.out.println(print(List.of(3, 456, 23190, 87, 9)));
        System.out.println(print(List.of(135, 25, 789, 456, 89, 98812)));
        System.out.println(print(List.of(35699, 36, 13, 9, 8)));

//        output
        //[9, 87, 456, 3, 23190]
        //[98812, 89, 789, 456, 25, 135]
        //[9, 8, 36, 35699, 13]

    }

    public static List<String> print(List<Integer> elements) {
        if (Objects.isNull(elements) || elements.isEmpty()) {
            return Collections.emptyList();
        }
        return elements.stream()
                       .map(ele -> String.valueOf(ele))
                       .sorted((l, r) -> {
                           char[] leftChars = l.toCharArray();
                           char[] rightChars = r.toCharArray();
                           int length = leftChars.length > rightChars.length ? rightChars.length : leftChars.length;
                           for (int i = 0; i < length; i++) {
                               if (leftChars[i] != rightChars[i]) {
                                   return Character.valueOf(rightChars[i])
                                                   .compareTo(Character.valueOf(leftChars[i]));
                               }
                           }
                           return r.compareTo(l);
                       })
                       .collect(Collectors.toList());

    }


}
