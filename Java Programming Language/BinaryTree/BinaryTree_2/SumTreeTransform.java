/*
 * TRANSFORM BINARY TREE TO SUM TREE
 *
 * In a sum tree, each node contains the sum of the values of its left and right subtrees in the original tree.
 * Leaf nodes are set to 0.
 *
 * Algorithm:
 * 1. Recursively transform left and right subtrees to sum trees.
 * 2. For each node, store the old value, set node's value to sum of left and right subtree sums.
 * 3. Return the sum of the node's old value and its left/right subtree sums to parent.
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

public class SumTreeTransform {

    // Transform tree to sum tree and return sum of subtree (including original node value)
    public static int toSumTree(Node root) {
        if (root == null) return 0;
        int oldValue = root.data;
        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);
        root.data = leftSum + rightSum;
        return root.data + oldValue;
    }
    // Alternative method to transform tree to sum tree
    public static int toSumTree1(Node root) {
    if (root == null) return 0;

    int leftchild = toSumTree1(root.left);
    int rightchild = toSumTree1(root.right);
    int leftData = (root.left != null) ? root.left.data : 0;
    int rightData = (root.right != null) ? root.right.data : 0;
    int data = root.data;
    root.data = leftchild + rightchild + leftData + rightData;
    return data;
}

    // Inorder traversal to print tree
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Pretty print the tree structure
    public static void printTree(Node root, String prefix, boolean isLeft) {
        if (root == null) return;
        if (root.right != null) {
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + root.data);
        if (root.left != null) {
            printTree(root.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        /*
         * Example Tree:
         *           1
         *         /   \
         *        2     3
         *       / \   / \
         *      4   5 6   7
         *
         * After sum tree transform:
         *           27
         *         /    \
         *       9      13
         *      / \    / \
         *     0   0  0   0
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Inorder traversal before sum tree transform:");
        inorder(root);
        System.out.println();

        System.out.println("\nTree structure before sum tree transform:");
        printTree(root, "", true);

        toSumTree(root);

        System.out.println("\nTree structure after sum tree transform:");
        printTree(root, "", true);
    }
}
