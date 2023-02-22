package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

public class MovInstruction extends Instruction {

    private final RegisterName result;
    private final RegisterName input;

    public static final String OP_CODE = "mov";

    public MovInstruction(String label, RegisterName result, RegisterName input){
        super(label,OP_CODE);
        this.result = result;
        this.input = input;
    }

    @Override
    public int execute(Machine m){
        int value2 = m.getRegisters().get(input);
        m.getRegisters().set(result,value2);
        return  NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result + " " + input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovInstruction that = (MovInstruction) o;
        return Objects.equals(result, that.result) && Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, input);
    }
}
