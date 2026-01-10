package Hashing;

import java.util.HashSet;

class Union {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 5, 6};

        HashSet<Integer> union = new HashSet<>();

        for (int x : a) union.add(x);
        for (int x : b) union.add(x);

        System.out.println("Union: " + union);
    }
}
