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

    @Override
    public String toString() {
        return "LABEL " + location;
    }
}
