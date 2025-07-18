package test0301;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Test1223 {
    public static void main(String[] args) {
        int[] capacity = new int[]{91,54,63,99,24,45,78};
        int[] rocks = new int[]{35,32,45,98,6,1,25};
        int additionalRocks = 17;

        Integer.MAX_VALUE
        int[] ints = Arrays.copyOfRange(capacity, 7, 7);

        System.out.println(ints);
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int fullNum = 0;
        List<Integer> list = new LinkedList<>();
        int gap = 0;

        for (int i=0; i<capacity.length; i++) {
            int remains = capacity[i] - rocks[i];
            if (remains == 0) {
                fullNum++;
                continue;
            }
            if (remains <= additionalRocks) {
                list.add(remains);
                gap += remains;
                continue;
            }
        }

        if (gap <= additionalRocks) {
            return capacity.length;
        }

        Collections.sort(list);
        for (Integer c : list) {
            additionalRocks -= c;
            if (additionalRocks < 0) {
                break;
            }
            fullNum++;
        }

        return fullNum;
    }
}
