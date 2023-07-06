package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ArgsCode implements ByteCode, dumpable {

    private int valueOfNewFramePointer;

    public ArgsCode(String[] args) {
        this.valueOfNewFramePointer = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToNewFrame(valueOfNewFramePointer - 1);
    }

    @Override
    public String toString() {
        return "ARGS " + valueOfNewFramePointer;
    }
}
