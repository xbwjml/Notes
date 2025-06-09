package serial;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        TreeNode root = node3;
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(null == root) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;

        while(!queue.isEmpty()){
            List<Integer> inner = new LinkedList<>();
            int count = queue.size();
            for(int i=0; i<count; i++){
                TreeNode node = order ? queue.pollFirst() : queue.pollLast();
                inner.add(node.val);
                if(null != node.left) queue.add(node.left);
                if(null != node.right) queue.add(node.right);
            }
            res.add(inner);
            order = !order;
        }

        return res;
    }
}