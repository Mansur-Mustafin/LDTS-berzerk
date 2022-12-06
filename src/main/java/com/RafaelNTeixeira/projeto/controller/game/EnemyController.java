package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.BFSMoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;

public class EnemyController extends GameController {
    private long lastMovementEnemy;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovementEnemy = 0;
    }


    public boolean canMonsterMove(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > getModel().getWidth() - 1 || position.getY() > getModel().getHeight() - 1)
            return false;
        for (Wall wall : getModel().getWalls()) if (wall.getPosition().equals(position)) return false;
        for (Enemy enemy : getModel().getMonsters()) if (enemy.getPosition().equals(position)) return false;
        for (Enemy enemy : getModel().getKings()) if (enemy.getPosition().equals(position)) return false;
        return true;
    }


    public char DirOfShoot(Position positionMonster) {
        Position positionHero = getModel().getHero().getPosition();
        if (positionHero.getX() == positionMonster.getX()) {
            if (positionMonster.getY() > positionHero.getY()) {
                return 'u';
            } else {
                return 'd';
            }
        }
        if (positionHero.getY() == positionMonster.getY()) {
            if (positionMonster.getX() > positionHero.getX()) {
                return 'l';
            } else {
                return 'r';
            }
        }
        return 'n';
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (time - lastMovementEnemy > 500) {

            getModel().setScore(game.getScore());

            for (Enemy monster : getModel().getMonsters()) {
                Position position;
                while(!canMonsterMove(position = monster.move(getModel().getHero().position, getModel().getWalls()))){}
                monster.setPosition(position);
                if(position.equals(getModel().getHero().position)){
                    SoundControl.getInstance().start(Sound.HERODEATH);
                    getModel().getHero().decreaseEnergy(3);
                }
                char c = DirOfShoot(monster.position);
                if(c != 'n'){
                    getModel().Shoot(c, monster.position, false);
                }
            }

            for (Enemy king : getModel().getKings()) {
                if(king.position.getDistance(getModel().getHero().position) < 20){
                    king.setMoveStrategy(new BFSMoveStrategy());
                }
                Position position = king.move(getModel().getHero().position ,getModel().getWalls() );
                king.setPosition(position);
                if(position.equals(getModel().getHero().position)){
                    SoundControl.getInstance().start(Sound.HERODEATH);
                    getModel().getHero().decreaseEnergy(5);
                }
            }
            this.lastMovementEnemy = time;
        }
    }
}
