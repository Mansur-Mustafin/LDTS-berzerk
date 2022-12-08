package com.RafaelNTeixeira.projeto.viewer.menuViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.AddLeader
import com.RafaelNTeixeira.projeto.viewer.menuViewer.AddLeaderViewer
import spock.lang.Specification

class AddLeaderViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'Add to LeaderBoard Text Draw'() {
        given:
        def add_leader_viewer = new AddLeaderViewer(new AddLeader(10))
        def gui = Mock(GUILaterna.class)

        when:
        add_leader_viewer.drawElements(gui)

        then:
        3 * gui.drawText(_,_,_)
    }
}
