package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private int a;

    public void init(String a, String b) {
        this.a = Integer.parseInt(a);
    }

    public void execute(VirtualMachine vm) {
        vm.pushFrame(a);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("ARGS ");
        s.append(a);

        return s.toString();
    }


}
