package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {

    private String id;
    private int argVal;

    public CallCode(String[] args) {
        this.id = args[1];
        if(id.length()>1){
            this.argVal = id.charAt(3);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        LabelCode callPC = new LabelCode(new String [] {"Label", String.valueOf(id.charAt(0))});
        int pc = callPC.storedPC(vm);

        vm.pushToReturnAddress();
        vm.setProgramCounter(pc);

    }

    @Override
    public String toString() {
        String base = "CALL" + id + "\t" + id.charAt(0) + "(" + ")";

        return base;
    }
}
