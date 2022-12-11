package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.AddLeaderController
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController
import com.RafaelNTeixeira.projeto.model.menu.AddLeader
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class AddLeaderControllerTest extends Specification{
    private def game
    private def key
    private def time
    private def leaderController
    private def instance


    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        leaderController = new AddLeaderController(new AddLeader(10))
        instance = Mock(SoundControl.class)
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
        leaderController.stepNotNull(game,key,time, instance)
        then:
        1 * game.setState(_)
        1 * instance.start(_)
    }

    def 'test key Char'(){
        given:
        def s = new String(leaderController.getModel().getName())
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'd'
        when:
        leaderController.stepNotNull(game,key,time, instance)
        then:
        !s.equals(leaderController.getModel().getName())
        leaderController.getModel().getName().charAt(leaderController.getModel().getName().length() - 1) == 'd';
    }

}
