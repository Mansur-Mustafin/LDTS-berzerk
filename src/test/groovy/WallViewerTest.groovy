import com.RafaelNTeixeira.projeto.Graphics.GUI
import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import com.RafaelNTeixeira.projeto.viewer.GameViewer
import com.RafaelNTeixeira.projeto.viewer.WallViewer
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import spock.lang.Specification

class WallViewerTest extends Specification {
    private def gui

    private def wall


    void setup() {
        wall = Mock(Wall.class)
        gui = Mock(GUILaterna.class)
    }

    def 'a' () {
        given:
        WallViewer x = new WallViewer()

        when:
        x.draw(wall, gui)

        then:
        1 * gui.drawWall(wall.getPosition())

    }
}
