package com.RafaelNTeixeira.projeto.model.game.elements.enemy.Move

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.EMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.NMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.OMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.SMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import spock.lang.Specification

class MoveStrategyTest extends Specification{

    def 'N move strategy'(){
        given:
        NMoveStrategy moveStrategy = new NMoveStrategy()
        List<Wall> walls
        Position position = new Position(10, 10)
        Position position1 = new Position(10, 5)
        Position position2 = new Position(position.getX(), position.getY()-1)

        when:
        Position position3 = moveStrategy.move(position, position1, walls)

        then:
        position3 == position2
    }

    def 'S move strategy'(){
        given:
        SMoveStrategy moveStrategy = new SMoveStrategy()
        List<Wall> walls
        Position position = new Position(10, 10)
        Position position1 = new Position(10, 5)
        Position position2 = new Position(position.getX(), position.getY()+1)

        when:
        Position position3 = moveStrategy.move(position, position1, walls)

        then:
        position3 == position2
    }

    def 'E move strategy'(){
        given:
        EMoveStrategy moveStrategy = new EMoveStrategy()
        List<Wall> walls
        Position position = new Position(10, 10)
        Position position1 = new Position(10, 5)
        Position position2 = new Position(position.getX()+1, position.getY())

        when:
        Position position3 = moveStrategy.move(position, position1, walls)

        then:
        position3 == position2
    }

    def 'O move strategy'(){
        given:
        OMoveStrategy moveStrategy = new OMoveStrategy()
        List<Wall> walls
        Position position = new Position(10, 10)
        Position position1 = new Position(10, 5)
        Position position2 = new Position(position.getX()-1, position.getY())

        when:
        Position position3 = moveStrategy.move(position, position1, walls)

        then:
        position3 == position2
    }
}
