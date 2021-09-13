import org.springframework.beans.factory.support.ManagedMap;

import java.util.*;

public class Ttttt {
    public static void main(String[] args) {

        new Father().doSth(new HashMap());
        new Son().doSth(new LinkedHashMap());


    }
}

class Father {
    public Collection doSth(Map map){
        System.out.println("父类执行");
        return map.values();
    }
}

class Son extends Father {

    public Collection doSth(HashMap map){
        System.out.println("子类执行");
        return map.values();
    }

    public Collection doSth(LinkedHashMap map){
        System.out.println("LinkedHashMap执行");
        return map.values();
    }

    public Collection doSth(ManagedMap map){
        System.out.println("ManagedMap执行");
        return map.values();
    }


}
