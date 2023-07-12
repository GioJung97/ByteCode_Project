package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.Scanner;

public class ReadCode implements ByteCode, dumpable {

    public ReadCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value;
        Scanner input = new Scanner (System.in);
        while (true) {
            System.out.print("Please enter an integer: ");
            if (input.hasNextInt()) {
                value = input.nextInt();
                vm.push(value);
                break;
            }else{
                System.out.println("This input is Invalid.");
                input.next();
            }
        }
    }

    @Override
    public String toString() {
        return "READ";
    }
}
