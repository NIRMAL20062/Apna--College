public class TotalNodesInBinaryTree {
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

    // Count total nodes in the binary tree
    public static int countNodes(Node root) {
	   if (root == null) return 0;
	   return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
	   int[] preorder = {1, 2, -1, -1, 3, -1, -1}; // Sample input

	   Node root = buildTree(preorder);

	   if (root != null) {
		  System.out.println("Root of the Tree is: " + root.data);
		  System.out.println("Total Nodes in the Tree: " + countNodes(root));
	   } else {
		  System.out.println("Tree is empty.");
	   }
    }
}
