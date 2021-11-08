package visitor.demo2;

import java.util.Random;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:31
 * @description:
 */
public class Engineer extends Employee{
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int getCodeLines(){
        return new Random().nextInt(10*10000);
    }
}
