import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class EasyLevelOrder {
    
    // Level Order Traversal (BFS - Breadth First Search)
    public static void levelOrder(Node root) {
        // Step 1: Handle empty tree
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }

        // Step 2: Create a queue to store nodes
        Queue<Node> queue = new LinkedList<>();
        
        // Step 3: Add root to queue (starting point)
        queue.add(root);
        
        System.out.print("Level Order: ");
        
        // Step 4: Process until queue is empty
        while (!queue.isEmpty()) {
            // Step 5: Remove front node from queue
            Node current = queue.remove();
            
            // Step 6: Print the current node's data
            System.out.print(current.data + " ");
            
            // Step 7: Add left child to queue (if exists)
            if (current.left != null) {
                queue.add(current.left);
            }
            
            // Step 8: Add right child to queue (if exists)
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println(); // New line after traversal
    }

    // Helper method to build a simple test tree
    public static Node buildSampleTree() {
        /*
         * Building this tree:
         *       1
         *      / \
         *     2   3
         *    / \   \
         *   4   5   6
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== LEVEL ORDER TRAVERSAL DEMO ===");
        
        // Create sample tree
        Node root = buildSampleTree();
        
        System.out.println("Tree structure:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    / \\   \\");
        System.out.println("   4   5   6");
        System.out.println();
        
        // Perform level order traversal
        levelOrder(root);
        
        System.out.println("\nStep-by-step explanation:");
        System.out.println("Level 0: 1");
        System.out.println("Level 1: 2, 3");
        System.out.println("Level 2: 4, 5, 6");
        System.out.println("Result: 1 2 3 4 5 6");
    }
}
