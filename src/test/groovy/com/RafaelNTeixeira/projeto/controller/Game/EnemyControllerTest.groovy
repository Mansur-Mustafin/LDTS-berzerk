package com.RafaelNTeixeira.projeto.controller.Game

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.game.EnemyController
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.googlecode.lanterna.input.KeyStroke
import spock.lang.Specification

class EnemyControllerTest extends Specification{
    private def a1;
    private def a2;
    private def enemyController1
    private def enemyController2
    private def game
    private def key
    private def time

    def setup(){
        a1 = new Arena(34,24,1)
        a2 = new Arena(34,24,6)
        enemyController1 = new EnemyController(a1)
        enemyController2 = new EnemyController(a2)
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
         !enemyController1.canMonsterMove(p)
         !enemyController1.canMonsterMove(p2)
         !enemyController1.canMonsterMove(p3)
         !enemyController1.canMonsterMove(p4)
         !enemyController1.canMonsterMove(p5)
         !enemyController1.canMonsterMove(p6)
         !enemyController1.canMonsterMove(w)
         !enemyController1.canMonsterMove(m)
         !enemyController1.canMonsterMove(k)
          enemyController1.canMonsterMove(p7)
        enemyController1.canMonsterMove(p8)
        enemyController1.canMonsterMove(p9)
        enemyController1.canMonsterMove(p10)
        enemyController1.canMonsterMove(p11)
        !enemyController1.canMonsterMove(p12)
    }

    def 'test Shoot'(){
        expect:
        enemyController1.DirOfShoot(new Position(7,21)) == 'u'
        enemyController1.DirOfShoot(new Position(7, 19)) == 'd'
        enemyController1.DirOfShoot(new Position(6,20)) == 'r'
        enemyController1.DirOfShoot(new Position(8, 20)) == 'l'
        enemyController1.DirOfShoot(new Position(3,3)) == 'n'
        enemyController1.DirOfShoot(new Position(7,20)) == 'd'
    }


    def 'test lastSpawn 200 '(){
        given:
        def time2 = 200
        def i = enemyController2.getModel().getMonsters().size()
        when:
        enemyController2.step(game, key, time2)
        then:
        i == 0
    }

    def 'test lastSpawn 6000 '(){
        given:
        def time2 = 6000
        def i = enemyController2.getModel().getMonsters().size()
        when:
        enemyController2.step(game, key, time2)
        then:
        i == enemyController2.getModel().getMonsters().size()
    }

    def 'test lastSpawn 6001 '(){
        given:
        def time2 = 6001
        def i = enemyController2.getModel().getMonsters().size()
        when:
        enemyController2.step(game, key, time2)
        then:
        i + 2 == enemyController2.getModel().getMonsters().size()
    }

    def 'test lastSpawn + or - '(){
        given:
        def time2 = 5900
        def i = enemyController2.getModel().getMonsters().size()
        enemyController2.lastSpawn(200)
        when:
        enemyController2.step(game, key, time2)
        then:
        i == enemyController2.getModel().getMonsters().size()
    }

    def 'test MovementEnemy 200 '(){
        given:
        def time2 = 200
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x == enemyController2.getModel().getBoss().getPosition().getX()
        y == enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test lastSpawn 6000 '(){
        given:
        def time2 = 800
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x == enemyController2.getModel().getBoss().getPosition().getX()
        y == enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test lastSpawn 6001 '(){
        given:
        def time2 = 801
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x != enemyController2.getModel().getBoss().getPosition().getX() || y != enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test lastSpawn + or - '(){
        given:
        def time2 = 790
        enemyController2.lastMovementBoss(200)
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x == enemyController2.getModel().getBoss().getPosition().getX()
        y == enemyController2.getModel().getBoss().getPosition().getY()
    }
}
