package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.AddLeaderController
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController
import com.RafaelNTeixeira.projeto.model.menu.AddLeader
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class AddLeaderControllerTest extends Specification{
    private def game
    private def key
    private def time
    private def leaderController

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        leaderController = new AddLeaderController(new AddLeader(10))
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        leaderController.step(game,key,time)
        then:
        0 * game.setState(_)
    }
    def 'test key Enter'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        when:
        leaderController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key Char'(){
        given:
        def s = new String(leaderController.getModel().getName())
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'd'
        when:
        leaderController.step(game,key,time)
        then:
        !s.equals(leaderController.getModel().getName())
        leaderController.getModel().getName().charAt(leaderController.getModel().getName().length() - 1) == 'd';
    }


}
