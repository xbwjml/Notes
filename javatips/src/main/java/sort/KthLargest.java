package sort;

import java.util.PriorityQueue;

public class KthLargest {

    int k = 1;
    int[] nums = new int[0];
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, (x, y) -> x-y );

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for (int i=0; i<nums.length && i<k; i++)
            queue.add(nums[i]);
        for (int i=k; i<nums.length; i++){
            if(nums[i] > queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(queue.size() < k){
            queue.offer(val);
            return queue.peek();
        }
        if(val > queue.peek()){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}

class Test{
    public static void main(String[] args) {
        int[] nums = {0};
        int k = 2;
        KthLargest kthLargest = new KthLargest(k, nums);

        int[] arr = {-1,1,-2,-4,3};
        for (int i=0; i<arr.length; i++){
            int temp = kthLargest.add(arr[i]);
            int a = 1;
        }
    }
}