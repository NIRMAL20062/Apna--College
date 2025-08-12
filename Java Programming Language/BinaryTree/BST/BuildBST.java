/*
 * BUILD A BINARY SEARCH TREE (BST) FROM AN ARRAY OF VALUES
 *
 * This code provides:
 * - Node class for BST
 * - Insert function to build BST
 * - Inorder traversal to print BST in sorted order
 * - Example usage in main
 */

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BuildBST {

    // Insert a value into BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Build BST from array
    public static Node buildBST(int[] arr) {
        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        return root;
    }

    // Inorder traversal (prints BST in sorted order)
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Pretty print the BST structure
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
        // Example array to build BST
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        Node root = buildBST(arr);

        System.out.println("Inorder traversal of BST:");
        inorder(root);
        System.out.println();

        System.out.println("\nBST structure:");
        printTree(root, "", true);
    }
}
