package com.sabahtalateh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static Set<List<Integer>> combinations;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s.split("\\s+");


        int n = Integer.parseInt(s.split("\\s+")[0]);
        int k = Integer.parseInt(s.split("\\s+")[1]);

        if (k == 0 || n == 0) {

        } else {

            combinations = new TreeSet<>(
                    Comparator.comparing(List::hashCode)
            );

            int[] p = new int[n];
            int[] b = setBorders(k, n);
            setPointers(p, 0, 0);

            findCombinations(p, b, p.length - 1);

            for (List<Integer> list : combinations) {
                for (Integer el : list) {
                    System.out.print(el + " ");
                }
                System.out.println();
            }
        }
    }

    private static void findCombinations(int[] p, int[] borders, int currentPointer) {

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
