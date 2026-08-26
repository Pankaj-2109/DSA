class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        if (root == null || target == null) {
            return result;
        }

        find(root, target, k, result);
        return result;
    }

    // Returns distance from root to target
    // -1 means target is not present in this subtree
    private int find(TreeNode root, TreeNode target, int k, List<Integer> result) {

        if (root == null) {
            return -1;
        }

        // Target found
        if (root == target) {
            collectDown(root, k, result);
            return 0;
        }

        // Search in left subtree
        int leftDist = find(root.left, target, k, result);

        if (leftDist != -1) {

            // Current root is k distance from target
            if (leftDist + 1 == k) {
                result.add(root.val);
            }

            // Need to search right subtree
            // Distance from root to target = leftDist + 1
            int remaining = k - leftDist - 2;

            if (remaining >= 0) {
                collectDown(root.right, remaining, result);
            }

            return leftDist + 1;
        }

        // Search in right subtree
        int rightDist = find(root.right, target, k, result);

        if (rightDist != -1) {

            if (rightDist + 1 == k) {
                result.add(root.val);
            }

            // Search left subtree
            int remaining = k - rightDist - 2;

            if (remaining >= 0) {
                collectDown(root.left, remaining, result);
            }

            return rightDist + 1;
        }

        return -1;
    }

    // Collect nodes k distance DOWN from root
    private void collectDown(TreeNode root, int k, List<Integer> result) {

        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            result.add(root.val);
            return;
        }

        collectDown(root.left, k - 1, result);
        collectDown(root.right, k - 1, result);
    }
}