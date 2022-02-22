package string;

public class TestFinal {
    public static void main(String[] args) {
        final char[] val = {'h', 'e', 'l'};
        char[] val2 = {'w', 'o', 'r'};
        //val = val2;
        val[0] = 'z';
    }
}
