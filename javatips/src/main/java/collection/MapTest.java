package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("zs", "张三");
        map.put("ls", "李四");
        map.put("ww", "王五");

        Set<String> keySet = map.keySet();
        keySet.add("sss");

        return;
    }
}
