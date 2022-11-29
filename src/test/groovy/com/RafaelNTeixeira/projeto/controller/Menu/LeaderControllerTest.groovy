package com.RafaelNTeixeira.projeto.controller.Menu

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.menu.InstructionController
import com.RafaelNTeixeira.projeto.controller.menu.LeaderController
import com.RafaelNTeixeira.projeto.model.menu.Instruction
import com.RafaelNTeixeira.projeto.model.menu.Leader
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class LeaderControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def leaderController

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        leaderController = new LeaderController(new Leader())
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
        key.getKeyType() >>> KeyType.Enter;

        when:
        leaderController.step(game,key,time)
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
