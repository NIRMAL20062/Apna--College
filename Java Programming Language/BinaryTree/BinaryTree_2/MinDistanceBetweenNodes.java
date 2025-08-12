/*
 * MINIMUM DISTANCE BETWEEN TWO NODES IN BINARY TREE
 *
 * Algorithm:
 * 1. Find the Lowest Common Ancestor (LCA) of the two nodes.
 * 2. Find the distance from LCA to each node.
 * 3. The minimum distance is the sum of these two distances.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class MinDistanceBetweenNodes {

    // Find LCA of two nodes
    public static Node findLCA(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // Find distance from root to target node
    public static int findDistance(Node root, int target) {
        if (root == null) return -1;
        if (root.data == target) return 0;
        int leftDist = findDistance(root.left, target);
        int rightDist = findDistance(root.right, target);
        if (leftDist != -1) return leftDist + 1;
        if (rightDist != -1) return rightDist + 1;
        return -1;
    }

    // Find minimum distance between two nodes
    public static int minDistance(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);
        if (lca == null) {
            System.out.println("One or both nodes not found in the tree.");
            return -1;
        }
        int d1 = findDistance(lca, n1);
        int d2 = findDistance(lca, n2);
        return d1 + d2;
    }

    public static void main(String[] args) {
        /*
         * Example Tree:
         *           1
         *         /   \
         *        2     3
         *       / \   / \
         *      4   5 6   7
         *     / \
         *    8   9
         *
         * minDistance(8, 9) = 2
         * minDistance(4, 6) = 3
         * minDistance(5, 7) = 4
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        System.out.println("Binary Tree Structure:");
        System.out.println("           1");
        System.out.println("         /   \\");
        System.out.println("        2     3");
        System.out.println("       / \\   / \\");
        System.out.println("      4   5 6   7");
        System.out.println("     / \\");
        System.out.println("    8   9");
        System.out.println();

        // Test cases
        System.out.println("Minimum distance between 8 and 9: " + minDistance(root, 8, 9)); // 2
        System.out.println("Minimum distance between 4 and 6: " + minDistance(root, 4, 6)); // 3
        System.out.println("Minimum distance between 5 and 7: " + minDistance(root, 5, 7)); // 4
        System.out.println("Minimum distance between 2 and 9: " + minDistance(root, 2, 9)); // 2
        System.out.println("Minimum distance between 8 and 3: " + minDistance(root, 8, 3)); // 4
        System.out.println("Minimum distance between 8 and 10: " + minDistance(root, 8, 10)); // -1 (not found)
    }
}
