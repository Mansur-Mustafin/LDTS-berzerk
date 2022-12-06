package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
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

        List<Wall> walls = getModel().getWalls();
        for (Wall wall : walls) {
            boolean equals = wall.getPosition().equals(position);
            if (equals) return false;
        }

        List<Monster> monsters = getModel().getMonsters();
        for (Enemy enemy : monsters) {
            boolean equals1 = enemy.getPosition().equals(position);
            if (equals1) return false;
        }
        List<King> kings = getModel().getKings();
        for (Enemy enemy : kings) {
            boolean equals2 = enemy.getPosition().equals(position);
            if (equals2) return false;
        }
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

            int score = game.getScore();
            getModel().setScore(score);

            List<Monster> monsters = getModel().getMonsters();
            SoundControl instance = SoundControl.getInstance();
            for (Enemy monster : monsters) {
                Position position;
                while (true){
                    boolean canMove = canMonsterMove(position = monster.move(getModel().getHero().position, getModel().getWalls()));
                    if (!!canMove) break;
                }
                monster.setPosition(position);
                boolean monsterHitsHero = position.equals(getModel().getHero().position);
                if (monsterHitsHero) {
                    instance.start(Sound.HERODEATH);
                    getModel().getHero().decreaseEnergy(3);
                }
                char c = DirOfShoot(monster.position);
                if (c != 'n'){
                    getModel().Shoot(c, monster.position, false);
                }
            }

            List<King> kings = getModel().getKings();
            for (Enemy king : kings) {
                if (king.position.getDistance(getModel().getHero().position) < 20){
                    king.setMoveStrategy(new BFSMoveStrategy());
                }
                Position position = king.move(getModel().getHero().position ,getModel().getWalls() );
                king.setPosition(position);
                boolean kingHitsHero = position.equals(getModel().getHero().position);
                if (kingHitsHero) {
                    instance.start(Sound.HERODEATH);
                    getModel().getHero().decreaseEnergy(5);
                }
            }
            this.lastMovementEnemy = time;
        }
    }
}
