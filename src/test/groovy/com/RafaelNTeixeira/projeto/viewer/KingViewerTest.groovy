package com.RafaelNTeixeira.projeto.viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King
import com.RafaelNTeixeira.projeto.viewer.gameViewer.KingViewer
import spock.lang.Specification

class KingViewerTest extends Specification {
    private def gui
    private def king

    void setup() {
        king = Mock(King.class)
        gui = Mock(GUILaterna.class)
    }

    def 'King Draw'() {
        given:
        KingViewer king_viewer = new KingViewer()

        when:
        king_viewer.draw(king, gui)

        then:
        1 * gui.drawKing(king.getPosition())

    }
}
