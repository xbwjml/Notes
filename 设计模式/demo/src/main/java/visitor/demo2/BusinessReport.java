package visitor.demo2;

import java.util.Arrays;
import java.util.List;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:35
 * @description:
 */
public class BusinessReport {
    private List<Employee> list = Arrays.asList(
            new Manager("产品经理A"),
            new Manager("产品经理B"),
            new Engineer("程序员1"),
            new Engineer("程序员2"),
            new Engineer("程序员3")
    );

    public void showReport(IVisitor visitor){
        list.forEach(e-> e.accept(visitor) );
    }
}
