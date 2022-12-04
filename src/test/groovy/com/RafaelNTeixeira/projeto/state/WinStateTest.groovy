package com.RafaelNTeixeira.projeto.state

import com.RafaelNTeixeira.projeto.States.WinState
import com.RafaelNTeixeira.projeto.controller.menu.WinController
import com.RafaelNTeixeira.projeto.model.menu.Win
import com.RafaelNTeixeira.projeto.viewer.WinViewer
import spock.lang.Specification

class WinStateTest extends Specification{
    private def win

    def setup() {
        win = new Win(10)
    }

    def 'Get viewer'() {
        given:
        WinState winState = new WinState(win)
        WinViewer viewer = new WinViewer(win)

        when:
        WinViewer winViewer = winState.getViewer()
        int x = winViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get controller'(){
        given:
        WinState winState = new WinState(win)
        WinController controller = new WinController(win)

        when:
        WinController winController = winState.getController()
        int x = winController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
