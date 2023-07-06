package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ReturnCode implements ByteCode, dumpable {

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

        vm.push(retVal);
        vm.setProgramCounter(addVal);
    }

    @Override
    public String toString() {
        String base = "RETURN";

        if (id != null){
            int endId = id.indexOf("<<");
             base += " " + id + "  EXIT " + id.substring(0, endId) + " : " + getRetVal();
        }
        return base;
    }
}
