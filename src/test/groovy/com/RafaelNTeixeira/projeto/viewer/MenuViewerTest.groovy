package com.RafaelNTeixeira.projeto.viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Menu
import com.RafaelNTeixeira.projeto.viewer.MenuViewer
import spock.lang.Specification

class MenuViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'Menu Text Draw'() {
        given:
        def menu_viewer = new MenuViewer(new Menu())

        when:
        menu_viewer.drawElements(gui)

        then:
        5 * gui.drawText(_,_, _)
    }
}

