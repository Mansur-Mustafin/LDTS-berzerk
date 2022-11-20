package viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Lose
import spock.lang.Specification

class LoseViewer extends Specification {
    private def gui
    private def lose
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        lose = Mock(Lose.class)
        position = Mock(Position.class)
    }

    def 'Color and text check on You Lose Meni and You Lose Draw'() {
        given:
        com.RafaelNTeixeira.projeto.viewer.LoseViewer lose_viewer = new com.RafaelNTeixeira.projeto.viewer.LoseViewer(lose)
        String color = "#FFFFFF"
        String text = "You LOSE!"

        when:
        lose_viewer.drawElements(gui)

        then:
        color == "#FFFFFF"
        text == "You LOSE!"
        0 * gui.drawText(position,text, color)
    }

    def 'Switch of Colors on Lose Menu'() {
        given:
        String color1 = "#FFD700"
        String color2 = "#FFFFFF"

        when:
        for (int i = 0; i < lose.getNumberEntries(); i++) {
            gui.drawText(position, lose.getNumberEntries(), lose.isSelected(i) ? color1 : color2)
        }

        then:
        (color1 == "#FFD700") && (color2 == "#FFFFFF")
    }
}
