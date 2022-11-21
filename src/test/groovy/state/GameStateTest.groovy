package state

import com.RafaelNTeixeira.projeto.States.GameState
import com.RafaelNTeixeira.projeto.controller.game.ArenaController
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.viewer.GameViewer
import spock.lang.Specification

class GameStateTest extends Specification{

    private def arena

    def setup() {
        arena = new Arena(50, 50)
    }

    def 'Get Viewer'(){
        given:
        GameState gameState = new GameState(arena)
        GameViewer gameViewer = new GameViewer(arena)

        when:
        GameViewer gameViewer1 = gameState.getViewer()

        then:
        gameViewer.getModel() == gameViewer1.getModel()
    }

    def 'Get controller'() {
        given:
        GameState gameState = new GameState(arena)
        ArenaController arenaController = new ArenaController(arena)

        when:
        ArenaController controller = gameState.getController()

        then:
        controller.getModel() == arenaController.getModel()
    }
}
