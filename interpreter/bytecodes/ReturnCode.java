package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ReturnCode implements ByteCode {

    private String id;
    private int retVal;

    public ReturnCode(String[] args) {
        this.id = args[1];
        if(id.length()>1){
            this.retVal = id.charAt(3);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

    }
}
