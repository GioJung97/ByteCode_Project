package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import interpreter.operators.Operator;


public class BopCode implements ByteCode, dumpable {

    private String operator;

    public BopCode(String[] args) {
        this.operator = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand1 = vm.pop();
        int operand2 = vm.pop();
        Operator result = Operator.getOperator(operator);

        vm.push(result.execute(operand1, operand2));

    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}
