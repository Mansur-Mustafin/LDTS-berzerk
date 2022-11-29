package com.RafaelNTeixeira.projeto.state

import com.RafaelNTeixeira.projeto.States.LoseState
import com.RafaelNTeixeira.projeto.controller.menu.LoseController
import com.RafaelNTeixeira.projeto.model.menu.Lose
import com.RafaelNTeixeira.projeto.viewer.LoseViewer
import spock.lang.Specification

class LoseStateTest extends Specification{

    private def lose

    def setup() {
        lose = new Lose(10)
    }

    def 'Get viewer'() {
        given:
        LoseState loseState = new LoseState(lose)
        LoseViewer viewer = new LoseViewer(lose)

        when:
        LoseViewer loseViewer = loseState.getViewer()
        int x = loseViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get controller'(){
        given:
        LoseState loseState = new LoseState(lose)
        LoseController controller = new LoseController(lose)

        when:
        LoseController loseController = loseState.getController()
        int x = loseController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
