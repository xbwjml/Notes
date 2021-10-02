package threadLocalTest;

import java.util.Optional;
import java.util.stream.IntStream;

public class Test {

    static ThreadLocal<String> st = new ThreadLocal();

    static String s = "";

    public static void main(String[] args) {

        int range = 20;

        IntStream.range(1, range).forEach(e->{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //s+=e;
                    st.set(s+=e);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    //System.out.println(e+" : "+ s );
                    System.out.println(e+" : "+ st.get() );
                }
            }).start();
        });


        return;
    }
}
