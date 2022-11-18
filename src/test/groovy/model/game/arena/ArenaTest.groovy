package model.game.arena

import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import spock.lang.Specification

class ArenaTest extends Specification{
    private Arena arena = new Arena(50, 50)
    private List<Wall> wall_list = new ArrayList<Wall>()


    void 'Creation Arena'() {
        when:
        int x = arena.getHeight()
        int y = arena.getWidth()

        then:
        x == 50
        y == 50
    }

    void 'Arena Walls' () {
        given:
        wall_list = arena.getWalls()

        when:
        Arena arena1 = new Arena(50, 50)


        then:
        arena1.getWalls() == wall_list
    }


}
