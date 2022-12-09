package com.RafaelNTeixeira.projeto.controller.Game

import com.RafaelNTeixeira.projeto.Game
import com.RafaelNTeixeira.projeto.controller.game.HeroController
import com.RafaelNTeixeira.projeto.model.game.Position
import com.RafaelNTeixeira.projeto.model.game.arena.Arena
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification
import spock.lang.Unroll

class HeroControllerTest extends Specification{

    private def arena
    private def game
    private def key
    private def time
    private def heroController

    def setup(){
        arena = new Arena(34,24,1)
        heroController = new HeroController(arena)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
    }

    def 'test Cons' (){
        expect:
        heroController.getModel().getWidth() == 34
        heroController.getModel().getHeight() == 24
    }

    def 'test MoveHeroLeft'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroLeft()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() - 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test MoveHeroRight'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroRight()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() + 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test MoveHeroUP'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroUp()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() - 1
    }

    def 'test MoveHeroDown'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroDown()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() + 1
    }

    def 'test Can Hero Move'(){
        given:
        Position p = new Position(112, 3)
        Position p2 = new Position(12, 3)
        Position w = new Position(0,7 )
        when:
        def r = heroController.canHeroMove(p)
        def r2 = heroController.canHeroMove(p2)
        def r3 = heroController.canHeroMove(w)

        then:
        r
        r2
        !r3
    }

    def 'test Monster Collision'(){
        given:
        def energy = new Integer(heroController.getModel().getHero().getEnergy())

        when:
        heroController.verifyMonsterCollisions(new Position(2,2))

        then:
        energy == heroController.getModel().getHero().getEnergy()
    }

    def 'test Monster Collision -5'(){

        when:
        heroController.verifyMonsterCollisions(new Position(3,4))

        then:
        10 == heroController.getModel().getHero().getEnergy()
    }


    def 'test Monster Collision -3'(){

        when:
        heroController.verifyMonsterCollisions(new Position(8, 9))

        then:
        12 == heroController.getModel().getHero().getEnergy()
        1 * heroController.soundDeath()

    }



    def 'test move Hero'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHero(new Position(1,1))

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test move Hero2'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHero(new Position(8, 9))

        then:
        heroController.getModel().getHero().getPosition().getX() == 8
        heroController.getModel().getHero().getPosition().getY() == 9
        12 == heroController.getModel().getHero().getEnergy()
    }

    def 'test step UP'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'w';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() - 1
    }

    def 'test step Down'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 's';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() + 1
    }

    def 'test step Left'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'a';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() - 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test step Right'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'd';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() + 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test step null'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key = null

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }
}
