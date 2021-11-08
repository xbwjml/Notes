package memonto.demo1;

import lombok.Data;

//发起人角色
@Data
public class Originator {
    private String state;

    public Memento createMemento(){
        return new Memento(this.state);
    }

    public void restoreMemento(Memento memento){
        this.setState(memento.getState());
    }
}
