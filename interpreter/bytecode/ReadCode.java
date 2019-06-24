package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.Scanner;

public class ReadCode extends ByteCode {
    public void init(String a, String b) {
        // no initialization needed //
    }

    public void execute(VirtualMachine vm) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input an Integer: ");
        int newInt = input.nextInt();
        input.nextLine();

        vm.pushStack(newInt);
    }

    public String toString() {
        return "READ ";
    }
}
