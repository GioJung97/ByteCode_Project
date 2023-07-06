package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LabelCode implements ByteCode, dumpable {

    private String location;
    private int pc;

    public LabelCode(String[] args) {
        this.location = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    int storedPC(VirtualMachine vm){
        return this.pc = vm.currPC();
    }

    @Override
    public String toString() {
        return "LABEL " + location;
    }
}
