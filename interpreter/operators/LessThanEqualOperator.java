package interpreter.operators;

import interpreter.Operand;

public class LessThanEqualOperator extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return null;
    }
}