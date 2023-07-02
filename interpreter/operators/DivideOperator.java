package interpreter.operators;

import interpreter.Operand;

public class DivideOperator extends Operator {
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        Operand result = new Operand (operandOne.getValue() / operandTwo.getValue());
        return result;
    }
}
