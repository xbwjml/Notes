package visitor.demo2;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:40
 * @description:
 */
public class CTO implements IVisitor{
    @Override
    public void visit(Engineer engineer) {
        System.out.println("开发者: "+engineer.name+", KPI: "+engineer.kpi+", 代码量: "+engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("产品经理: "+manager.name+", KPI: "+manager.kpi );
    }
}
