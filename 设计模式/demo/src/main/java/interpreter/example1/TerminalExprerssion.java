package interpreter.example1;

//终结符表达式
public class TerminalExprerssion implements IExperssion {

    private Object value;

    @Override
    public Object interpret(Context context) {
        //实现文法中与终结符有关的操作
        context.put("","");
        return null;
    }
}
