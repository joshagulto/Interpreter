package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class GreaterThanOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isGreater = (b > a);

        if (isGreater) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
