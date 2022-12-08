package com.RafaelNTeixeira.projeto.model.menu

import spock.lang.Specification

class InstructionTest extends Specification{

    def 'Getting entries'(){
        given:
        Instruction instruction = new Instruction()
        String entry = new String("Press Enter to go back to the menu")


        when:
        boolean f1 = instruction.isSelected(0)
        String entrycheck = instruction.getEntry(0)

        then:
        f1
        entrycheck == entry
    }
}
