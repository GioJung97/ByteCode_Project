package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LitCode implements ByteCode, dumpable {

    private String id;
    private int valueToPush;

    public LitCode(String [] args){
        this.valueToPush = Integer.parseInt(args[1]);
        if(args.length > 2){
            this.id = args[2];
        }
    }


    @Override
    public void execute(VirtualMachine vm) {
        vm.push(valueToPush);
    }

    @Override
    public String toString(){
        String base = "LIT " + this.valueToPush;
        if(this.id != null){
            base += "\tint " + this.id;
        }
        return base;
    }
}
