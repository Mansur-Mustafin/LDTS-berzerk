package com.RafaelNTeixeira.projeto.viewer.gameViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King
import com.RafaelNTeixeira.projeto.model.game.elements.Health
import spock.lang.Specification

class HeartViewerTest extends Specification{
    private def gui
    private def heart

    void setup() {
        heart = Mock(Health.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Heart Draw'() {
        given:
        HeartViewer heart_viewer = new HeartViewer()

        when:
        heart_viewer.draw(heart, gui)

        then:
        1 * gui.drawHeart(heart.getPosition())

    }
}
