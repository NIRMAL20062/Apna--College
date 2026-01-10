package Hashing;

import java.util.*;

public class TreeSetBasics {

    public static void main(String[] args) {

        // Create TreeSet
        TreeSet<Integer> ts = new TreeSet<>();

        // 1. Add elements
        ts.add(10);
        ts.add(5);
        ts.add(20);
        ts.add(10);   // duplicate ignored
        ts.add(15);

        // 2. Display elements (sorted automatically)
        System.out.println("TreeSet elements:");
        for (int val : ts) {
            System.out.println(val);
        }

        // 3. Basic operations
        System.out.println("First element: " + ts.first());
        System.out.println("Last element: " + ts.last());

        // 4. Search
        System.out.println("Contains 15? " + ts.contains(15));

        // 5. Remove element
        ts.remove(5);

        // 6. Size
        System.out.println("Size: " + ts.size());

        // 7. Range operations
        System.out.println("HeadSet (<15): " + ts.headSet(15));
        System.out.println("TailSet (>=15): " + ts.tailSet(15));
        System.out.println("SubSet (10 to 20): " + ts.subSet(10, 20));
    }
}
