package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class GreaterEqualOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isGreaterEqual = (b >= a);

        if (isGreaterEqual) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
