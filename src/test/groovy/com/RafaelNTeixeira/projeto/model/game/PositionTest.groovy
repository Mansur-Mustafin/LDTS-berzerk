package com.RafaelNTeixeira.projeto.model.game

import com.RafaelNTeixeira.projeto.model.game.Position
import spock.lang.Specification

class PositionTest extends Specification{

    def 'Constructor without parameters' () {
        given:
        Position position = new Position()

        when:
        int x = position.getX()
        int y = position.getY()

        then:
        x == 10
        y == 10

    }

    def 'Position getters' () {

        given:
        Position position = new Position(50, 30)

        when:
        int x = position.getX()
        int y = position.getY()

        then:
        x == 50
        y == 30
    }

    def 'Position setters' () {
        given:
        Position position = new Position(50, 30)

        when:
        position.setX(30)
        position.setY(50)

        then:
        position.getX() == 30
        position.getY() == 50
    }

    def 'Position add' () {
        given:
        Position position = new Position(50, 30)
        Position position1 = new Position(10, 10)

        when:
        Position position2 = position.add(position1)

        then:
        position2.getX() == 60
        position2.getY() == 40
    }

    def 'Get distance' () {
        given:
        Position position = new Position(3,0)
        Position position1 = new Position(0,4)

        when:
        double distance = position.getDistance(position1)

        then:
        distance == 5
    }

    def 'equals' () {

        given:
        Position position = new Position(50, 30)
        Position position1 = new Position(30, 40)
        Position position2 = new Position(50, 30)

        when:
        boolean equals = position.equals(position1)
        boolean equals1 = position2.equals(position)

        then:
        !equals
        equals1
    }
}
