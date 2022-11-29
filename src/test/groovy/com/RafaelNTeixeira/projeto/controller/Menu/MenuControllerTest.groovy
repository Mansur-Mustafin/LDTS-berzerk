package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.LoseController
import com.RafaelNTeixeira.projeto.controller.menu.MenuController
import com.RafaelNTeixeira.projeto.model.menu.Lose
import com.RafaelNTeixeira.projeto.model.menu.Menu
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class MenuControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def menuController

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        menuController = new MenuController(new Menu())
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        menuController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        menuController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        menuController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        int x = new Integer(menuController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        menuController.step(game,key,time)

        then:
        x != menuController.getModel().getCurrentEntry()
        menuController.getModel().getCurrentEntry() == menuController.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        int x = new Integer(menuController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        menuController.step(game,key,time)
        then:
        x != menuController.getModel().getCurrentEntry()
        menuController.getModel().getCurrentEntry() == 1
    }
}
