package interpreter.operators;

import interpreter.Operand;

public class SubtractOperator extends Operator {
    @Override
    public int priority() {
        return 1;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        Operand result = new Operand (operandOne.getValue() - operandTwo.getValue());
        return result;
    }
}
