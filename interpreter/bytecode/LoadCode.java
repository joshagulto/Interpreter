package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    private int n;
    private String id;

    public void init(String a, String b) {
        n = Integer.parseInt(a);
        id = b;
    }

    public void execute(VirtualMachine vm) {
        vm.loadAtOffset(n);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("LOAD " + n + " " + "id");
        return s.toString();
    }
}
