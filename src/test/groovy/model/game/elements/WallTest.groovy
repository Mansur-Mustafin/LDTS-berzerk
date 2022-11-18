package model.game.elements

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class WallTest extends Specification{

    private def textGraphics

    def setup () {
        textGraphics = Mock(TextGraphics.class)
    }

    def 'Position getter' () {
        given:
        Wall wall = new Wall(50, 50)
        Position position = new Position(50, 50)

        when:
        Position position1 = wall.getPosition()

        then:
        position == position1
    }

    def 'Draw walls'() {
        given:
        Wall wall = new Wall(10, 10)

        when:
        wall.draw(textGraphics)

        then:
        1*textGraphics.setBackgroundColor(_)
        1*textGraphics.setForegroundColor(_)
        1*textGraphics.enableModifiers(_)
        1*textGraphics.putString(_,_)
    }
}
