package com.RafaelNTeixeira.projeto.viewer.gameViewer

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Boss
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster
import com.RafaelNTeixeira.projeto.model.game.elements.Hero
import com.RafaelNTeixeira.projeto.model.game.elements.Wall
import spock.lang.Specification

class GameViewerTest extends Specification{

    private def gui

    def 'Draw elements'(){
        given:
        Arena arena = new Arena(50, 50, 1)
        GameViewer gameViewer = new GameViewer(arena)
        gui = Mock(GUILaterna.class)
        Monster monster = arena.getMonsters()[0]
        Wall wall = arena.getWalls()[1]
        King king = arena.getKings()[0]
        Hero hero = arena.getHero()
        int life = hero.getEnergy()+1
        List<Bullet> list = new ArrayList<>()
        Bullet hbullet = new Bullet(5, 5, 'u' as char, true)
        Bullet ebullet = new Bullet(5, 10, 'd' as char, false)
        list.add(hbullet)
        list.add(ebullet)
        arena.setBullets(list)

        when:
        gameViewer.drawElements(gui)

        then:

        1*gui.drawEnemyBullet(ebullet.getPosition())
        1*gui.drawHeroBullet(hbullet.getPosition())
        1*gui.drawWall(wall.getPosition())
        1*gui.drawMonster(monster.getPosition())
        1*gui.drawHero(hero.getPosition())
        1*gui.drawKing(king.getPosition())
        1*gui.drawText(_,_,_)
        life*gui.drawHeart(_)
    }

    def 'draw elements lvl 6'(){
        given:
        Arena arena = new Arena(50, 50, 6)
        GameViewer gameViewer = new GameViewer(arena)
        gui = Mock(GUILaterna.class)
        Boss boss = arena.getBoss()
        int life = boss.getEnergy()

        when:
        when:
        gameViewer.drawElements(gui)

        then:
        17*gui.drawHeart(_)
        1*gui.drawBoss(boss.getPosition())
        life*gui.drawHeartBoss(_)

    }
}
