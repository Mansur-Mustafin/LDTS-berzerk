package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Boss;
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
    private long lastMovementBoss;
    private long lastSpawn;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovementEnemy = 0;
    }


    public boolean canMonsterMove(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > 33 || position.getY() > 23)
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
                while (true) {
                    boolean monsterCanMove = canMonsterMove(position = monster.move(getModel().getHero().position, getModel().getWalls()));
                    if (monsterCanMove) break;
                }
                monster.setPosition(position);
                boolean monsterHitsHero = position.equals(getModel().getHero().position);
                if (monsterHitsHero) {
                    instance.stop(Sound.HERODEATH);
                    instance.start(Sound.HERODEATH);
                }
                char c = DirOfShoot(monster.position);
                if (c != 'n'){
                    instance.stop(Sound.SHOOTING);
                    instance.start(Sound.SHOOTING);
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
                    instance.stop(Sound.HERODEATH);
                    instance.start(Sound.HERODEATH);
                    getModel().getHero().decreaseEnergy(5);
                }
            }
            this.lastMovementEnemy = time;
        }
        if(time - lastMovementBoss > 800 && getModel().getLevel() == 6){
            SoundControl instance = SoundControl.getInstance();
            Boss boss = getModel().getBoss();
            Position position = boss.move(getModel().getHero().position ,getModel().getWalls() );
            boss.setPosition(position);
            boolean BossHitsHero = position.getDistance(getModel().getHero().position) < 2;
            if (BossHitsHero) {
                instance.stop(Sound.HERODEATH);
                instance.start(Sound.HERODEATH);
                getModel().getHero().decreaseEnergy(7);
            }
            getModel().Shoot('r', boss.position, false);
            getModel().Shoot('l', boss.position, false);
            getModel().Shoot('u', boss.position, false);
            getModel().Shoot('d', boss.position, false);
            getModel().Shoot('t', boss.position, false);
            getModel().Shoot('q', boss.position, false);
            getModel().Shoot('a', boss.position, false);
            getModel().Shoot('z', boss.position, false);
            this.lastMovementBoss = time;
        }
        if(time - lastSpawn > 6000 && getModel().getLevel() == 6){
            getModel().spawnMonster();
            lastSpawn = time;
        }
    }
}
