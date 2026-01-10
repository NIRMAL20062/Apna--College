public class SumOfNodes {
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

    // Calculate sum of all nodes in the binary tree
    public static int sumOfNodes(Node root) {
	   if (root == null) return 0;
	   return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public static void main(String[] args) {
	   int[] preorder = {1, 2, -1, -1, 3, -1, -1}; // Sample input

	   Node root = buildTree(preorder);

	   if (root != null) {
		  System.out.println("Root of the Tree is: " + root.data);
		  System.out.println("Sum of Nodes in the Tree: " + sumOfNodes(root));
	   } else {
		  System.out.println("Tree is empty.");
	   }
    }
}
