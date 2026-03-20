package designPatterns.Behavioral.Interpreter;

public class Client {
    public static void main(String[] args) {
        //Client can build abstract syntax tree
        //5+3+2
        //NonTerminal denotes to Add Expression (operator)
        //Terminal denotes to Number
        //AbstractExpression denotes to interpreter

        TerminalExpression expression1 = new TerminalExpression(5);
        TerminalExpression expression2 = new TerminalExpression(3);
        TerminalExpression expression3 = new TerminalExpression(2);
        NonTerminalExpression Operator1 = new NonTerminalExpression(expression1, expression2);
        NonTerminalExpression Operator2 = new NonTerminalExpression(Operator1, expression3);

        System.out.println(Operator2.interpret());

    }
}
