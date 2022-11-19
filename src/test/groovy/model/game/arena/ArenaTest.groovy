package model.game.arena

import com.RafaelNTeixeira.projeto.model.game.arena.Arena
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




}
