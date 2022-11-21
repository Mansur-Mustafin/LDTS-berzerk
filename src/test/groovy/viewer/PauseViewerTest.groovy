package viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Pause
import com.RafaelNTeixeira.projeto.viewer.PauseViewer
import spock.lang.Specification

class PauseViewerTest extends Specification {
    private def gui
    private def pause_menu
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        pause_menu = Mock(Pause.class)
        position = Mock(Position.class)
    }

    def 'Pause Draw and text and color check'() {
        given:
        PauseViewer pause_viewer = new PauseViewer(pause_menu)
        String text = "Pause"
        String color = "#FFFFFF"

        when:
        pause_viewer.drawElements(gui)

        then:
        (text == "Pause") && (color == "#FFFFFF")
        0 * gui.drawText(position, text, color)
    }

    def 'Switch of Colors on Pause Menu'() {
        given:
        String color1 = "#FFD700"
        String color2 = "#FFFFFF"

        when:
        for (int i = 0; i < pause_menu.getNumberEntries(); i++) {
            gui.drawText(position, pause_menu.getNumberEntries(), pause_menu.isSelected(i) ? color1 : color2);
        }

        then:
        (color1 == "#FFD700") && (color2 == "#FFFFFF")
    }
}
