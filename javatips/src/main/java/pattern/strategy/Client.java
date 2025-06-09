package pattern.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new STA());
        context.work();
    }

    interface ISt {
        void calculate();
    }

    static class Context {
        private ISt ist;

        public Context(ISt ist) {
            this.ist = ist;
        }

        public void work() {
            this.ist.calculate();
        }
    }

    static class STA implements ISt {

        @Override
        public void calculate() {
            System.out.println("策略A");
        }
    }

    static class STB implements ISt {

        @Override
        public void calculate() {
            System.out.println("策略B");
        }
    }

}
