package adapter.example1;

/**
 * Adapter
 */
public class PowerAdapter extends AC220 implements DC5 {
    @Override
    public int output5() {
        int input = super.output220();
        int output = input / 44;
        System.out.println("输入 "+input+" ,输出 "+output);
        return output;
    }
}
