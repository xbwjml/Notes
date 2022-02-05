package sort;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode node = toTree(nums, 0, nums.length - 1);
        return;
    }

    private static TreeNode toTree(int[] nums, int low, int high){
        if(low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toTree(nums, low, mid - 1);
        node.right = toTree(nums, mid + 1, high);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
