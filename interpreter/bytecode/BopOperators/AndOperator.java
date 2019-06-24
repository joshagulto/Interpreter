package interpreter.bytecode.BopOperators;

import interpreter.VirtualMachine;
import interpreter.bytecode.BopCode;

public class AndOperator extends BopCode {
    public void execute(VirtualMachine vm) {
        int a = vm.popStack();
        int b = vm.popStack();

        boolean isTrue1 = (a == 1);
        boolean isTrue2 = (b == 1);

        boolean bothTrue = (isTrue1 && isTrue2);
        if (bothTrue) {
            vm.pushStack(1);
        } else {
            vm.pushStack(0);
        }
    }
}
