public class Test3 {
    public static void main(String[] args) {
        Dad1 d1 = new Son1();
        boolean b = d1 instanceof Dad1;
        boolean b1 = d1 instanceof Son1;
        Son1 d11 = (Son1) d1;

        return;
    }
}

class Dad1{
    String fName;
}

class Son1 extends Dad1{
    String hobby;
}
