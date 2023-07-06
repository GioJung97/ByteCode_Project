package interpreter.operators;

public class GreaterThanEqualOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        if(operandTwo >= operandOne){
            return 1;
        }else{
            return 0;
        }
    }
}
