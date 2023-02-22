package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

public class JnzInstruction extends Instruction {

    private final RegisterName result;
    private final RegisterName labeled;

    public static final String OP_CODE = "jnz";

    public JnzInstruction(String label, RegisterName result, RegisterName labeled){
        super(label,OP_CODE);
        this.result = result;
        this.labeled = labeled;
    }

    @Override
    public int execute(Machine m){
        int value1 = m.getRegisters().get(result);
        if (value1 != 0){
            for (int i = 0; i < m.getProgram().size(); i++) {
                if (m.getProgram().get(i).getLabel().equals(labeled)){
                    m.getProgram().get(i).execute(m);
                }
            }
        }
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JnzInstruction that = (JnzInstruction) o;
        return Objects.equals(result, that.result) && Objects.equals(labeled, that.labeled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, labeled);
    }
}
