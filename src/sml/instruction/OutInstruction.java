package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

public class OutInstruction extends Instruction {

    private final RegisterName result;
    public static final String OP_CODE = "out";

    public OutInstruction(String label, RegisterName result){
        super(label,OP_CODE);
        this.result = result;
    }

    public int execute(Machine m){
        int value1 = m.getRegisters().get(result);
        System.out.println(value1);
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
        OutInstruction that = (OutInstruction) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
