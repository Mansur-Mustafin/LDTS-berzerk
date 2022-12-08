package com.RafaelNTeixeira.projeto.viewer.gameViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet
import spock.lang.Specification

class BulletViewerTest extends Specification{

    private def gui

    def 'Draw bullet'() {
        given:
        boolean t = true
        boolean f = false
        Bullet hero_bullet = new Bullet(10, 10, 'r' as char, t)
        Bullet enemy_bullet = new Bullet(10, 10, 'l' as char, f)
        gui = Mock(GUILaterna.class)
        BulletViewer bulletViewer = new BulletViewer()

        when:
        bulletViewer.draw(hero_bullet, gui)
        bulletViewer.draw(enemy_bullet, gui)

        then:
        1*gui.drawHeroBullet(_)
        1*gui.drawEnemyBullet(_)

    }
}
