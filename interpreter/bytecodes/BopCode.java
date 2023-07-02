package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;
import interpreter.Operand;


public class BopCode implements ByteCode {

    private String operator;

    public BopCode(String[] args) {
        this.operator = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand1 = vm.pop();
        int operand2 = vm.pop();


    }
}
