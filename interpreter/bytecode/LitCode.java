package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
     private int n;
     private String token;

     public void init(String a, String b) {
         n = Integer.parseInt(a);
         token = b;
     }

     public void execute(VirtualMachine vm) {
         vm.pushStack(n);
     }

     public String toString() {
         StringBuffer s = new StringBuffer();
         s.append("LIT" + n + " " + token);
         return s.toString();
     }
}
