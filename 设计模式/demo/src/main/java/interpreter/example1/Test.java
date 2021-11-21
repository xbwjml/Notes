package interpreter.example1;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        try{
            Context context = new Context();
            Stack<IExperssion> stack = new Stack<>();

            //此处省略递归调用逻辑

            //获取最终的解析表达式；完整语法树
            IExperssion expression = stack.pop();
            expression.interpret(context);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
