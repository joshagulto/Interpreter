package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpSwitch;

    protected VirtualMachine(Program program) {
        program = program;
    }

    public void dumpToggle() {
        dumpSwitch = !dumpSwitch;
    }
    public void toggle() {
        isRunning = !isRunning;
    }

    public String dumpStatus() {
        if (dumpSwitch == true) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    public void pushAddress() {
        returnAddrs.push(pc);
    }

    public void popAddress() {
        returnAddrs.pop();
    }

    public int peekStack() {
        return runStack.peek();
    }

    public int popStack() {
        return runStack.pop();
    }

    public void clearStack() {
        runStack.clear();
    }

    public void pushStack(int a) {
        runStack.push(a);
    }

    public void pushFrame(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popFrame() {
        runStack.popFrame();
    }


    public void storeAtOffset(int offset) {
        runStack.store(offset);
    }

    public void loadAtOffset(int offset) {
        runStack.load(offset);
    }

    public void programCounter(int a) {
        pc = a;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this );
            // runStack.dump(); ///
            pc++;
        }

    }



}
