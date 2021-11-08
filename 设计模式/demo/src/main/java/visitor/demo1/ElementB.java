package visitor.demo1;

import java.util.Random;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:34
 * @description:    具体元素B
 */
public class ElementB implements IElement{
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int operB(){
        return new Random().nextInt(100);
    }
}
