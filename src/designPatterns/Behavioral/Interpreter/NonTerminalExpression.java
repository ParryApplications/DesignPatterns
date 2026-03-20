package designPatterns.Behavioral.Interpreter;

//Like operator (using Composite Structured Design Pattern)
//This final can rename to AddExpression
public class NonTerminalExpression implements AbstractExpression {
    private final AbstractExpression expression1;
    private final AbstractExpression expression2;

    public NonTerminalExpression(AbstractExpression expression1, AbstractExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public int interpret() {
        return expression1.interpret() + expression2.interpret();
    }
}
