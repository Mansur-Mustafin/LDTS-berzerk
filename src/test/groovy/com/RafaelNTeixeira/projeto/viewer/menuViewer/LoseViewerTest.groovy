package com.RafaelNTeixeira.projeto.viewer.menuViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Lose
import com.RafaelNTeixeira.projeto.viewer.menuViewer.LoseViewer
import spock.lang.Specification

class LoseViewerTest extends Specification {
    private def gui
    private def lose
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'You Lose Text Draw'() {
        given:
        def lose_viewer = new LoseViewer(new Lose(10))
        def gui = Mock(GUILaterna.class)

        when:
        lose_viewer.drawElements(gui)

        then:
        1 * gui.drawText(new Position(12,14),_,"#FFD700")
        1 * gui.drawText(new Position(8,11),_,"#FFFFFF")
        1 * gui.drawText(new Position(9,15),_,"#FFFFFF")
        1 * gui.drawText(new Position(6,16),_,"#FFFFFF")
        1 * gui.drawText(new Position(10,10),_,"#ff0000")
    }
}
