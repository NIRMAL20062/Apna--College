/*
 * KTH ANCESTOR OF A NODE IN BINARY TREE
 *
 * Algorithm:
 * 1. Traverse the tree to find the target node.
 * 2. As you backtrack, increment the ancestor count.
 * 3. When the count reaches k, print or return the ancestor.
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

public class KthAncestor {

    // Classroom style kth ancestor function
    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data); // Print kth ancestor
        }
        return max + 1;
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
         * kthAncestor(9, 1) = 4
         * kthAncestor(9, 2) = 2
         * kthAncestor(9, 3) = 1
         * kthAncestor(6, 1) = 3
         * kthAncestor(6, 2) = 1
         * kthAncestor(6, 3) = -1 (doesn't exist)
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
        System.out.print("1st ancestor of 9: ");
        KAncestor(root, 9, 1); // 4
        System.out.print("2nd ancestor of 9: ");
        KAncestor(root, 9, 2); // 2
        System.out.print("3rd ancestor of 9: ");
        KAncestor(root, 9, 3); // 1
        System.out.print("4th ancestor of 9: ");
        KAncestor(root, 9, 4); // -1
        System.out.print("1st ancestor of 6: ");
        KAncestor(root, 6, 1); // 3
        System.out.print("2nd ancestor of 6: ");
        KAncestor(root, 6, 2); // 1
        System.out.print("3rd ancestor of 6: ");
        KAncestor(root, 6, 3); // -1
    }
}
