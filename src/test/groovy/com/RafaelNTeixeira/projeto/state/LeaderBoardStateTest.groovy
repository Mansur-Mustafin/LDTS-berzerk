package com.RafaelNTeixeira.projeto.state

import com.RafaelNTeixeira.projeto.States.LeaderBoardState
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController
import com.RafaelNTeixeira.projeto.model.menu.Leader
import com.RafaelNTeixeira.projeto.viewer.menuViewer.LeaderViewer
import spock.lang.Specification

class LeaderBoardStateTest extends Specification{

    private def leaderBoard

    def setup() {
        leaderBoard = new Leader()
    }

    def 'Get Viewer'() {
        given:
        LeaderBoardState leaderBoardState = new LeaderBoardState(leaderBoard)
        LeaderViewer viewer = new LeaderViewer(leaderBoard)

        when:
        LeaderViewer leaderViewer = leaderBoardState.getViewer()
        int x = leaderViewer.getModel().getNumberOfplayers()

        then:
        x == viewer.getModel().getNumberOfplayers()
    }

    def 'Get Controller'() {
        given:
        LeaderBoardState leaderBoardState = new LeaderBoardState(leaderBoard)
        LeaderController controller = new LeaderController(leaderBoard)

        when:
        LeaderController leaderController = leaderBoardState.getController()
        int x = leaderBoardState.getModel().getNumberOfplayers()

        then:
        x == controller.getModel().getNumberOfplayers()
    }
}
