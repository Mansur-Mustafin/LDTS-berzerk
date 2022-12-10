package com.RafaelNTeixeira.projeto.model.game.elements

import com.RafaelNTeixeira.projeto.model.game.Position
import spock.lang.Specification

class HealthTest extends Specification{

    def 'Health creation' () {
        given:
        Health health = new Health(50, 50)
        Position position = new Position(50, 50)

        when:
        Position position1 = health.getPosition()

        then:
        position == position1
    }

}
