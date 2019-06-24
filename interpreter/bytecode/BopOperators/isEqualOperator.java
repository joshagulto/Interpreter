package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class isEqualOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isEqual = (a == b);

        if (isEqual) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
