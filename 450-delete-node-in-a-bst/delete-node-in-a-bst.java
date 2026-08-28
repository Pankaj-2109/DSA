class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {

        // Key not found
        if (root == null) {
            return null;
        }

        // Search in right subtree
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // Search in left subtree
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // We found the node
        else {

            // Case 1: no left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: no right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: two children
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.val = successor.val;

            // Delete the successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}
