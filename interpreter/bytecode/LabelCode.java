package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelCode extends JumpCode {
    public void execute(VirtualMachine m) {
        //no initialization needed//
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("LABEL " + getLabel());
        return s.toString();
    }
}
