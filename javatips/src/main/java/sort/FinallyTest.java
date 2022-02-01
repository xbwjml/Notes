package sort;

public class FinallyTest {
    public static void main(String[] args) {
        Object test = test();
        return;
    }

    private static Object test(){
            int i = 100;
        try{
            return i++;
        }finally {
            i *= 10;
            return i;
        }
    }
}
