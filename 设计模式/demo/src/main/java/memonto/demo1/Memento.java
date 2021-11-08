package memonto.demo1;

import lombok.Data;

//备忘录角色
@Data
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }
}
