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
    private def addLeader
    private def instance


    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        addLeader = Mock(AddLeader.class)
        leaderController = new AddLeaderController(addLeader)
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
        1 * addLeader.addScore()
        1 * instance.start(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        when:
        leaderController.step(game,key,time)
        then:
        1 * game.setState(_)
        1 * addLeader.addScore()
    }

    def 'test key Char'(){
        given:
        AddLeaderController addLeaderController = new AddLeaderController(new AddLeader(10))
        def s = new String(addLeaderController.getModel().getName())
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'd'
        when:
        addLeaderController.stepNotNull(game,key,time, instance)
        then:
        !s.equals(addLeaderController.getModel().getName())
        addLeaderController.getModel().getName().charAt(addLeaderController.getModel().getName().length() - 1) == 'd';
    }

    def 'Test key backspace name len 0'(){
        given:
        AddLeader addLeader1 = new AddLeader(10)
        addLeader1.setName('')
        AddLeaderController addLeaderController = new AddLeaderController(addLeader1)
        key.getKeyType() >> KeyType.Backspace

        when:
        addLeaderController.stepNotNull(game, key, time, instance)

        then:
        addLeader1.getName() == ''
    }

    def 'Test key backspace name len != 0'(){
        given:
        AddLeader addLeader1 = new AddLeader(10)
        addLeader1.setName('Ian')
        AddLeaderController addLeaderController = new AddLeaderController(addLeader1)
        key.getKeyType() >> KeyType.Backspace

        when:
        addLeaderController.stepNotNull(game, key, time, instance)

        then:
        addLeader1.getName() == 'Ia'
    }
}
