package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;
import static sml.Registers.Register.EBX;

public class MovInstructionTest {

    private Machine machine;
    private Registers registers;

    @BeforeEach
    void setUp(){
        machine = new Machine(new Registers());
        registers = machine.getRegisters();
    }

    @AfterEach
    void tearDown(){
        machine = null;
        registers = null;
    }

    @Test
    void executeValid(){
        registers.set(EAX,5);
        registers.set(EBX,10);
        Instruction instruction = new MovInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(10,machine.getRegisters().get(EAX));
    }

    @Test
    void executeValidTwo(){
        registers.set(EAX,10);
        registers.set(EBX,0);
        Instruction instruction = new MovInstruction(null,EAX,EBX);
        instruction.execute(machine);
        Assertions.assertEquals(0,machine.getRegisters().get(EAX));
    }
}
