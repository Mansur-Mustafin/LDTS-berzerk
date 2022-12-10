package com.RafaelNTeixeira.projeto.viewer.gameViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Boss
import com.RafaelNTeixeira.projeto.model.game.elements.Health
import spock.lang.Specification

class BossViewerTest extends Specification{
    private def gui
    private def boss

    void setup() {
        boss = Mock(Boss.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Boss Draw'() {
        given:
        BossViewer bossViewer = new BossViewer()

        when:
        bossViewer.draw(boss, gui)

        then:
        1 * gui.drawBoss(boss.getPosition())

    }
}
