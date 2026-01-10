package Hashing;

import java.util.HashSet;

class CountDistinct {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        HashSet<Integer> set = new HashSet<>();

        for (int x : arr) {
            set.add(x);   // duplicates get ignored automatically
        }

        System.out.println("Distinct count = " + set.size());
    }
}
