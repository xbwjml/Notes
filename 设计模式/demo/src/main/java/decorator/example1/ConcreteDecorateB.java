package decorator.example1;

public class ConcreteDecorateB extends Decorator {
    public ConcreteDecorateB(Component component) {
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
