class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        // Store inorder element -> index
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        postIdx = n - 1;

        return solve(inorder, postorder, 0, n - 1);
    }

    private TreeNode solve(int[] inorder, int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // Root is the last element of postorder
        int rootVal = postorder[postIdx--];

        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int idx = map.get(rootVal);

        // Build right subtree first
        root.right = solve(inorder, postorder, idx + 1, end);

        // Build left subtree
        root.left = solve(inorder, postorder, start, idx - 1);

        return root;
    }
}