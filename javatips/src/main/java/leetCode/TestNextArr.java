package leetCode;

public class TestNextArr {
    public static void main(String[] args) {
        String pattern = "issip";
        int[] nextArr2 = getNextArr2(pattern);//
        int[] nextArr = getNextArr(pattern);//

        return;
    }

    private static int[] getNextArr(String pattern){
        int len = pattern.length();
        char[] p = pattern.toCharArray();
        int[] next = new int[len];
        int i = 1;
        int j = 0;
        while(i < len){
            while(p[i] != p[j] && j > 0){
                j = next[j - 1];
            }
            if(p[i] == p[j]){
                j++;
            }
            next[i] = j;
            i++;
        }
        return next;
    }

    private static int[] getNextArr2(String needle){
        int m = needle.length();
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }
}
