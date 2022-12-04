package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.WinController
import com.RafaelNTeixeira.projeto.model.menu.Win
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class WinControllerTest extends Specification{
    private def game
    private def key
    private def time
    private def winController

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        winController = new WinController(new Win(10))
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        winController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        winController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        winController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        int x = new Integer(winController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        winController.step(game,key,time)
        then:
        x != winController.getModel().getCurrentEntry()
        winController.getModel().getCurrentEntry() == winController.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        int x = new Integer(winController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        winController.step(game,key,time)
        then:
        x != winController.getModel().getCurrentEntry()
        winController.getModel().getCurrentEntry() == 1
    }
}
