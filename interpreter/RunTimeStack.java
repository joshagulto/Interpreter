package interpreter;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        runTimeStack.clear();
    }

    public int peek() {
        if (!(runTimeStack.isEmpty())) {
            int i = runTimeStack.size() - 1;
            return runTimeStack.get(i);
        } else {
            System.out.println("*** RunTimeStack is Empty ***");
            return 0;
        }
    }

    public int pop() {
        if (!(runTimeStack.isEmpty())) {
            int i = runTimeStack.size() - 1;
            int value = runTimeStack.get(i);
            runTimeStack.remove(i);

            return value;
        } else {
            System.out.println("*** RunTimeStack is Empty ***");
            return 0;
        }

    }

    public void clear() {
        runTimeStack.clear();
    }

    public void newFrameAt(int offset) {
        if (!(runTimeStack.isEmpty())) {
            if (offset > (runTimeStack.size())) {
                System.out.println("*** Offset greater than size ***");
            } else {
                framePointer.add(runTimeStack.size() - offset);
            }
        }
    }

    public void popFrame() {
        int value;
        int i = runTimeStack.size() - 1;

        int frameIndex = framePointer.peek();

        if (!(runTimeStack.isEmpty())) {
            value = runTimeStack.get(i);

            while (frameIndex > i) {
                runTimeStack.remove(i);
                i--;
            }

            runTimeStack.remove(i);
            framePointer.pop();
        } else {
            System.out.println("*** RunTimeStack is Empty ***");
        }

    }

    public int store(int offset) {
        if (!runTimeStack.isEmpty()) {
            int frameIndex = framePointer.peek();
            int temp = frameIndex + offset;
            int size = runTimeStack.size();
            int value;

            if (temp > 0 && temp < runTimeStack.size()) {
                value = runTimeStack.get(size);
                runTimeStack.remove(size);
                size--;

                if (offset == size) {
                    runTimeStack.add(frameIndex + offset);
                } else {
                    runTimeStack.set(frameIndex + offset, value);
                }

                return value;
            }
        } else {
            System.out.println("*** RunTimeStack is Empty ***");
            return 0;
        }
        return 0;
    }

    public int load(int offset) {
        if (!(runTimeStack.isEmpty())) {
            int last = runTimeStack.size() - 1;
            int frameIndex = framePointer.peek();
            int temp = offset + frameIndex;
            int value = 0;

            if (temp > 0 && temp < last) {
                value = runTimeStack.get(frameIndex + offset);
                runTimeStack.add(value);
            }

            return value;
        } else {
            System.out.println("*** RunTimeStack is Empty");
            return 0;
        }
    }

    public Integer push(Integer val) {
        runTimeStack.add(val);
        return val;
    }
}
