
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean reverse=false;
        while(!queue.isEmpty()){
            int lvlsize=queue.size();
            List<Integer> currlvl=new ArrayList<>(lvlsize);
            for(int i=0;i<lvlsize;i++){
                if(!reverse){
                    TreeNode currNode=queue.pollFirst();
                    currlvl.add(currNode.val);
                    if(currNode.left!=null){
                        queue.addLast(currNode.left);
                    }
                    if(currNode.right!=null){
                        queue.addLast(currNode.right);
                    }
                }
                else{
                    TreeNode currNode=queue.pollLast();
                    currlvl.add(currNode.val);
                    if(currNode.right!=null){
                        queue.addFirst(currNode.right);
                    }
                    if(currNode.left!=null){
                        queue.addFirst(currNode.left);
                    }

                }
                
            }
            reverse=!reverse;
            result.add(currlvl);
        }
        return result;
        
    }
}