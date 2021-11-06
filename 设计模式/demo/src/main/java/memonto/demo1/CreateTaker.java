package memonto.demo1;

//备忘录管理者角色
public class CreateTaker {
    private Memento memento;

    public Memento getMemento(){
        return this.memento;
    }

    public void storeMemento(Memento memento){
        this.memento = memento;
    }
}
