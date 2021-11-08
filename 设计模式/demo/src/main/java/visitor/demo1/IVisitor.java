package visitor.demo1;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:32
 * @description:    抽象访问者
 */
public interface IVisitor {
    void visit(ElementA element);
    void visit(ElementB element);
}
