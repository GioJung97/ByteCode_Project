package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode, dumpable {

    private int numAmountToPop;

    public PopCode(String[] args) {
        this.numAmountToPop = Integer.parseInt(args[1]);

    }

    @Override
    public void execute(VirtualMachine vm) {
        int maxNum = this.numAmountToPop;
        if(numAmountToPop > vm.currFrameSize()){
            maxNum = vm.currFrameSize();
        }

        for(int i=0; i<maxNum; i++){
            vm.pop();
        }
    }

    @Override
    public String toString() {
        String base = "POP " + this.numAmountToPop;

        return base;
    }
}
