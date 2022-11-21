package viewer

import com.RafaelNTeixeira.projeto.Graphics.GUI
import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Lose
import spock.lang.Specification

class LoseViewerTest extends Specification {
    private def gui
    private def lose
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        lose = Mock(Lose.class)
        position = Mock(Position.class)
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