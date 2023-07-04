package interpreter.operators;

public class MultiplyOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        return operandOne * operandTwo;
    }
}
