package interpreter.bytecode;


import interpreter.VirtualMachine;

public class FalseBranchCode extends JumpCode {
    private String label;

    public void init(String a, String b) {
        label = a;
    }

    public void execute(VirtualMachine vm) {
        if (vm.popStack() == 0) {
            vm.programCounter(getJump() -1);
        }
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("FALSEBRANCH " + getLabel());
        return s.toString();
    }
}
