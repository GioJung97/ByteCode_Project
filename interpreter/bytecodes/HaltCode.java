package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class HaltCode implements ByteCode {
    public HaltCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        //make vm hold (don't use system.exit)
    }

    @Override
    public String toString() {
        return null;
    }
}
