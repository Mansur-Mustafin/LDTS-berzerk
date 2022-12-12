package com.l12gr05.projeto.model.game.elements.enemy


import com.l12gr05.projeto.model.game.elements.Enemy.Boss
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.Move.KingMoveStrategy
import com.l12gr05.projeto.model.game.elements.Enemy.Move.Move
import spock.lang.Specification

class BossTest extends Specification{

    def 'Constructor'() {
        given:
        Boss boss = new Boss(10, 10)
        Position pos = new Position(10, 10)

        when:
        Position pos1 = boss.getPosition()

        then:
        pos == pos1
    }

    def 'Move Strategy'() {
        given:
        Boss boss = new Boss(10, 10)

        when:
        Move moveStrategy = boss.generateMoveStrategy()

        then:
        moveStrategy.class == KingMoveStrategy

    }
}
