package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String funcname;
    private int n;

    public void init(String a, String b) {
        funcname = a;
    }

    public void execute(VirtualMachine vm) {
        n = vm.peekStack();
        vm.popFrame();
        vm.popAddress();
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("RETURN " + funcname);
        if (n < 0) {
            s.append(n);
        }
        return s.toString();
    }

}
