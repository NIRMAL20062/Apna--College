
	// Node class representing each node of the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Info class to return both height and diameter
class Info {
    int diam;
    int ht;

    public Info(int diam, int ht) {
        this.diam = diam;
        this.ht = ht;
    }
}

public class TreeDiameter_n {

    // Main function to compute diameter
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);  // base case: diameter = 0, height = 0
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diamThroughRoot = leftInfo.ht + rightInfo.ht;
        int maxSubtreeDiam = Math.max(leftInfo.diam, rightInfo.diam);
        int currentDiam = Math.max(diamThroughRoot, maxSubtreeDiam);

        int currentHeight = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(currentDiam, currentHeight);
    }

    // Driver method
    public static void main(String[] args) {
        // Sample binary tree:
        //
        //        1
        //       / \
        //      2   3
        //     / \    
        //    4   5

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Info result = diameter(root);
        System.out.println("Diameter of the tree: " + result.diam);
    }
}
