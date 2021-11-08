package visitor.demo2;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:33
 * @description:
 */
public interface IVisitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}
