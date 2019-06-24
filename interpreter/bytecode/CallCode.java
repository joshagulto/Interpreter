package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends JumpCode {
    private int a;
    private String label;

    public void execute(VirtualMachine vm) {
        a = vm.peekStack();
        vm.pushAddress();
        vm.programCounter(getJump() - 1);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("CALL " + label +"\t" + label + "(" + a + ")");
        return s.toString();
    }
}
