package com.hustlebar.microhustle.trial;

import java.util.*;

/**
 * @author tham
 */

public class Permutation {
    //123

    List<String> values = new ArrayList<>(8);
    Set<String> nonduplicates;

    public void permute(String value) {
        print(value, 0, value.length() - 1);

        Collections.sort(values);
        System.out.println(values);
        nonduplicates = new TreeSet<>(values);
//        System.out.println(nonduplicates);
//        System.out.println(nonduplicates.toArray()[49]);
    }

    private void print(String value, int l, int r) {
        if (l == r) {
            values.add(value);
        } else {
            for (int i = l; i <= r; i++) {
                value = swap(value, l, i);
                print(value, l + 1, r);
                value = swap(value, l, i);
            }
        }
    }

    private String swap(String value, int a, int b) {
        char temp;
        final char[] chars = value.toCharArray();
        temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;

        return String.valueOf(chars);
    }
}
