package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class DumpCode implements ByteCode {

    private String OnAndOff;

    public DumpCode(String[] args) {
        this.OnAndOff = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumping(OnAndOff);
    }
}
