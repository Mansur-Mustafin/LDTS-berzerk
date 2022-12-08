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
        int n_of_players = 2+(2*(leader_viewer.getModel().getNumberOfplayers()))
        if(n_of_players > 22) {
            n_of_players = 22
        }

        when:
        leader_viewer.drawElements(gui)

        then:
        n_of_players * gui.drawText(_,_,_)
    }
}
