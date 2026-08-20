class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.isEmpty()) {

            // Go as far left as possible
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            // Process node
            root = st.pop();
            ans.add(root.val);

            // Move to right subtree
            root = root.right;
        }

        return ans;
    }
}