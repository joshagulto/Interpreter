package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private int n;
    private String id;

    public void init(String a, String b) {
        n = Integer.parseInt(a);
        id = b;
    }

    public void execute(VirtualMachine vm) {
        vm.storeAtOffset(n);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("STORE " + n + " " + id);
        return s.toString();
    }


}
