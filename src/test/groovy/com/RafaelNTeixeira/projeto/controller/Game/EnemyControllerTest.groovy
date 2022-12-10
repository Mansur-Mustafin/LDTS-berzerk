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
        Position m = new Position(8,9 )
        Position k = new Position(3,4 )
        Position p7 = new Position(3, 5)
        Position p8 = new Position(7,0)
        Position p9 = new Position(33, 14)
        Position p10 = new Position(23, 23)
        Position p11 = new Position(0, 0)
        Position p12 = new Position(0, 1)

        expect:

         !enemyController.canMonsterMove(p)
         !enemyController.canMonsterMove(p2)
         !enemyController.canMonsterMove(p3)
         !enemyController.canMonsterMove(p4)
         !enemyController.canMonsterMove(p5)
         !enemyController.canMonsterMove(p6)
         !enemyController.canMonsterMove(w)
         !enemyController.canMonsterMove(m)
         !enemyController.canMonsterMove(k)
          enemyController.canMonsterMove(p7)
        enemyController.canMonsterMove(p8)
        enemyController.canMonsterMove(p9)
        enemyController.canMonsterMove(p10)
        enemyController.canMonsterMove(p11)
        !enemyController.canMonsterMove(p12)
    }

    def 'test Shoot'(){
        expect:

        enemyController.DirOfShoot(new Position(7,21)) == 'u'
        enemyController.DirOfShoot(new Position(7, 19)) == 'd'
        enemyController.DirOfShoot(new Position(6,20)) == 'r'
        enemyController.DirOfShoot(new Position(8, 20)) == 'l'
        enemyController.DirOfShoot(new Position(3,3)) == 'n'

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
