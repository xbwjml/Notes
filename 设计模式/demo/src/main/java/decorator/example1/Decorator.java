package decorator.example1;

public class Decorator extends Component {

    protected Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
