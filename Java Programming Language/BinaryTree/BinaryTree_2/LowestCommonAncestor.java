/*
 * LOWEST COMMON ANCESTOR (LCA) OF BINARY TREE
 * 
 * This file contains 3 DIFFERENT METHODS to find LCA:
 * 
 * METHOD 1: BASIC RECURSIVE APPROACH
 * - Most efficient and commonly used
 * - Returns LCA directly during traversal
 * - Time: O(n), Space: O(h)
 * 
 * METHOD 2: SAFE APPROACH (WITH EXISTENCE CHECK)
 * - First checks if both nodes exist in tree
 * - Prevents incorrect results with non-existent nodes
 * - Time: O(n), Space: O(h)
 * 
 * METHOD 3: PATH-BASED APPROACH
 * - Finds paths from root to both nodes
 * - Compares paths to find last common node
 * - Time: O(n), Space: O(n)
 * 
 * Definition: The LCA of two nodes n1 and n2 is the deepest node that has 
 * both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
 */

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class LowestCommonAncestor {

    // ==================== METHOD 1: BASIC RECURSIVE APPROACH ====================
    /**
     * METHOD 1: Basic Recursive Approach
     * Finds the Lowest Common Ancestor of two nodes in binary tree
     * @param root The root of the binary tree
     * @param n1 First node value
     * @param n2 Second node value
     * @return The LCA node, or null if not found
     */
    public static Node findLCA(Node root, int n1, int n2) {
        // Base case: if root is null
        if (root == null) {
            return null;
        }

        // If root is either n1 or n2, then root is LCA
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively find LCA in left and right subtrees
        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        // If both left and right subtrees return non-null,
        // then root is the LCA (n1 and n2 are in different subtrees)
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only left subtree returns non-null, LCA is in left subtree
        if (leftLCA != null) {
            return leftLCA;
        }

        // If only right subtree returns non-null, LCA is in right subtree
        return rightLCA;
    }

    // ==================== METHOD 2: SAFE APPROACH (WITH EXISTENCE CHECK) ====================
    /**
     * METHOD 2: Safe Approach - First check if both nodes exist, then find LCA
     * This ensures both nodes are present in the tree
     */
    public static Node findLCASafe(Node root, int n1, int n2) {
        // First check if both nodes exist in the tree
        if (!nodeExists(root, n1) || !nodeExists(root, n2)) {
            System.out.println("One or both nodes don't exist in the tree");
            return null;
        }
        
        // If both exist, find LCA
        return findLCA(root, n1, n2);
    }

    // Helper method to check if a node exists in the tree
    private static boolean nodeExists(Node root, int value) {
        if (root == null) return false;
        if (root.data == value) return true;
        return nodeExists(root.left, value) || nodeExists(root.right, value);
    }

    // ==================== METHOD 3: PATH-BASED APPROACH ====================
    /**
     * METHOD 3: Using path arrays to store paths from root to nodes
     * Then find the last common node in both paths
     */		
    public static Node findLCAUsingPaths(Node root, int n1, int n2) {
        java.util.List<Node> path1 = new java.util.ArrayList<>();
        java.util.List<Node> path2 = new java.util.ArrayList<>();
        
        // Find paths from root to n1 and n2
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return null; // One or both nodes don't exist
        }
        
        // Find LCA by comparing paths
        Node lca = null;
        int minLength = Math.min(path1.size(), path2.size());
        
        for (int i = 0; i < minLength; i++) {
            if (path1.get(i).data == path2.get(i).data) {
                lca = path1.get(i);
            } else {
                break; // Paths diverge here
            }
        }
        
        return lca;
    }

    // Helper method to find path from root to a given node
    private static boolean findPath(Node root, int value, java.util.List<Node> path) {
        if (root == null) return false;
        
        // Add current node to path
        path.add(root);
        
        // If current node is the target, return true
        if (root.data == value) return true;
        
        // Search in left and right subtrees
        if (findPath(root.left, value, path) || findPath(root.right, value, path)) {
            return true;
        }
        
        // If not found in either subtree, remove current node from path
        path.remove(path.size() - 1);
        return false;
    }

    // ==================== UTILITY METHODS ====================
    // Utility method to print the path from root to LCA to both nodes
    public static void printLCAInfo(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.data);
        } else {
            System.out.println("LCA not found for " + n1 + " and " + n2);
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
         *     / \
         *    8   9
         * 
         * Various LCA examples:
         * LCA(4, 5) = 2
         * LCA(4, 6) = 1
         * LCA(3, 4) = 1
         * LCA(2, 4) = 2 (ancestor can be one of the nodes)
         */

        // Build the example tree
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

        // ==================== TESTING METHOD 1: BASIC RECURSIVE APPROACH ====================
        System.out.println("=== METHOD 1: BASIC RECURSIVE LCA ===");
        printLCAInfo(root, 4, 5);   // Expected: 2
        printLCAInfo(root, 4, 6);   // Expected: 1
        printLCAInfo(root, 3, 4);   // Expected: 1
        printLCAInfo(root, 2, 4);   // Expected: 2
        printLCAInfo(root, 8, 9);   // Expected: 4
        printLCAInfo(root, 1, 8);   // Expected: 1
        printLCAInfo(root, 6, 7);   // Expected: 3
        
        System.out.println();

        // ==================== TESTING WITH NON-EXISTENT NODES ====================
        System.out.println("=== TESTING WITH NON-EXISTENT NODES (METHOD 1) ===");
        printLCAInfo(root, 4, 10);  // One node doesn't exist
        printLCAInfo(root, 15, 20); // Both nodes don't exist

        System.out.println();

        // ==================== TESTING METHOD 2: SAFE LCA APPROACH ====================
        System.out.println("=== METHOD 2: SAFE LCA (WITH EXISTENCE CHECK) ===");
        Node safeLCA = findLCASafe(root, 4, 5);
        if (safeLCA != null) {
            System.out.println("Safe LCA of 4 and 5: " + safeLCA.data);
        }

        Node safeLCA2 = findLCASafe(root, 4, 10);
        if (safeLCA2 != null) {
            System.out.println("Safe LCA of 4 and 10: " + safeLCA2.data);
        }

        System.out.println();

        // ==================== TESTING METHOD 3: PATH-BASED APPROACH ====================
        System.out.println("=== METHOD 3: PATH-BASED LCA ===");
        Node pathLCA = findLCAUsingPaths(root, 8, 9);
        if (pathLCA != null) {
            System.out.println("Path-based LCA of 8 and 9: " + pathLCA.data);
        }
        
        Node pathLCA2 = findLCAUsingPaths(root, 4, 6);
        if (pathLCA2 != null) {
            System.out.println("Path-based LCA of 4 and 6: " + pathLCA2.data);
        }

        System.out.println("\n==================================================");

        /*
         * Another Example - Simpler tree:
         *       10
         *      /  \
         *     20  30
         *    /  \
         *   40  50
         */
        
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(40);
        root2.left.right = new Node(50);

        System.out.println("Second Tree:");
        System.out.println("       10");
        System.out.println("      /  \\");
        System.out.println("     20  30");
        System.out.println("    /  \\");
        System.out.println("   40  50");
        System.out.println();

        printLCAInfo(root2, 40, 50); // Expected: 20
        printLCAInfo(root2, 20, 30); // Expected: 10
        printLCAInfo(root2, 10, 40); // Expected: 10
    }
}
