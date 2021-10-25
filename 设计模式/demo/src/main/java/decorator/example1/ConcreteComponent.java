package decorator.example1;

public class ConcreteComponent extends Component {
    @Override
    public void operate() {
        System.out.println("处理业务逻辑");
    }
}
