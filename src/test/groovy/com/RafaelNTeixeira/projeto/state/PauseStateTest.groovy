package com.RafaelNTeixeira.projeto.state

import com.RafaelNTeixeira.projeto.States.PauseState
import com.RafaelNTeixeira.projeto.controller.menu.PauseController
import com.RafaelNTeixeira.projeto.model.menu.Pause
import com.RafaelNTeixeira.projeto.viewer.menuViewer.PauseViewer
import spock.lang.Specification

class PauseStateTest extends Specification{

    private def pause

    def setup(){
        pause = new Pause()
    }

    def 'Get viewer'() {
        given:
        PauseState pauseState = new PauseState(pause)
        PauseViewer viewer = new PauseViewer(pause)

        when:
        PauseViewer pauseViewer = pauseState.getViewer()
        int x = pauseViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get controller'() {
        given:
        PauseState pauseState = new PauseState(pause)
        PauseController controller = new PauseController(pause)

        when:
        PauseController pauseController = pauseState.getController()
        int x = pauseController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
