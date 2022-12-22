package com.l12gr05.projeto.model.game.arena

import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.King
import com.l12gr05.projeto.model.game.elements.Enemy.Monster
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.game.elements.Health
import com.l12gr05.projeto.model.game.elements.Hero
import com.l12gr05.projeto.model.game.elements.Wall
import com.l12gr05.projeto.model.game.elements.Bullet
import spock.lang.Specification

class ArenaTest extends Specification{
    private def arena
    private def wall_list

    def setup() {
        arena = new Arena(50, 50, 1)
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
        Hero hero = new Hero(7, 20)

        when:
        Hero hero1 = arena.getHero()

        then:
        hero.getPosition() == hero1.getPosition()
    }

    def 'Get King'() {
        given:
        Position pos = new Position(3, 4)
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
        Position pos = new Position(1, 1)
        Position pos1 = new Position(2, 2)
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
        Position pos = new Position(8, 9)
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

    def 'Spawn Monster'() {
        given:
        int x = arena.getMonsters().size()

        when:
        arena.spawnMonster()
        int z = arena.getMonsters().size()

        then:
        x == z - 2
    }

    def 'Erase Bullet'() {
        given:
        List<Bullet> bullet_l = new ArrayList<Bullet>()
        Bullet bullet = new Bullet(10, 10, 'u' as char, true)
        bullet_l.add(bullet)
        arena.setBullets(bullet_l)
        int x = arena.getBullets().size()

        when:
        arena.eraseBullet(0)

        then:
        x == arena.getBullets().size()+1
    }

    def 'Erase Monsters'() {
        given:
        int x = arena.getMonsters().size()

        when:
        arena.eraseMonster(0)

        then:
        x == arena.getMonsters().size()+1
    }

    def 'Erase King'() {
        given:
        int x = arena.getKings().size()

        when:
        arena.eraseKing(0)

        then:
        x == arena.getKings().size()+1
    }

    def 'Erase Health'() {
        given:
        List<Health> health_l = new ArrayList<>()
        Health health = new Health(5, 5)
        health_l.add(health)
        arena.setHealth(health_l)
        int x = arena.getHealth().size()

        when:
        arena.eraseHealth(0)

        then:
        x == arena.getHealth().size()+1
    }

    def 'Not contains wall'(){

        expect:
        !arena.notContainsWall(-12, 2, (char)'l')
        !arena.notContainsWall(12, -2, (char)'l')
        !arena.notContainsWall(36, 2, (char)'l')
        !arena.notContainsWall(-12, 26, (char)'l')
        !arena.notContainsWall(0,2, (char)'l')
        arena.notContainsWall(7,17,(char) 'u')
        arena.notContainsWall(7,22,(char) 'd')
        arena.notContainsWall(9,20,(char) 'l')
        arena.notContainsWall(5,17,(char) 'r')

    }

    def 'Shoot'(){
        given:
        Position position = new Position(5, 5)

        when:
        arena.Shoot('r' as char, position, true)
        arena.Shoot('l' as char, position, true)
        arena.Shoot('d' as char, position, true)
        arena.Shoot('u' as char, position, true)
        arena.Shoot('q' as char, position, true)
        arena.Shoot('t' as char, position, true)
        arena.Shoot('a' as char, position, true)
        arena.Shoot('z' as char, position, true)
        List<Bullet> bulletList = arena.getBullets()

        then:
        bulletList[0].getPosition() == new Position(6, 5)
        bulletList[1].getPosition() == new Position(4, 5)
        bulletList[2].getPosition() == new Position(5, 6)
        bulletList[3].getPosition() == new Position(5, 4)
        bulletList[4].getPosition() == new Position(4, 4)
        bulletList[5].getPosition() == new Position(6, 4)
        bulletList[6].getPosition() == new Position(4, 6)
        bulletList[7].getPosition() == new Position(6, 6)

    }
}
