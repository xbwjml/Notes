
import sun.misc.Cleaner;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        try( AC1 ac1 = new AC1() ){
            int a = 1/0;
        }

        AC1 ac1 = new AC1();
        try{
            int a = 1/0;
        }catch (Exception e){
            int b = 1;
        }finally {
            ac1.close();
        }

        return;
    }
}

class AC1 implements AutoCloseable{

    String name;

    static {
        System.out.println("AC1 static on");
    }

    @Override
    public void close() throws Exception {
        int a = 1/0;
        System.out.println("AC1 close");
    }
}

class AC2 implements AutoCloseable{

    static {
        System.out.println("AC2 static on");
    }

    @Override
    public void close() throws Exception {
        System.out.println("AC2 close");
    }
}

class AC3 implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("AC3 close");
    }
}


