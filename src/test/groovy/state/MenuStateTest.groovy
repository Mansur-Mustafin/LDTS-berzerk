package state

import com.RafaelNTeixeira.projeto.States.MenuState
import com.RafaelNTeixeira.projeto.controller.menu.MenuController
import com.RafaelNTeixeira.projeto.model.menu.Lose
import com.RafaelNTeixeira.projeto.model.menu.Menu
import com.RafaelNTeixeira.projeto.viewer.MenuViewer
import spock.lang.Specification
import viewer.LoseViewerTest

class MenuStateTest extends Specification{

    private def menu

    def setup(){
        menu = new Menu()
    }

    def 'Get Viewer'() {
        given:
        MenuState menuState = new MenuState(menu)
        MenuViewer viewer = new MenuViewer(menu)

        when:
        MenuViewer menuViewer = menuState.getViewer()
        int x = menuViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get Controller'() {
        given:
        MenuState menuState = new MenuState(menu)
        MenuController controller = new MenuController(menu)

        when:
        MenuController menuController = menuState.getController()
        int x = menuController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
