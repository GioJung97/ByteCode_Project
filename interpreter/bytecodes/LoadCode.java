package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LoadCode implements ByteCode {

    private int offset;
    private String id;

    public LoadCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);
        if(args.length > 2){
            this.id = args[2];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    @Override
    public String toString() {
        String base = "LOAD " + this.offset;
        if(this.id != null){
            base += " " + this.id + "\tload " + this.id;
        }
        return base;
    }
}
