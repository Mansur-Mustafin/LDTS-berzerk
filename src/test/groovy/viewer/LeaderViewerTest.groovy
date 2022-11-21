package viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.menu.Leader
import com.RafaelNTeixeira.projeto.viewer.LeaderViewer
import spock.lang.Specification

class LeaderViewerTest extends Specification {
    private def gui
    private def leaderboard
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        leaderboard = Mock(Leader.class)
        position = Mock(Position.class)
    }

    def 'Color and text check on LeaderBoard Table and LeaderBoard Draw'() {
        given:
        LeaderViewer leader_viewer = new LeaderViewer(leaderboard)
        String color1 = "#FFFFFF"
        String text1 = "Leader Board"
        String color2 = "#FFD700"
        String text2 = "Press ENTER to get Menu"

        when:
        leader_viewer.drawElements(gui)

        then:
        (color1 == "#FFFFFF") && (color2 == "#FFD700")
        (text1 == "Leader Board") && (text2 == "Press ENTER to get Menu")

        0 * gui.drawText(position, text1, color1)
        0 * gui.drawText(position, text2, color2)
    }
}
