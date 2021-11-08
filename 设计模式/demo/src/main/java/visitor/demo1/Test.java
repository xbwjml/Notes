package visitor.demo1;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:46
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();

        IVisitor visitorA = new VisitorA();
        collection.accept(visitorA);

        IVisitor visitorB = new VisitorB();
        collection.accept(visitorB);
    }
}
