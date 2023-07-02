package interpreter.operators;

import interpreter.Operand;

public class PowerOperator extends Operator {
    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        Operand result = new Operand ((int) Math.pow(operandOne.getValue(), operandTwo.getValue()));

        return result;
    }
}
