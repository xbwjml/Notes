package tes0301;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }
}

public class TTest0401 {

    public static void main(String[] args) {
        int i = climbStairs(45);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
         if (n == 1) return 1;
         if (n == 2) return 2;
         return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
