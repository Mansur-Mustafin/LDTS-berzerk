package controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.MenuController
import com.RafaelNTeixeira.projeto.controller.menu.PauseController
import com.RafaelNTeixeira.projeto.model.menu.Menu
import com.RafaelNTeixeira.projeto.model.menu.Pause
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class PauseControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def pauseController

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        pauseController = new PauseController(new Pause())
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        pauseController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        pauseController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key char e'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        pauseController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key char q'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'q'

        when:
        pauseController.step(game,key,time)

        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        int x = new Integer(pauseController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        pauseController.step(game,key,time)

        then:
        x != pauseController.getModel().getCurrentEntry()
        pauseController.getModel().getCurrentEntry() == pauseController.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        int x = new Integer(pauseController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        pauseController.step(game,key,time)
        then:
        x != pauseController.getModel().getCurrentEntry()
        pauseController.getModel().getCurrentEntry() == 1
    }
}
