package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * The class represents the "mul" type instruction.
 * The class inherits from the Instruction class and applies among others,
 * the abstract methods from its parent class.
 *
 * An instance of this class contains the label, and two registers (result and source),
 * where the multiplication operation will be passed to the result register.
 * @author gakid
 */
public class MulInstruction extends Instruction {

    private final RegisterName result;
    private final RegisterName source;
    public static final String OP_CODE = "mul";

    public MulInstruction(String label, RegisterName result, RegisterName source){
        super(label,OP_CODE);
        this.source = source;
        this.result = result;
    }

    @Override
    public int execute(Machine m){
        int value1 = m.getRegisters().get(result);
        int value2 = m.getRegisters().get(source);
        m.getRegisters().set(result, value1 * value2);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result + " " + source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MulInstruction that = (MulInstruction) o;
        return Objects.equals(result, that.result) && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, source);
    }
}
