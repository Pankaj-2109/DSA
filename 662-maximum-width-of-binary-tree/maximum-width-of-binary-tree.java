/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0L));

        long maxWidth = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();

            long first = queue.peek().getValue();
            long last = 0;

            while (n-- > 0) {
                Pair<TreeNode, Long> pair = queue.poll();

                TreeNode curr = pair.getKey();
                long index = pair.getValue();

                last = index;

                if (curr.left != null) {
                    queue.offer(
                        new Pair<>(curr.left, 2 * index + 1)
                    );
                }

                if (curr.right != null) {
                    queue.offer(
                        new Pair<>(curr.right, 2 * index + 2)
                    );
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return (int) maxWidth;
    }
}