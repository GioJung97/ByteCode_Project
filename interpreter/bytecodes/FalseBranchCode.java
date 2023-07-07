package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranchCode implements ByteCode, dumpable, jumpable {

    private String id;
    private int location;

    public FalseBranchCode(String[] args) {
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
        int tos = vm.pop();
        if(tos == 0){
            vm.setProgramCounter(location);
        }
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + id;
    }
}
