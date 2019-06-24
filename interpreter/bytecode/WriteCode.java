package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {
    public void init(String a, String b) {
        // no initialization needed //
    }

    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekStack());
    }

    public String toString() {
        return "WRITE ";
    }
}
