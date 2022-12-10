package com.RafaelNTeixeira.projeto.model.game.elements

import com.RafaelNTeixeira.projeto.model.game.Position

import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.NotMovingStrategy

import spock.lang.Specification

class BulletTest extends Specification{


    def 'Bullet creation'() {
        given:
        boolean b = true
        Bullet bulletr = new Bullet(10, 10, 'r' as char, b)
        Bullet bulleta = new Bullet(10, 10, 'a' as char, b)

        when:
        boolean f1 = bulletr.isHeroBullet()

        then:

        f1
    }

    def 'Set and get position'(){
        given:
        Position position = new Position(10, 10)
        Position position1 = new Position(20, 20)
        boolean b = true
        Bullet bullet = new Bullet(10, 10, 'r' as char, b)

        when:
        Position position2 = bullet.getPosition()
        bullet.setPosition(position1)

        then:
        position == position2
        bullet.getPosition() == position1
    }

    def 'Move'() {
        given:
        List<Wall> walls;
        Position position = new Position(20, 19)
        boolean b = true
        Bullet bullet = new Bullet(20, 20, 'u' as char, b)



        when:
        Position position1 = bullet.move()

        then:
        position == position1
    }
}
