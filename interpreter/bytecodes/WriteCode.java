package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class WriteCode implements ByteCode, dumpable {
    public WriteCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.peek();
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
