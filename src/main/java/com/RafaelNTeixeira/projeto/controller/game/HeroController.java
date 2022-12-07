package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class HeroController extends GameController {

    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        Position moveLeft = getModel().getHero().moveLeft();
        moveHero(moveLeft);
    }

    public void moveHeroRight() {
        Position moveRight = getModel().getHero().moveRight();
        moveHero(moveRight);
    }

    public void moveHeroUp() {
        Position moveUp = getModel().getHero().moveUp();
        moveHero(moveUp);
    }

    public void moveHeroDown() {
        Position moveDown = getModel().getHero().moveDown();
        moveHero(moveDown);
    }

    private boolean canHeroMove(Position position) {

        List<Wall> walls = getModel().getWalls();
        for (Wall wall : walls) {
            boolean equals = wall.getPosition().equals(position);
            if (equals) return false;
        }

        return true;
    }

    public void verifyMonsterCollisions(Position position) {
        SoundControl instance = SoundControl.getInstance();
        Hero hero = getModel().getHero();
        for (int i = 0; i < getModel().getMonsters().size(); i++) {
            boolean monsterHitsHero = getModel().getMonsters().get(i).position.equals(position);
            if (monsterHitsHero) {
                instance.stop(Sound.HERODEATH);
                instance.start(Sound.HERODEATH);
                hero.decreaseEnergy(3);
            }
        }
        for (int i = 0; i < getModel().getKings().size(); i++) {
            boolean kingHitsHero = getModel().getKings().get(i).position.equals(position);
            if (kingHitsHero) {
                instance.stop(Sound.HERODEATH);
                instance.start(Sound.HERODEATH);
                hero.decreaseEnergy(5);
            }
        }
    }

    private void moveHero(Position position) {
        boolean canMove = canHeroMove(position);
        if (canMove) {
            verifyMonsterCollisions(position);
            Hero hero = getModel().getHero();
            hero.setPosition(position);
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) {
        if(key == null){return;}
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w') moveHeroUp();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'd') moveHeroRight();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 's') moveHeroDown();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'a') moveHeroLeft();
    }
}
