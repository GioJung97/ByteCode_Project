package interpreter.operators;

public class LogicalAndOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        if (operandTwo == 1 && operandOne == 1) {
            return 1;
        }
        return 0;
    }

}
