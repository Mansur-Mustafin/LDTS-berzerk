package com.RafaelNTeixeira.projeto.viewer.menuViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Pause
import com.RafaelNTeixeira.projeto.viewer.menuViewer.PauseViewer
import spock.lang.Specification

class PauseViewerTest extends Specification {
    private def gui
    private def pause_menu
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        pause_menu = Mock(Pause.class)
        position = Mock(Position.class)
    }

    def 'Pause Text Draw'() {
        given:
        def pause_viewer = new PauseViewer(new Pause())

        when:
        pause_viewer.drawElements(gui)

        then:
        5 * gui.drawText(_, _, _)
    }
}
