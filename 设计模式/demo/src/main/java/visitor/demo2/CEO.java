package visitor.demo2;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:37
 * @description:
 */
public class CEO implements IVisitor{
    @Override
    public void visit(Engineer engineer) {
        System.out.println("开发者: "+engineer.name+", KPI: "+engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("产品经理: "+manager.name+", KPI: "+manager.kpi+", 新产品数量: "+manager.getProductNum());
    }
}
