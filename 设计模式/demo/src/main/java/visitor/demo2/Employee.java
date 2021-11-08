package visitor.demo2;

import java.util.Random;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:28
 * @description:    员工抽象类
 */
public abstract class Employee {
    public String name;
    public int kpi;

    public Employee(String name){
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    public abstract void accept(IVisitor visitor);
}
