package com.RafaelNTeixeira.projeto.controller.Game

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.game.BulletController
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet
import com.googlecode.lanterna.input.KeyStroke
import spock.lang.Specification

class BulletControllerTest extends Specification{

    private def arena
    private def bulletController
    private def game
    private def key
    private def time

    def setup(){
        arena = new Arena(34,24,1)
        bulletController = new BulletController(arena)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
    }

    def 'Test cons'() {
        expect:
        bulletController.getModel().getWidth() == 34
        bulletController.getModel().getHeight() == 24
        bulletController.lastMovementBullet == 0
    }

    def 'Have Walls'(){
        given:
        Position position = new Position(0,7)
        Position position1 = new Position(5, 5)

        when:
        boolean f1 = bulletController.HaveWalls(position)
        boolean f2 = bulletController.HaveWalls(position1)

        then:
        f1
        !f2
    }

    //hero 7, 20
    //king 3, 4

    def 'Have Monster'(){
        given:
        Position position = new Position(0,2)
        Position position1 = new Position(8, 9)
        int m_size = arena.getMonsters().size()

        when:
        boolean f1 = bulletController.HaveMonster(position, game)
        boolean f2 = bulletController.HaveMonster(position1, game)
        int m_size2 = arena.getMonsters().size()

        then:
        !f1
        f2
        m_size2 == m_size-1
    }

    def 'King life 1'(){
        given:
        Position position = new Position(0,2)
        Position position1 = new Position(3, 4)

        when:
        boolean f1 = bulletController.HaveKings(position, game)
        boolean f2 = bulletController.HaveKings(position1, game)


        then:
        !f1
        f2
    }

    def 'King life 0'(){
        given:
        Position position1 = new Position(3, 4)
        int k_size = arena.getKings().size()

        when:
        bulletController.HaveKings(position1, game)
        bulletController.HaveKings(position1, game)

        then:
        arena.getKings().size() == k_size - 1
    }

    def 'King life < 0'(){
        given:
        Position position1 = new Position(3, 4)
        int k_size = arena.getKings().size()

        when:
        bulletController.HaveKings(position1, game)
        bulletController.HaveKings(position1, game)
        bulletController.HaveKings(position1, game)

        then:
        arena.getKings().size() == k_size - 1
    }

    def 'Step bullet hits wall'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(0, 2, 'd' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.step(game, key, time)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits monster'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(8, 10, 'u' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.step(game, key, time)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits King'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(3, 5, 'u' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.step(game, key, time)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits Hero'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(7, 21, 'u' as char, false)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.step(game, key, time)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits Boss'(){
        given:
        Arena arena1 = new Arena(34,24,6)
        BulletController bulletController1 = new BulletController(arena1)
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(18, 13, 'u' as char, true)
        list_b.add(bullet)
        arena1.setBullets(list_b)

        when:
        bulletController1.step(game, key, time)

        then:
        arena1.getBullets().size() == 0
    }

}
