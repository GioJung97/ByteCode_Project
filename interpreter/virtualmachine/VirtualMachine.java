package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    boolean isDumping;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void push(int valueToPush) {
        this.runTimeStack.push(valueToPush);
    }

    public void pushToNewFrame(int valueToPush){
        this.runTimeStack.newFrameAt(valueToPush);
    }

    public int pop() {
        return this.runTimeStack.pop();
    }

    public void popCurrFrameAndRTS(){
        this.runTimeStack.popFrame();
    }

    public int peek(){
        return this.runTimeStack.peek();
    }

    public int store(int offsetValue) {
        return this.runTimeStack.store(offsetValue);
    }

    public void load(int offset) {
        this.runTimeStack.load(offset);
    }

    public int currFrameSize(){
        return this.runTimeStack.currFrameSize();
    }

    public int currPC(){
        return this.programCounter;
    }

    public boolean setDumping(String onAndOff){
        if("ON".equals(onAndOff)){
            isDumping = true;
        }
        return isDumping;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public String currFrameDump(){
        return this.runTimeStack.currFrameDump();
    }

    public void executeProgram() {
        isRunning = true;

        while (isRunning){
            ByteCode code = program.getCode(programCounter);
            //if dumping is on, print out the code, print out the runtime dump
            if(isDumping){
                System.out.println(code);
                System.out.println(this.runTimeStack.dump());
            }

            code.execute(this);
            programCounter++;
        }
    }

    public void pushToReturnAddress() {
        this.returnAddress.push(programCounter);
    }

    public int popReturnAddress(){
        return returnAddress.pop();
    }

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
}
