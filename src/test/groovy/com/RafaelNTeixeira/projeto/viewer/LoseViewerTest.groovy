package com.RafaelNTeixeira.projeto.viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Lose
import com.RafaelNTeixeira.projeto.viewer.menuViewe.LoseViewer
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
        5 * gui.drawText(_,_,_)
    }
}
