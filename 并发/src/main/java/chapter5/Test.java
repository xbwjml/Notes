package chapter5;

public class Test {
    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
        ;
        String s = "ta";
        int res = findString(words, s);
        return;
    }

    private static int findString(String[] words, String s) {

        int len = words.length;
        if(len == 0)
            return -1;

        int[] idxArr = new int[len];
        int idxP = 0;

        for(int i=0; i<len; i++){
            if(!"".equals(words[i])){
                idxArr[idxP] = i;
                idxP++;
            }
        }

        int left = 0;
        int right = --idxP;
        int mid = -1;
        while( left <= right ){
            mid = (left & right) + ((left ^ right) >> 1);
            String midStr = words[idxArr[mid]];
            int compare = s.compareTo(midStr);

            if( compare == 0 )
                return idxArr[mid];

            if( compare > 0 )
                left = mid + 1;

            if( compare < 0 )
                right = mid - 1;
        }

        return -1;
    }
}
