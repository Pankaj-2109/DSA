class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // Visit curr
                if (prev != null && prev.val > curr.val) {
                    if (first == null) first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;

                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;

                    // Visit curr
                    if (prev != null && prev.val > curr.val) {
                        if (first == null) first = prev;
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}