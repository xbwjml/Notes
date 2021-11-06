package memonto.demo1;

public class Test {
    public static void main(String[] args) {
        //创建发起人角色
        Originator originator = new Originator();
        //创建备忘录管理员角色
        CreateTaker createTaker = new CreateTaker();
        //管理员存储发起人的备忘录
        createTaker.storeMemento(originator.createMemento());
        //发起人从管理员获取备忘录进行回滚
        originator.restoreMemento(createTaker.getMemento());
    }
}
