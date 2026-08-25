class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        helper(root, "", res);

        return res;
    }

    public void helper(TreeNode root, String path, List<String> res) {

        path += root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }

        path += "->";

        if (root.left != null) {
            helper(root.left, path, res);
        }

        if (root.right != null) {
            helper(root.right, path, res);
        }
    }
}