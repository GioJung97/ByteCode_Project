package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {

    private String id;
    private int argVal;
    private String storedValue;
    private int location;

    public CallCode(String[] args) {
        this.id = args[1];
        if(id.length()>1){
            this.argVal = id.charAt(3);
        }
    }

    public String getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(String storedValue) {
        this.storedValue = storedValue;
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

        vm.pushToReturnAddress();
        vm.setProgramCounter(pc - 1);
        setStoredValue(vm.currFrameDump());

    }

    @Override
    public String toString() {
        String base = "CALL " + id + "\t" + id.charAt(0) + getStoredValue();

        return base;
    }
}
