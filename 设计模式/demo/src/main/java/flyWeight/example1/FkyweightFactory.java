package flyWeight.example1;

import java.util.HashMap;
import java.util.Map;

//享元工厂
public class FkyweightFactory {
    private static Map<String,IFlyweight> pool = new HashMap<>();

    //因为内部状态不变性，所以作为缓存的键
    public static IFlyweight getFlyweight(String intrinsicState){
        if( !pool.containsKey(intrinsicState) ){
            IFlyweight flyWeight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, flyWeight);
        }

        return pool.get(intrinsicState);
    }

}
