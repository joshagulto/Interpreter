package interpreter.bytecode.BopOperators;

import interpreter.bytecode.BopCode;
import interpreter.VirtualMachine;

public class AddOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();
        vm.pushStack(b + a);
    }

}
