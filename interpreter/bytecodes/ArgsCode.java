package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ArgsCode implements ByteCode {

    private int valueOfNewFramePointer;

    public ArgsCode(String[] args) {
        this.valueOfNewFramePointer = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToNewFrame(valueOfNewFramePointer);
    }

    @Override
    public String toString() {
        return "ARGS" + valueOfNewFramePointer;
    }
}
