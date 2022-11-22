package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class HeroController extends GameController {

    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().moveLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().moveRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().moveUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().moveDown());
    }

    private boolean canHeroMove(Position position) {
        //if (position.getX() < 0) return false;
        //if (position.getY() < 0) return false;
        //if (position.getX() > getModel().getWidth() - 1) return false;
        //if (position.getY() > getModel().getHeight() - 1) return false;

        for (Wall wall : getModel().getWalls())
            if (wall.getPosition().equals(position)) return false;

        return true;
    }

    public void verifyMonsterCollisions(Position position) {
        for (int i = 0; i < getModel().getMonsters().size(); i++) {
            if (getModel().getMonsters().get(i).position.equals(position)) {
                getModel().getHero().decreaseEnergy(5);
            }
        }
        for (int i = 0; i < getModel().getKings().size(); i++) {
            if (getModel().getKings().get(i).position.equals(position)) {
                getModel().getHero().setEnergy(0);
            }
        }
    }

    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            verifyMonsterCollisions(position);
            getModel().getHero().setPosition(position);
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) {
        if(key == null){return;}
        if (key.getKeyType() == KeyType.ArrowUp) moveHeroUp();
        if (key.getKeyType() == KeyType.ArrowRight) moveHeroRight();
        if (key.getKeyType() == KeyType.ArrowDown) moveHeroDown();
        if (key.getKeyType() == KeyType.ArrowLeft) moveHeroLeft();
    }

}
