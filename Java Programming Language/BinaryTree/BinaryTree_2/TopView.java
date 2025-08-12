/*
 * TOP VIEW OF BINARY TREE
 * 
 * Algorithm:
 * 1. Assign horizontal distance (hd) to each node:
 *    - Root has hd = 0
 *    - Left child has hd = parent's hd - 1
 *    - Right child has hd = parent's hd + 1
 * 
 * 2. Use level order traversal to visit nodes level by level
 * 3. For each horizontal distance, keep only the FIRST node encountered (topmost)
 * 4. Print nodes from leftmost hd to rightmost hd
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

// Helper class to store node with its horizontal distance
class Info {
    Node node;
    int hd; // horizontal distance from root

    Info(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopView {

    public static void topView(Node root) {
        // Level order traversal using queue
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>(); // hd -> node mapping

        int min = 0, max = 0; // to track range of horizontal distances
        q.add(new Info(root, 0)); // start with root at hd = 0
        q.add(null); // level separator

        while (!q.isEmpty()) {
            Info curr = q.remove();
            
            // If current is null, we've finished a level
            if (curr == null) {
                if (q.isEmpty()) {
                    break; // no more levels to process
                } else {
                    q.add(null); // add separator for next level
                }
            } else {
                // If this hd is seen for first time, add to map
                if (!map.containsKey(curr.hd)) { // first time my hd is occurring
                    map.put(curr.hd, curr.node);
                }

                // Add left child with hd-1
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1); // update leftmost boundary
                }

                // Add right child with hd+1
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1); // update rightmost boundary
                }
            }
        }

        // Print nodes from leftmost to rightmost horizontal distance
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
         * Example Tree:
         *           1
         *         /   \
         *        2     3
         *       / \   / \
         *      4   5 6   7
         *             \
         *              8
         * 
         * Horizontal Distance (hd) assignment:
         * Node 1: hd = 0 (root)
         * Node 2: hd = -1, Node 3: hd = 1
         * Node 4: hd = -2, Node 5: hd = 0, Node 6: hd = 0, Node 7: hd = 2
         * Node 8: hd = 1
         * 
         * Top View should be: 4 2 1 3 7 (first node seen at each hd)
         */

        // Build the first example tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("Binary Tree Top View:");
        topView(root);

        System.out.println("\n==================================================");

        /*
         * Another Example:
         *       20
         *      /  \
         *     8   22
         *    / \    \
         *   5  3    25
         *     / \
         *   10  14
         * 
         * Top View: 5 8 20 22 25
         */
        
        // Build the second example tree
        Node root2 = new Node(20);
        root2.left = new Node(8);
        root2.right = new Node(22);
        root2.left.left = new Node(5);
        root2.left.right = new Node(3);
        root2.right.right = new Node(25);
        root2.left.right.left = new Node(10);
        root2.left.right.right = new Node(14);

        System.out.println("Second Tree Top View:");
        topView(root2);
    }
}
