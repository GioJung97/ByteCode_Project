package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranchCode implements ByteCode {

    private String id;

    public FalseBranchCode(String[] args) {
        this.id = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        LabelCode callPC = new LabelCode(new String [] {"Label", String.valueOf(id.charAt(0))});
        int pc = callPC.storedPC(vm);

        if(vm.peek() == 0){
            vm.setProgramCounter(pc);
        }else{
            vm.executeProgram();
        }
    }

    @Override
    public String toString() {
        return "FalseBranchCode{" + id;
    }
}
