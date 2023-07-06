package interpreter.operators;

public class SubtractOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        return operandTwo - operandOne;
    }
}
