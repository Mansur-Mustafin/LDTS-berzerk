package com.RafaelNTeixeira.projeto.viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Win
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
        7 * gui.drawText(_,_,_)
    }
}
