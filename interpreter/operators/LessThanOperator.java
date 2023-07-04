package interpreter.operators;

public class LessThanOperator extends Operator {

    @Override
    public int execute(int operandOne, int operandTwo) {
        if(operandOne < operandTwo){
            return 1;
        }else{
            return 0;
        }
    }
}
