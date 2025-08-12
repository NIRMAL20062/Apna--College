public class InorderTraversal {

    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, -1, -1}; // Sample input

        Node root = Preorder.buildTree(preorder);

        if (root != null) {
            System.out.println("Root of the Tree is: " + root.data);
        } else {
            System.out.println("Tree is empty.");
        }

        System.out.print("Inorder Traversal: ");
        inorderPrint(root);
    }
}
