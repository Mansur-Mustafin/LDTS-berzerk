
import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.States.GameState
import com.RafaelNTeixeira.projeto.States.LoseState
import com.RafaelNTeixeira.projeto.States.MenuState
import com.RafaelNTeixeira.projeto.States.State
import com.RafaelNTeixeira.projeto.controller.game.ArenaController
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.menu.Lose
import spock.lang.Specification

import java.awt.Menu

class GameTest extends Specification{


    def 'Game creation'() {
        when:
        Game game = new Game()

        then:
        game.getState() instanceof MenuState
    }

    def 'Changing states'() {
        given:
        Game game = new Game()
        Lose lose = new Lose(10)
        Arena aa = Mock(Arena.class)
        GameState gameState = new GameState(aa)
        LoseState loseState = new LoseState(lose)

        when:
        game.setState(gameState)
        State s = game.getState()
        game.setOldState(loseState)
        State o = game.getOldState()

        then:
        s instanceof GameState
        o instanceof LoseState
        lose.getScore() == 10
    }

}
