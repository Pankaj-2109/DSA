class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int left, int right) {

        // Base case
        if (left > right) {
            return null;
        }

        // Find middle element
        int mid = left + (right - left) / 2;

        // Create root node
        TreeNode root = new TreeNode(nums[mid]);

        // Construct left subtree
        root.left = construct(nums, left, mid - 1);

        // Construct right subtree
        root.right = construct(nums, mid + 1, right);

        return root;
    }
}