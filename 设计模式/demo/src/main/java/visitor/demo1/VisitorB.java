package visitor.demo1;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:39
 * @description:    具体访问者B
 */
public class VisitorB implements IVisitor{
    @Override
    public void visit(ElementA element) {
        String res = element.operA();
        System.out.println("result from "+element.getClass().getSimpleName()+" : "+res);
    }

    @Override
    public void visit(ElementB element) {
        int res = element.operB();
        System.out.println("result from "+element.getClass().getSimpleName()+" : "+res);
    }
}
