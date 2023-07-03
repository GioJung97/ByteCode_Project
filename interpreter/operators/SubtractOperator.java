package interpreter.operators;

public class SubtractOperator extends Operator {
//    @Override
//    public int priority() {
//        return 1;
//    }

    @Override
    public int execute(int operandOne, int operandTwo) {
        return operandOne - operandTwo;
    }
}
