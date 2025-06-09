package collection;

public class Sing {
    private Sing(){}

    private static class Holder {
        private static Sing ins = new Sing();
    }

    public static Sing getIns() {
        return Holder.ins;
    }
}
