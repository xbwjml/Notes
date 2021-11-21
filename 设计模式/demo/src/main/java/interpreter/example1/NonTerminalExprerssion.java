package interpreter.example1;

public class NonTerminalExprerssion implements IExperssion {

    private IExperssion[] expressions;

    public NonTerminalExprerssion(IExperssion... expressions){
        //每个带有非终结符的表达式都会对其他表达式产生依赖
        this.expressions = expressions;
    }

    @Override
    public Object interpret(Context context) {
        //进行文法处理
        context.put("","");
        return null;
    }
}
