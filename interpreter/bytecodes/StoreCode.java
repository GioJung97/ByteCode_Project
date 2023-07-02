package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode {

    private String id;
    private int offset;

    public StoreCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);

        if(args.length > 2){
            this.id = args[2];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    public String toStrings(VirtualMachine vm){
        String base = "STORE " + this.offset;
        if (this.id != null){
            base += " " + this.id + "\t" + this.id + "=" + vm.store(offset);
        }
        return base;
    }

}
