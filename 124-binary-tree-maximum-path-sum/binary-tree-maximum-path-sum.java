class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ignore negative contributions
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));

        // Update global maximum
        int pathSum = left + right + node.val;
        ans = Math.max(ans, pathSum);

        // Return max single path to parent
        return node.val + Math.max(left, right);
    }
}
