package interpreter.virtualmachine;

import interpreter.bytecodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        this.program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return this.program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        this.program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * address for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() {
        HashMap <String, Integer> pass = new HashMap();

        for(int i=0; i<getSize(); i++){
            if(getCode(i).toString().startsWith("LABEL")){
                String [] param = getCode(i).toString().split(" ");
                String secondParam = param[1];
                pass.put(secondParam, i);
            }
        }

        for(int i=0; i<getSize(); i++){
            ByteCode byteCode = this.program.get(i);
                if(byteCode instanceof jumpable){
                    ((jumpable) byteCode).setLocation(pass.get(((jumpable) byteCode).getId()));
                }
        }

    }
}