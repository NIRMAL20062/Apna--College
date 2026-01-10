package Hashing;

import java.util.HashSet;

class UnionIntersection {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        int[] b = {3, 4, 5, 6};

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for (int x : a) {
            set.add(x);
        }

        for (int x : b) {
            if (set.contains(x)) {
                intersection.add(x);
            }
        }

        System.out.println("Intersection: " + intersection);
    }
}
