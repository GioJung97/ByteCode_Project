package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ReturnCode implements ByteCode {

    private String id;
    private int retVal;
    private int addVal;

    public ReturnCode(String[] args) {
        if(args.length>1){
            this.id = args[1];
        }
    }

    public void setRetVal(int retVal) {
        this.retVal = retVal;
    }

    public void setAddVal(int addVal) {
        this.addVal = addVal;
    }

    public int getRetVal() {
        return retVal;
    }

    @Override
    public void execute(VirtualMachine vm) {
        setRetVal(vm.peek());
        setAddVal(vm.popReturnAddress());
        vm.popCurrFrameAndRTS();
        vm.setProgramCounter(addVal - 1);
    }

    @Override
    public String toString() {
        String base = "RETURN";

        if (id != null){
             base += id + "\t EXIT " + id.charAt(0) + " : " + getRetVal();
        }
        return base;
    }
}
