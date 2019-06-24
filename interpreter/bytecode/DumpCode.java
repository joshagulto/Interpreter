package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    private String dumpSwitch;

    public void init(String a, String b) {
        dumpSwitch = a;
    }

    public void execute(VirtualMachine vm) {
        if (!dumpSwitch.equals(vm.dumpStatus())) {
            vm.dumpToggle();
        }
    }
}
