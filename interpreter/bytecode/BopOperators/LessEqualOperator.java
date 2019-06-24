package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class LessEqualOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isLessEqual = (b <= a);

        if (isLessEqual) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
