class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class SubTree {

    // Check if two trees are exactly the same
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) return true;
        if (node == null || subRoot == null || node.data != subRoot.data) return false;

        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    // Check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) return false;

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        // MAIN TREE:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // SUBTREE:
        //     2
        //    / \
        //   4   5

        Node subRoot = new Node(2);
        subRoot.left = new Node(0);
        subRoot.right = new Node(5);

        if (isSubtree(root, subRoot)) {
            System.out.println("Yes subRoot is a subtree of root");
        } else {
            System.out.println("No subRoot is NOT a subtree of root");
        }
    }
}
