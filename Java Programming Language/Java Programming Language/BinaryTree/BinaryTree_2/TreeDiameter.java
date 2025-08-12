class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeDiameter {

    // Global variable to keep track of the maximum diameter
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // Recursive function to compute the height and update diameter
    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Update the diameter if the path through root is larger
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of subtree rooted at current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Simple main method to test
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \     
                4   5  
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeDiameter tree = new TreeDiameter();
        System.out.println("Diameter of the tree is: " + tree.diameterOfBinaryTree(root)); // Output: 3
    }
}
