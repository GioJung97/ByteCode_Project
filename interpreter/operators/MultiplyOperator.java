package interpreter.operators;

public class MultiplyOperator extends Operator {
//    @Override
//    public int priority() {
//        return 2;
//    }

    @Override
    public int execute(int operandOne, int operandTwo) {
        return operandOne * operandTwo;
    }
}
