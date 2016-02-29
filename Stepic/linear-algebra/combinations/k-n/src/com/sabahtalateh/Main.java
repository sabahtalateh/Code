package com.sabahtalateh;

import java.util.*;

public class Main {

    public static Set<List<Integer>> combinations;

    public static void main(String[] args) {
        int k = 5;
        int n = 3;

        combinations = new HashSet<>();

        int[] p = new int[n];
        int[] b = setBorders(k, n);
        setPointers(p, 0, 0);

        findCombinations(p, b, p.length - 1);

        System.out.println(combinations);
        System.out.println(combinations.size());

//        do {
//            System.out.println(Arrays.toString(p));
//
//        } while (p[0] <= b[0]);

//        System.out.println(Arrays.toString(p));
//        System.out.println(Arrays.toString(b));
    }

    private static void findCombinations(int[] p, int[] borders, int currentPointer) {
//        System.out.println(currentPointer);
//        System.out.println(p[currentPointer]);

//        System.out.println(Arrays.toString(p));

        List<Integer> comb = new ArrayList<>();
        for (int el : p) {
            comb.add(el);
        }
        combinations.add(comb);

        if (p[0] == borders[0]) {
            return;
        }

        // Если текущий указатель достиг границы
        if (p[currentPointer] == borders[currentPointer]) {
            currentPointer -= 1;
            setPointers(p, currentPointer, ++p[currentPointer]);
            findCombinations(p, borders, currentPointer);
        }

        // Если есть след. указатель
        if (currentPointer < p.length - 1) {
            currentPointer += 1;
            findCombinations(p, borders, currentPointer);

        } else {
            p[currentPointer] += 1;
            findCombinations(p, borders, currentPointer);
        }
    }


    public static int[] setBorders(int k, int n) {
        int[] b = new int[n];
        int c = 0;
        for (int i = k - n; i < k; i++) {
            b[c] = i;
            c++;
        }
        return b;
    }

    public static void setPointers(int[] p, int position, int element) {
        for (int i = position; i < p.length; i++) {
            p[i] = element++;
        }
    }
}
