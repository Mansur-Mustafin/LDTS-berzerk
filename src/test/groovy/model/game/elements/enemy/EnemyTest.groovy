package model.game.elements.enemy

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.KingMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MonsterMoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class EnemyTest extends Specification{

    private def textGraphics
    private def pos


    def setup () {
        textGraphics = Mock(TextGraphics.class)
        pos = Mock(Position.class)
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





    def 'Get Move Strategy'() {

        given:
        Monster monster = new Monster(10, 10)
        MoveStrategy moveStrategy = new MonsterMoveStrategy()

        when:
        MoveStrategy moveStrategy1 = monster.getMoveStrategy()

        then:
        moveStrategy.getClass() == moveStrategy1.getClass()
    }




    def 'Set move strategy'() {
        given:
        Monster monster = new Monster(10, 10)
        MoveStrategy moveStrategy = new KingMoveStrategy()

        when:
        monster.setMoveStrategy(moveStrategy)

        then:
        monster.getMoveStrategy().getClass() == new KingMoveStrategy().getClass()


    }

    /*def 'Move'() {
        given:
        Monster monster = new Monster(10, 10)
        def pos_hero = Mock(Position.class)
        def walls = Mock(List<Wall>.class)
        def strategy = Mock(MoveStrategy.class)

        strategy.move(_) >> new Position(1,2)
        monster.setMoveStrategy(strategy)

        when:
        def position = monster.move(pos_hero, walls)

        then:
        position.x == 1
        position.y == 2
    }*/

}
