package com.RafaelNTeixeira.projeto.controller.Game

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.game.EnemyController
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.googlecode.lanterna.input.KeyStroke
import spock.lang.Specification

class EnemyControllerTest extends Specification{
    private Arena a;
    private EnemyController enemyController
    private def game
    private def key
    private def time

    def setup(){
        a = new Arena(34,24,1)
        enemyController = new EnemyController(a)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
    }

    def 'test of can move'(){
        given:
        Position p = new Position(112, 3)
        Position p2 = new Position(-12, 3)
        Position p3 = new Position(1, 300)
        Position p4 = new Position(1, -3)
        Position p5 = new Position(112, 312)
        Position p6 = new Position(-112, -3)
        Position w = new Position(0,7 )
        when:
        def r = enemyController.canMonsterMove(p)
        def r2 = enemyController.canMonsterMove(p2)
        def r3 = enemyController.canMonsterMove(p3)
        def r4 = enemyController.canMonsterMove(p4)
        def r5 = enemyController.canMonsterMove(p5)
        def r6 = enemyController.canMonsterMove(p6)
        def r7 = enemyController.canMonsterMove(w)
        then:
        !r
        !r2
        !r3
        !r4
        !r5
        !r6
        !r7
    }

    def 'test time < 500'(){
        given:
        time = 400
        Position p = new Position(enemyController.getModel().getMonsters().get(0).getPosition().x, enemyController.getModel().getMonsters().get(0).getPosition().y)
        when:
        enemyController.step(game,key,time)
        then:
        enemyController.getModel().getMonsters().get(0).getPosition().x == p.x
        enemyController.getModel().getMonsters().get(0).getPosition().y == p.y
    }

    def 'test time > 500'(){
        given:
        time = 400
        Position p = new Position(enemyController.getModel().getMonsters().get(0).getPosition().x, enemyController.getModel().getMonsters().get(0).getPosition().y)
        when:
        enemyController.step(game,key,time)
        then:
        enemyController.getModel().getMonsters().get(0).getPosition().x == p.x
        enemyController.getModel().getMonsters().get(0).getPosition().y == p.y
    }
}
