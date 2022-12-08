package com.RafaelNTeixeira.projeto.viewer.gameViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.viewer.gameViewer.HeroViewer
import spock.lang.Specification

class HeroViewerTest extends Specification {
    private def gui
    private def hero


    void setup() {
        hero = Mock(Hero.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Hero Draw'() {
        given:
        def hero_viewer = new HeroViewer()

        when:
        hero_viewer.draw(hero, gui)

        then:
        1 * gui.drawHero(hero.getPosition())
    }
}
