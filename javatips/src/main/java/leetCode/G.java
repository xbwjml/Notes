package leetCode;

class A<T>{

}

public class G{
    public static void main(String[] args) {
        A<Integer> a1 = new A<Integer>();
        A<String> a2 = new A<String>();
        Class<? extends A> aClass = a1.getClass();
        Class<? extends A> a2Class = a2.getClass();
        boolean b = aClass == a2Class;
        return;
    }
}


