package model.game.arena

import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import spock.lang.Specification

class ArenaTest extends Specification{
    private def arena
    private def wall_list

    def setup() {
        arena = new Arena(50, 50)
        wall_list = new ArrayList<Wall>()
    }

    void 'Creation Arena'() {
        when:
        int x = arena.getHeight()
        int y = arena.getWidth()

        then:
        x == 50
        y == 50
    }

    def 'Get hero'() {
        given:
        Hero hero = new Hero(17, 52)

        when:
        Hero hero1 = arena.getHero()

        then:
        hero.getPosition() == hero1.getPosition()
    }

    def 'Get King'() {
        given:
        Position pos = new Position(84, 5)
        Position pos1 = new Position(17, 2)
        List<King> kingList= arena.getKings()
        boolean flag = false
        boolean flag2 = true

        when:
        for (King k : kingList) {
            if(k.getPosition() == pos) {
                flag = true
            }
            if(k.getPosition() == pos1){
                flag2 = false
            }
        }

        then:
        flag && flag2
    }

    def 'Get Walls' () {
        given:
        Position pos = new Position(0, 0)
        Position pos1 = new Position(1, 1)
        List<Wall> wallList= arena.getWalls()
        boolean flag = false
        boolean flag2 = true

        when:
        for (Wall w : wallList) {
            if(w.getPosition() == pos) {
                flag = true
            }
            if(w.getPosition() == pos1){
                flag2 = false
            }
        }

        then:
        flag && flag2
    }

    def 'getMonsters'() {
        given:
        Position pos = new Position(44, 12)
        Position pos1 = new Position(1, 1)
        List<Monster> monsterList= arena.getMonsters()
        boolean flag = false
        boolean flag2 = true

        when:
        for (Monster m : monsterList) {

            if(m.getPosition() == pos) {
                flag = true
            }
            if(m.getPosition() == pos1){
                flag2 = false
            }
        }

        then:
        flag && flag2
    }
}
