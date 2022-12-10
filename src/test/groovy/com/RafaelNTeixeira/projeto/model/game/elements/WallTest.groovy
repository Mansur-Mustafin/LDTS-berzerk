package com.RafaelNTeixeira.projeto.model.game.elements

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class WallTest extends Specification{

    def 'Wall creation' () {
        given:
        Wall wall = new Wall(50, 50)
        Position position = new Position(50, 50)

        when:
        Position position1 = wall.getPosition()

        then:
        position == position1
    }


}
