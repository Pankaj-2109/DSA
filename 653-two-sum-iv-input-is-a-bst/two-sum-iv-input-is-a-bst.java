class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        int left = 0;
        int right = inorder.size() - 1;

        while (left < right) {
            int sum = inorder.get(left) + inorder.get(right);

            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
}