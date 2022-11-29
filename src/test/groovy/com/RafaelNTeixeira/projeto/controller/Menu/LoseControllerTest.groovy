package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController
import com.RafaelNTeixeira.projeto.controller.menu.LoseController
import com.RafaelNTeixeira.projeto.model.menu.Leader
import com.RafaelNTeixeira.projeto.model.menu.Lose
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class LoseControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def loseController

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        loseController = new LoseController(new Lose(10))
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        loseController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        loseController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        loseController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        int x = new Integer(loseController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        loseController.step(game,key,time)
        then:
        x != loseController.getModel().getCurrentEntry()
        loseController.getModel().getCurrentEntry() == loseController.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        int x = new Integer(loseController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        loseController.step(game,key,time)
        then:
        x != loseController.getModel().getCurrentEntry()
        loseController.getModel().getCurrentEntry() == 1
    }
}
