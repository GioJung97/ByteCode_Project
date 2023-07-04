package interpreter.operators;

public class LogicalOrOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        if (operandOne == 1 || operandTwo == 1) {
            return 1;
        }
        return 0;
    }
}
