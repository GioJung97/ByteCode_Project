package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LoadCode implements ByteCode, dumpable {

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
            base += " " + this.id + "\t<load " + this.id + ">";
        }
        return base;
    }
}
