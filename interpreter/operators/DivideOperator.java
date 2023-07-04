package interpreter.operators;

public class DivideOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        return operandOne / operandTwo;
    }
}
