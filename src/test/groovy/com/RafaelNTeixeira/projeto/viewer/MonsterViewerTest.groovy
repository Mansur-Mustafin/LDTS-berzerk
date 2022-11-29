package com.RafaelNTeixeira.projeto.viewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster
import com.RafaelNTeixeira.projeto.viewer.MonsterViewer
import spock.lang.Specification

class MonsterViewerTest extends Specification {
    private def gui
    private def monster


    void setup() {
        monster = Mock(Monster.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Monster Draw'() {
        given:
        def monster_viewer = new MonsterViewer()

        when:
        monster_viewer.draw(monster, gui)

        then:
        1 * gui.drawMonster(monster.getPosition())
    }
}
