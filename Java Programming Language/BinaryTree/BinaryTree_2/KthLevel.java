/*
 * PRINT KTH LEVEL OF BINARY TREE
 * 
 * Algorithm:
 * 1. Use recursion to traverse the tree
 * 2. Keep track of current level while traversing
 * 3. When current level equals k, print the node
 * 4. Root is considered as level 1
 * 
 * Time Complexity: O(n) in worst case
 * Space Complexity: O(h) where h is height of tree (recursion stack)
 */

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class KthLevel {

    /**
     * Prints all nodes at the kth level of the binary tree
     * @param root The root node of the tree
     * @param k The level to print (root is level 1)
     */
    public static void printKthLevel(Node root, int k) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
     //    System.out.print("Level " + k + ": ");
        printKthLevelHelper(root, k, 1); // Start from level 1
     //    System.out.println();
    }

    // Helper function for recursive traversal
    private static void printKthLevelHelper(Node node, int k, int currentLevel) {
        // Base case: if node is null
        if (node == null) return;
        
        // If we reached the kth level, print the node
        if (currentLevel == k) {
            System.out.print(node.data + " ");
            return; // No need to go deeper
        }
        
        // Recursively traverse left and right subtrees
        printKthLevelHelper(node.left, k, currentLevel + 1);
        printKthLevelHelper(node.right, k, currentLevel + 1);
    }

    // Alternative iterative approach using level order traversal
    public static void printKthLevelIterative(Node root, int k) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty() && level <= k) {
            int levelSize = queue.size(); // Number of nodes at current level
            
            if (level == k) {
                System.out.print("Level " + k + " (Iterative): ");
                // Print all nodes at kth level
                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();
                    System.out.print(node.data + " ");
                }
                System.out.println();
                return;
            }
            
            // Add next level nodes to queue
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        
        if (level <= k) {
            System.out.println("Level " + k + " does not exist in the tree");
        }
    }

    public static void main(String[] args) {
        /*
         * Example Tree:
         *           1      <- Level 1
         *         /   \
         *        2     3   <- Level 2  
         *       / \   / \
         *      4   5 6   7 <- Level 3
         *     /
         *    8             <- Level 4
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

        System.out.println("Binary Tree Structure:");
        System.out.println("           1      <- Level 1");
        System.out.println("         /   \\");
        System.out.println("        2     3   <- Level 2");
        System.out.println("       / \\   / \\");
        System.out.println("      4   5 6   7 <- Level 3");
        System.out.println("     /");
        System.out.println("    8             <- Level 4");
        System.out.println();

        // Test different levels using recursive approach
        printKthLevel(root, 1); // Should print: 1
        printKthLevel(root, 2); // Should print: 2 3
        printKthLevel(root, 3); // Should print: 4 5 6 7
        printKthLevel(root, 4); // Should print: 8
        printKthLevel(root, 5); // Should print nothing (level doesn't exist)

        System.out.println();

        // Test using iterative approach
        printKthLevelIterative(root, 1); // Should print: 1
        printKthLevelIterative(root, 2); // Should print: 2 3
        printKthLevelIterative(root, 3); // Should print: 4 5 6 7
        printKthLevelIterative(root, 4); // Should print: 8
        printKthLevelIterative(root, 5); // Should indicate level doesn't exist

        System.out.println("\n==================================================");

        /*
         * Another Example:
         *       10     <- Level 1
         *      /  \\
         *     20  30  <- Level 2
         *    /
         *   40        <- Level 3
         */
        
        // Build second example tree
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(40);

        System.out.println("Second Tree:");
        printKthLevel(root2, 1); // Should print: 10
        printKthLevel(root2, 2); // Should print: 20 30
        printKthLevel(root2, 3); // Should print: 40
    }
}
