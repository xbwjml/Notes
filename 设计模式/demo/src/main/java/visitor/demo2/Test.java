package visitor.demo2;

/**
 * @author: LeeMJ
 * @date: 2021/11/8 17:42
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();
        report.showReport(new CEO());
        System.out.println("=====================");
        report.showReport(new CTO());
    }

}
