package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.InstructionController
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController
import com.RafaelNTeixeira.projeto.model.menu.Instruction
import com.RafaelNTeixeira.projeto.model.menu.Leader
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class LeaderControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def leader
    private def leaderController
    private def instance

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        leader = Mock(Leader.class)
        leaderController = new LeaderController(leader)
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

    def 'test key Enter selected'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        leader.isSelectedEnter() >> true

        when:
        leaderController.stepNotNull(game,key,time,instance)

        then:
        1 * game.setState(_)
        1 * instance.stop(_)
        1 * instance.start(_)

    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        leaderController.stepNotNull(game,key,time,instance)
        then:
        1 * game.setScore(_)
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        leaderController.stepNotNull(game,key,time,instance)
        then:
        1 * game.setScore(_)

    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        leaderController.stepNotNull(game,key,time,instance)
        then:
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        leaderController.step(game,key,time)
        then:
        1 * game.setState(_)
    }
}
