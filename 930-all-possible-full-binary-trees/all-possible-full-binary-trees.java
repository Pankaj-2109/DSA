class Solution {

    HashMap<Integer, List<TreeNode>> mp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }

    public List<TreeNode> solve(int n) {

        // Even number of nodes cannot form a Full Binary Tree
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        // Base case
        if (n == 1) {
            TreeNode node = new TreeNode(0);
            return new ArrayList<>(Arrays.asList(node));
        }

        // Memoization
        if (mp.containsKey(n)) {
            return mp.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        for (int i = 1; i < n; i += 2) {

            List<TreeNode> leftAllFBT = solve(i);
            List<TreeNode> rightAllFBT = solve(n - i - 1);

            for (TreeNode l : leftAllFBT) {
                for (TreeNode r : rightAllFBT) {

                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;

                    result.add(root);
                }
            }
        }

        mp.put(n, result);

        return result;
    }
}