package interpreter.virtualmachine;

import java.util.*;
import java.util.stream.Collectors;

class RunTimeStack {

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    /**
     * Used for dumping the current state of the runTimeStack.
     * It will print portions of the stack based on respective
     * frame markers.
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0,3,6
     */
    public String dump() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < framePointer.size(); i++) {
            int start = framePointer.get(i);
            int end = (i == framePointer.size() - 1) ? runTimeStack.size() : framePointer.get(i + 1);
            List<Integer> frame = runTimeStack.subList(start, end);

            sb.append(frame.toString());

            if (i != framePointer.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * push the value i to the top of the stack.
     * @param "i" value to be pushed.
     * @return value pushed
     */
    public int push (int value){
        this.runTimeStack.add(value);
        return value;
    }

    /**
     * returns the top of the runtime stack, but does not remove
     * @return copy of the top of the stack.
     */
    public int peek(){

        if(runTimeStack.size() < 1){
            throw new EmptyStackException();
        }

        return this.runTimeStack.get(this.runTimeStack.size() - 1);
    }

    /**
     * removes to the top of the runtime stack.
     * @return the value popped.
     */
    public int pop(){
        if(runTimeStack.size() < 1){
            throw new EmptyStackException();
        }
        return this.runTimeStack.remove(this.runTimeStack.size() - 1);
    }

    /**
     * Takes the top item of the run time stack, and stores
     * it into an offset starting from the current frame.
     * @param "offset" number of slots above current frame marker
     * * @return the item just stored
     */
    public int store(int offsetFromFramePointer){

        this.runTimeStack.set(this.framePointer.peek() + offsetFromFramePointer, this.peek());

        return this.runTimeStack.get(this.framePointer.peek() + offsetFromFramePointer);
    }

    /**
     * Takes a value from the run time stack that is at offset
     * from the current frame marker and pushes it onto the top of
     * the Stack.
     * @param "offset" number of slots above current frame marker
     * * @return item just loaded into the offset
     */
    public int load(int offsetFromFramePointer){

        this.runTimeStack.add(this.framePointer.peek() + offsetFromFramePointer);

        return this.peek();
    }

    /**
     * create a new frame pointer at the index offset slots down
     * from the top of the runtime stack.
     * @param "offset" slots down from the top of the runtime stack
     * */
    public void newFrameAt(int offsetFromTopOfRunStack) {
        this.framePointer.add(this.runTimeStack.size() - 1 - offsetFromTopOfRunStack);
    }

    /**
     * Pop the current frame off the runtime stack. Also removes
     * the frame pointer value from the FramePointer Stack
     */
    public void popFrame(){

        for(int i = 0; i < this.runTimeStack.size() - this.framePointer.peek(); i++){
            this.runTimeStack.remove(this.runTimeStack.size() - 1);
        }

        this.framePointer.pop();
    }


    public static void main(String[] args) {
        RunTimeStack rts = new RunTimeStack();
        rts.push(2);
        rts.push(3);
        rts.push(1);
        rts.push(4);
        rts.push(5);

        rts.newFrameAt(2);


        System.out.println(rts.dump());

//        rts.store(2);
//        rts.runTimeStack.forEach(v -> System.out.println(v));//Lambda expression
    }
}





