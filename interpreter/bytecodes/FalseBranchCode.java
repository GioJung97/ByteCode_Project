package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranchCode implements ByteCode {

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
        LabelCode callPC = new LabelCode(new String [] {"Label", String.valueOf(id.charAt(0))});
        int pc = callPC.storedPC(vm);

        if(vm.pop() == 0){
            vm.setProgramCounter(pc - 1);
        }
    }

    @Override
    public String toString() {
        return "FalseBranchCode " + id;
    }
}
