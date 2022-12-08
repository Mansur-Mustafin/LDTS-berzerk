package com.RafaelNTeixeira.projeto.state

import com.RafaelNTeixeira.projeto.States.InstructionsState
import com.RafaelNTeixeira.projeto.controller.menu.InstructionController
import com.RafaelNTeixeira.projeto.model.menu.Instruction
import com.RafaelNTeixeira.projeto.viewer.menuViewer.InstructionViewer
import spock.lang.Specification

class InstructionsStateTest extends Specification{
    private def instructionsModel

    def setup() {
        instructionsModel = new Instruction()
    }

    def 'Get Viewer'() {
        given:
        InstructionsState instructionsState = new InstructionsState(instructionsModel)
        InstructionViewer viewer = new InstructionViewer(instructionsModel)


        when:
        InstructionViewer instructionViewer = instructionsState.getViewer()
        int x = instructionViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get Controller'() {
        given:
        InstructionsState instructionsState = new InstructionsState(instructionsModel)
        InstructionController controller = new InstructionController(instructionsModel)

        when:
        InstructionController instructionController = instructionsState.getController()
        int x = instructionController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
