package visitor.demo1;

import java.util.Arrays;
import java.util.List;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 16:39
 * @description:    结构对象
 */
public class ObjectStructure {
    private List<IElement> list = Arrays.asList(
            new ElementA(),
            new ElementB()
    );

    public void accept(IVisitor visitor){
        this.list.forEach(e-> e.accept(visitor) );
    }
}
