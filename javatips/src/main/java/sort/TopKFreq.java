package sort;

import java.util.*;

public class TopKFreq {
    public static void main(String[] args) {
        int[] arr = {1,2};
        int k = 2;
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int[] tops = topKFrequent(arrCopy, k);
        return;
    }

    private static int[] topKFrequent(int[] nums, int k) {
        if(null == nums || nums.length == 0 || k ==0)
            return new int[0];

        Map<Integer,Integer> map = new HashMap();
        for (int i : nums)
            map.put(i, map.getOrDefault(i,0)+1);

        //PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,
        //        (x, y) -> map.getOrDefault(x,0)-map.getOrDefault(y,0) );
        //for (Map.Entry<Integer,Integer> entry : map.entrySet()){
        //    int num = entry.getKey();
        //    int count = entry.getValue();
        //    if(queue.size() < k){
        //        queue.offer(num);
        //        continue;
        //    }
        //
        //    if(count > map.getOrDefault(queue.peek(),0)){
        //        queue.poll();
        //        queue.offer(num);
        //    }
        //
        //}
        //
        //int[] res = new int[k];
        //for (int i=0; i<k; i++)
        //    res[i] = queue.poll();
        //return res;

        List<Integer>[] bucket = new List[nums.length+1];
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(null == bucket[count])  bucket[count] = new LinkedList<>();
            bucket[count].add(num);
        }

        List<Integer> resList = new ArrayList<>();
        for(int i=bucket.length-1; i>-1; i--){
            if (bucket[i] != null){
                resList.addAll(bucket[i]);
            }
        }
        int[] resArr = new int[k];
        for (int i=0; i<k; i++)
            resArr[i] = resList.get(i);

        return resArr;
    }
}
