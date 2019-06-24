package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class LessThanOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isLess = (b < a);

        if (isLess) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
