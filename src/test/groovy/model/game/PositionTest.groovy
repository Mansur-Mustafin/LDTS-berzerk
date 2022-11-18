package model.game

import com.RafaelNTeixeira.projeto.model.game.Position
import spock.lang.Specification

class PositionTest extends Specification{

    def 'Position getters and setters' () {

        given:
        Position position = new Position(50, 30)

        when:
        int x = position.getX()
        int y = position.getY()

        then:
        x == 50
        y == 30
    }


}
