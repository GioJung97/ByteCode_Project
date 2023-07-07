package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode, dumpable {

    private String id;
    private int offset;
    private int storedOffset;

    public StoreCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);

        if(args.length > 2){
            this.id = args[2];
        }
    }

    public void setStoredOffset(int storedOffset) {
        this.storedOffset = storedOffset;
    }

    public int getStoredOffset() {
        return this.storedOffset;
    }

    @Override
    public void execute(VirtualMachine vm) {
        setStoredOffset(vm.store(offset));
    }

    @Override
    public String toString() {
        String base = "STORE " + this.offset;
        if (this.id != null){
            base += " " + this.id + "\t" + this.id + " = " + getStoredOffset();
        }
        return base;
    }

}
