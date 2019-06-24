package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class notEqualOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isNotEqual = (a != b);

        if (isNotEqual) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
