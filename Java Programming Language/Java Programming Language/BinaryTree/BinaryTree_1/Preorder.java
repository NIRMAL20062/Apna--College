class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Preorder {

    static int index = -1;

    // Build tree from preorder traversal with -1 as null marker
    public static Node buildTree(int[] preorder) {
        index++;
        if (index >= preorder.length || preorder[index] == -1) {
            return null;
        }

        Node newNode = new Node(preorder[index]);
        newNode.left = buildTree(preorder);   // build left subtree
        newNode.right = buildTree(preorder);  // build right subtree
        return newNode;
    }

    public static void preorderPrint(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preorderPrint(root.left);
    preorderPrint(root.right);
}


    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, -1, -1}; // Sample input

        Node root = buildTree(preorder);

        if (root != null) {
            System.out.println("Root of the Tree is: " + root.data);
        } else {
            System.out.println("Tree is empty.");
        }


        System.out.print("Preorder Traversal: ");
        preorderPrint(root);

    }
}
