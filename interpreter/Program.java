package interpreter;

import java.awt.*;
import java.util.ArrayList;
import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int counter) {
        return this.program.get(counter);
    }

    public void addByteCode(ByteCode bc) {
        program.add(bc);
    }

    public int getSize() {
        return program.size();
    }

    public boolean isLabel(ByteCode bc) {
        return (bc instanceof LabelCode);
    }

    public boolean isJump(ByteCode bc) {
        return (bc instanceof JumpCode);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
          int size = this.getSize();

          for (int i = 0; i < size; i++) {
              ByteCode newCode = this.getCode(i);
              if (isJump(newCode)) {
                  String label = ((JumpCode) newCode).getLabel();

                  for (int j = 0; j < size; i++) {
                      ByteCode jumpCode = this.getCode(j);

                      if (isLabel(jumpCode)) {
                          String jumpLabel = ((JumpCode) jumpCode).getLabel();

                          if(jumpLabel.equals(label)) {
                              ((JumpCode)newCode).setJump(j);
                              break;
                          }
                      }
                  }
              }
          }
    }
}