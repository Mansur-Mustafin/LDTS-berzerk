package com.RafaelNTeixeira.projeto.viewer.menuViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Leader
import com.RafaelNTeixeira.projeto.viewer.menuViewer.LeaderViewer
import spock.lang.Specification

class LeaderViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'LeaderBoard Text Draw'() {
        given:
        def leader_viewer = new LeaderViewer(new Leader())
        def gui = Mock(GUILaterna.class)

        when:
        leader_viewer.drawElements(gui)

        then:
        22 * gui.drawText(_,_,_)
    }
}
