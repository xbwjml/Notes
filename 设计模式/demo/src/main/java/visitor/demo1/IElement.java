package visitor.demo1;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:32
 * @description:    抽象元素
 */
public interface IElement {
    void accept(IVisitor visitor);
}
