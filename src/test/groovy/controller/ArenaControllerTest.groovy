package controller

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.Graphics.GUI
import com.RafaelNTeixeira.projeto.States.MenuState
import com.RafaelNTeixeira.projeto.controller.game.ArenaController
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.model.menu.Menu
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import org.mockito.Mockito
import spock.lang.Specification

class ArenaControllerTest extends Specification{
    private def arena
    private def Acontrol
    private def game
    private def key
    private def time
    private def arenaController
    def setup(){
        arena = Mock(Arena.class)
        Acontrol = new ArenaController(arena)
         game = Mock(Game.class)
         key = Mock(KeyStroke.class)
         time = 5000
        arenaController = new ArenaController(new Arena(100,60))
    }

    def 'test step QUIT'(){
        given:
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'q';

        when:
        Acontrol.step(game, key, time)

        then:
        1 * game.setState(_)
    }

    def 'test step EXIT'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e';

        when:
        arenaController.step(game, key, time)

        then:
        1 * game.setState(_)
    }

    def 'test step < erergy'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'x';
        arenaController.getModel().getHero().setEnergy(-10);

        when:
        arenaController.step(game, key, time)

        then:
        1 * game.setState(_)
    }

    def 'test step Escape'(){
        given:
        key.getKeyType() >> KeyType.Escape ;

        when:
        arenaController.step(game, key, time)

        then:
        1 * game.setState(_)
        1 * game.setOldState(_)
    }
}
