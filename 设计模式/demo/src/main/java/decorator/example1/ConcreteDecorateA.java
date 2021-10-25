package decorator.example1;

public class ConcreteDecorateA extends Decorator {
    public ConcreteDecorateA(Component component) {
        super(component);
    }

    private void operateFirst(){
        System.out.println(this.getClass().getSimpleName()+" 前置操作");
    }

    private void operateLast(){
        System.out.println(this.getClass().getSimpleName()+" 后置操作");
    }

    public void operate(){
        operateFirst();
        super.operate();
        operateLast();
    }
}
