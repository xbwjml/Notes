package innerClass.member;

public class Outer {
    private String name = "外面name";

    public Outer(){
        System.out.println("外部类无参构造");
    }

    public void run() {
        System.out.println("外面run");
    }

    public void eat() {
        Inner inner = new Inner();
        System.out.println(inner.val);
        inner.say();
    }

    /**
     * 成员内部类：一个类是外部类的成员
     */
    class Inner {
        private String val = "内部val";

        public void say() {
            System.out.println(name);
            Outer.this.run();
        }
    }
}
