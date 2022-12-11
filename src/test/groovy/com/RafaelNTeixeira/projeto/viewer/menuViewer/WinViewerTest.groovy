package com.RafaelNTeixeira.projeto.viewer.menuViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Win
import com.RafaelNTeixeira.projeto.viewer.menuViewer.WinViewer
import spock.lang.Specification

class WinViewerTest extends Specification{
    private def gui
    private def lose
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'You Win Text Draw'() {
        given:
        def win_viewer = new WinViewer(new Win(10))
        def gui = Mock(GUILaterna.class)

        when:
        win_viewer.drawElements(gui)

        then:
        1 * gui.drawText(new Position(13, 7), _, "#FFD700")
        1 * gui.drawText(new Position(5, 9), _, "#FFFFFF")
        1 * gui.drawText(new Position(10, 10), _, "#FFFFFF")
        1 * gui.drawText(new Position(12, 14),_,"#FFD700")
        1 * gui.drawText(new Position(9, 15),_,"#FFFFFF")
        1 * gui.drawText(new Position(6, 16),_,"#FFFFFF")
        1 * gui.drawText(new Position(8, 11), _, "#FFFFFF")
    }
}
