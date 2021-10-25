package innerClass.staticInner;

public class Outer {
    String name = "外部name";
    static String name2 = "外部name2";


    static class Inenr{
        String key = "inner key";
        public static void show(){
            System.out.println(name2);
        }
    }
}
