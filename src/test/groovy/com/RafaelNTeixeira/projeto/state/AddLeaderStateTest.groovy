package com.RafaelNTeixeira.projeto.state

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.States.AddLeaderState
import com.RafaelNTeixeira.projeto.controller.menu.AddLeaderController
import com.RafaelNTeixeira.projeto.model.menu.AddLeader
import com.RafaelNTeixeira.projeto.viewer.menuViewer.AddLeaderViewer
import spock.lang.Specification

class AddLeaderStateTest extends Specification{
    private def addLeader

    def setup() {
        addLeader = new AddLeader(10)
    }

    def 'Get Viewer'(){
        given:
        AddLeaderState leaderState = new AddLeaderState(addLeader)
        AddLeaderViewer viewer = new AddLeaderViewer(addLeader)

        when:
        AddLeaderViewer leaderViewer = leaderState.getViewer()
        int x = leaderViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get controller'() {
        given:
        AddLeaderState leaderState = new AddLeaderState(addLeader)
        AddLeaderController leaderController = leaderState.getController()

        when:
        int x = leaderController.getModel().getNumberEntries()

        then:
        x == 2

    }

    def 'Get controller 2'() {
        given:
        def addLeader = Mock(AddLeader.class)
        def Lstate = new AddLeaderState(addLeader)

        when:
        def x = Lstate.getController()

        then:
        x instanceof AddLeaderController

    }

    def 'Sate test'() {
        given:
        def addLeader = Mock(AddLeader.class)
        def v = Mock(AddLeaderViewer.class)
        def c = Mock(AddLeaderController.class)
        def game = Mock(Game.class)
        def gui = Mock(GUILaterna.class)
        def time = 5000
        def Lstate = new AddLeaderState(addLeader)
        Lstate.setViewer(v)
        Lstate.setController(c)

        when:
        Lstate.step(game, gui, time)

        then:
        1 * gui.getNextAction();
        1 * c.step(game, _, time)
        1 * v.draw(gui)
    }
}
