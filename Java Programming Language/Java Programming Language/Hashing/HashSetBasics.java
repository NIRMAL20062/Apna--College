package Hashing;

import java.util.*;

public class HashSetBasics {

    public static void main(String[] args) {

        // -----------------------------
        // 1. HashSet
        // -----------------------------
        HashSet<Integer> hs = new HashSet<>();

        // add elements
        hs.add(5);
        hs.add(1);
        hs.add(3);
        hs.add(5);   // duplicate ignored
        hs.add(2);

        System.out.println("HashSet elements:");
        for (int val : hs) {
            System.out.println(val);
        }

        // basic operations
        System.out.println("Contains 3? " + hs.contains(3));
        hs.remove(1);
        System.out.println("Size of HashSet: " + hs.size());

        // -----------------------------
        // 2. TreeSet
        // -----------------------------
        TreeSet<Integer> ts = new TreeSet<>();

        // add elements
        ts.add(5);
        ts.add(1);
        ts.add(3);
        ts.add(5);   // duplicate ignored
        ts.add(2);

        System.out.println("\nTreeSet elements (sorted):");
        for (int val : ts) {
            System.out.println(val);
        }

        // basic operations
        System.out.println("First: " + ts.first());
        System.out.println("Last: " + ts.last());
        System.out.println("Contains 3? " + ts.contains(3));

        ts.remove(1);
        System.out.println("Size of TreeSet: " + ts.size());
    }
}
