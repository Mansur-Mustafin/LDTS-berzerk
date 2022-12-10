package com.RafaelNTeixeira.projeto.viewer.menuViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Instruction
import com.RafaelNTeixeira.projeto.viewer.menuViewer.InstructionViewer
import spock.lang.Specification

class InstructionViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'Instruction Text Draw'() {
        given:
        def leader_viewer = new InstructionViewer(new Instruction())
        def gui = Mock(GUILaterna.class)

        when:
        leader_viewer.drawElements(gui)

        then:
        19 * gui.drawText(_,_,_)
    }
}
