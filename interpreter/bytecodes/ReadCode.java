package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.Scanner;

public class ReadCode implements ByteCode {

    private int value;

    public ReadCode(String[] args) {
        this.value = value;
    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner input = new Scanner (System.in);
        while (true) {
            System.out.print("Please enter an integer: ");
            if (input.hasNextInt()) {
                value = input.nextInt();
                break;
            }else{
                System.out.println("This input is Invalid.");
                input.next();
            }
        }

        vm.push(value);
    }

    @Override
    public String toString() {
        return "READ";
    }
}
