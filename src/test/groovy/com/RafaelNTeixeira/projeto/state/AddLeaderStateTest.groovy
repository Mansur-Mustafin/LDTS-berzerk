package com.RafaelNTeixeira.projeto.state

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

}
