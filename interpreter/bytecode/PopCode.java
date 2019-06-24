package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private int n;

    public void init(String a, String b) {
        n = Integer.parseInt(a);
    }

    public void execute(VirtualMachine vm) {
        while(n > 0) {
            vm.popStack();
            n--;
        }
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("POP " + n);
        return s.toString();
    }



}
