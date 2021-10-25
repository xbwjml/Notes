public class Test2 {
    public static void main(String[] args) {
        Long a1 = new Long(10);
        Long b1 = new Long(10);
        boolean r1 = (a1 == b1);
        
        Long a2 = -129l;
        Long b2 = -129l;
        boolean r2 = (a2 == b2);

        Long a3 = -128l;
        Long b3 = -128l;
        boolean r3 = (a3 == b3);

        Long a4 = 127l;
        Long b4 = 127l;
        boolean r4 = (a4 == b4);

        Long a5 = 128l;
        Long b5 = 128l;
        boolean r5 = (a5 == b5);

        Long a6 = Long.valueOf(-129);
        Long b6 = Long.valueOf(-129);
        boolean r6 = (a6 == b6);

        Long a7 = Long.valueOf(-128);
        Long b7 = Long.valueOf(-128);
        boolean r7 = (a7 == b7);

        Long a8 = Long.valueOf(127);
        Long b8 = Long.valueOf(127);
        boolean r8 = (a8 == b8);

        Long a9 = Long.valueOf(128);
        Long b9 = Long.valueOf(128);
        boolean r9 = (a9 == b9);

        return;
    }

}
