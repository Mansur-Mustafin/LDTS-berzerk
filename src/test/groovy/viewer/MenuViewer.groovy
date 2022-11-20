package viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Menu
import spock.lang.Specification

class MenuViewer extends Specification {
    private def gui
    private def menu
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        menu = Mock(Menu.class)
        position = Mock(Position.class)
    }

    def 'Menu Draw and text and color check'() {
        given:
        com.RafaelNTeixeira.projeto.viewer.MenuViewer menu_viewer = new com.RafaelNTeixeira.projeto.viewer.MenuViewer(menu)
        String text = "Menu"
        String color = "#FFFFFF"

        when:
        menu_viewer.drawElements(gui)

        then:
        (text == "Menu") && (color == "#FFFFFF")
        0 * gui.drawText(position,text, color)
    }

    def 'Switch of Colors on Menu'() {
        given:
        String color1 = "#FFD700"
        String color2 = "#FFFFFF"

        when:
        for (int i = 0; i < menu.getNumberEntries(); i++) {
            gui.drawText(position, menu.getEntry(i), menu.isSelected(i) ? color1 : color2);
        }

        then:
        (color1 == "#FFD700") && (color2 == "#FFFFFF")
    }
}

