package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class GotoCode implements ByteCode, dumpable, jumpable {

    private String id;
    private int location;

    public GotoCode(String[] args) {
        this.id = args[1];
    }

    public String getId() {
        return id;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(location);
    }


    @Override
    public String toString() {
        return "GOTO " + id;
    }
}
