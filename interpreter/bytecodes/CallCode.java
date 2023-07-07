package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode, dumpable, jumpable {

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
        vm.pushToReturnAddress();
        vm.setProgramCounter(location);
        setStoredValue(vm.currFrameDump());
    }

    @Override
    public String toString() {
        String nameOfFunction = id.replaceAll("[^A-Za-z]+", "");
        String base = "CALL " + nameOfFunction;

        if(getStoredValue() != null){
            base = "CALL " + id + "\t" + nameOfFunction + getStoredValue();
        }

        return base;
    }
}
