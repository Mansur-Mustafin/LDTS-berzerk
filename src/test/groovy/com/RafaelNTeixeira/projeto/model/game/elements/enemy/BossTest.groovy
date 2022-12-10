package com.RafaelNTeixeira.projeto.model.game.elements.enemy

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Boss
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.BFSMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.NotMovingStrategy
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
        MoveStrategy moveStrategy = boss.generateMoveStrategy()

        then:
        moveStrategy.class == BFSMoveStrategy

    }
}
