package leetCode;

public class KMP {
    public static void main(String[] args) {
        String s = "mississippi";
        String pattern = "issip";
        int i = strStr(s, pattern);
        return;
    }
    public static int strStr(String haystack, String needle) {
        if(null == needle || needle.length() ==0)
            return 0;
        if(null == haystack || haystack.length() ==0)
            return -1;

        int[] next = getNextArr(needle);

        int pLen = needle.length();
        int len = haystack.length();
        for(int i=0, j=0; i<len; i++){

            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j - 1];

            if (haystack.charAt(i) == needle.charAt(j))
                j++;

            if (j == pLen)
                return i - pLen + 1;
        }

        return -1;
    }

    private static int[] getNextArr(String pattern){
        int len = pattern.length();
        char[] p = pattern.toCharArray();
        int[] next = new int[len];
        int i = 1;
        int j = 0;
        while(i < len){
            while(p[i] != p[j] && j > 0)
                j = next[j - 1];
            if(p[i] == p[j])
                j++;
            next[i] = j;
            i++;
        }
        return next;
    }

}
