package guice.aop;


public enum MathSymbolEnum {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    LEFT_ROUND_BRACKETS("("),
    RIGHT_ROUND_BRACKETS(")"),
    ;

    private String operator;

    MathSymbolEnum(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
