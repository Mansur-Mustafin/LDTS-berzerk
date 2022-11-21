package viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.AddLeader
import com.RafaelNTeixeira.projeto.viewer.AddLeaderViewer
import com.RafaelNTeixeira.projeto.viewer.LeaderViewer
import spock.lang.Specification

class AddLeaderViewerTest extends Specification {
    private def gui
    private def add_leader
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        add_leader = Mock(AddLeader.class)
        position = Mock(Position.class)
    }

    def 'Color and text check on LeaderBoard Table and LeaderBoard Draw'() {
        given:
        AddLeaderViewer add_leader_viewer = new AddLeaderViewer(add_leader)
        String color = "#FFFFFF"
        String text1 = "Enter your name:"
        String text2 = "Your Score: 999"

        when:
        add_leader_viewer.drawElements(gui)

        then:
        (color == "#FFFFFF") && (text1 == "Enter your name:") && (text2 == "Your Score: 999")

        0 * gui.drawText(position, text1, color)
        0 * gui.drawText(position, text2, color)
    }
}
