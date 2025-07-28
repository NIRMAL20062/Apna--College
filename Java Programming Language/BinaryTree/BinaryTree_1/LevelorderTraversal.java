import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class LevelorderTraversal {

    static int index = -1;  // Global index to build tree

    // Build tree from preorder traversal with -1 as null marker
    public static Node buildTree(int[] preorder) {
        index++;
        if (index >= preorder.length || preorder[index] == -1) {
            return null;
        }

        Node newNode = new Node(preorder[index]);
        newNode.left = buildTree(preorder);
        newNode.right = buildTree(preorder);
        return newNode;
    }

    // Level Order Traversal (BFS)
    public static void levelOrderPrint(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, -1, -1}; // Sample input

        Node root = buildTree(preorder);

        if (root != null) {
            System.out.println("Root of the Tree is: " + root.data);
        } else {
            System.out.println("Tree is empty.");
        }

        System.out.print("\nLevel Order Traversal: ");
        levelOrderPrint(root);
    }
}
