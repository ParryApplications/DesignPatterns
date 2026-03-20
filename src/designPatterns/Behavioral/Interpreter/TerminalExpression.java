package designPatterns.Behavioral.Interpreter;

public class TerminalExpression implements AbstractExpression {
    private final int expression;

    public TerminalExpression(int expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return String.valueOf(expression);
    }

    @Override
    public int interpret() {
        return expression;
    }
}
