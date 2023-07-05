package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode {

    private int numAmountToPop;

    public PopCode(String[] args) {
        this.numAmountToPop = Integer.parseInt(args[1]);

    }

    @Override
    public void execute(VirtualMachine vm) {
        if(numAmountToPop > vm.currFrameSize()){
            this.numAmountToPop = vm.currFrameSize();
        }

        for(int i=0; i<numAmountToPop; i++){
            vm.pop();
        }
    }

    @Override
    public String toString() {
        String base = "POP " + this.numAmountToPop;

        return base;
    }
}
