package visitor.demo2;

import java.util.Random;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:32
 * @description:
 */
public class Manager extends Employee{
    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int getProductNum(){
        return new Random().nextInt(10);
    }
}
