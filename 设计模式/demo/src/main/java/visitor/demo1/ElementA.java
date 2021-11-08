package visitor.demo1;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:33
 * @description:    具体元素A
 */
public class ElementA implements IElement{
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String operA(){
        return this.getClass().getSimpleName();
    }
}
