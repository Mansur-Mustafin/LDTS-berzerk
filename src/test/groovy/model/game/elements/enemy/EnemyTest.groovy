package model.game.elements.enemy

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class EnemyTest extends Specification{

    private def textGraphics


    def setup () {
        textGraphics = Mock(TextGraphics.class)
    }

    def 'Draw' () {
        given:
        Monster monster = new Monster(10, 10)

        when:
        monster.draw(textGraphics)

        then:
        1*textGraphics.setForegroundColor(_)
        1*textGraphics.enableModifiers(_)
        1*textGraphics.putString(_,_)
    }

    def 'Position getter'() {
        given:
        Monster monster = new Monster(50, 30)
        Position position = new Position(50, 30)

        when:
        Position position1 = monster.getPosition()

        then:
        position == position1
    }

    def 'Position setter'() {
        given:
        Monster monster = new Monster(10, 10)
        Position position = new Position(50, 30)

        when:
        monster.setPosition(position)

        then:
        monster.getPosition() == position
    }
/*
    def 'Move'() {
        given:
        Monster monster = new Monster(10, 10)
        Position position = new Position(10, 10)

        when:
        Position position1 = monster.move()

        then:
        position == position1
    }
    */
}
