package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class JumpCode extends ByteCode {
    private String Label;
    private int jump;

    public void init(String a, String b) {
        Label = a;
    }

    public abstract void execute(VirtualMachine vm);

    public void setJump(int a){
        jump = a;
    }

    public String getLabel(){
        return Label;
    }

    public int getJump(){
        return jump;
    }


}
