package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends JumpCode {
    public void execute(VirtualMachine vm) {
        vm.programCounter(getJump() -1);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("GOTO " + getLabel());
        return s.toString();

    }
}
