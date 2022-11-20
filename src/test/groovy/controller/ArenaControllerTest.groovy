package controller

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.Graphics.GUI
import com.RafaelNTeixeira.projeto.States.MenuState
import com.RafaelNTeixeira.projeto.controller.game.ArenaController
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import spock.lang.Specification

class ArenaControllerTest extends Specification{
    private def arena
    private def Acontrol
    def setup(){
        arena = Mock(Arena.class)
        Acontrol = new ArenaController(arena)
    }

    def 'test step QUIT'(){
        given:
        def game = Mock(Game.class)
        def action = GUI.ACTION.QUIT
        def time = 5000
        def menuState = Mock(MenuState.class)
        when:
        Acontrol.step(game, action, time)
        then:
        1 * game.setState(menuState)
    }

}
