package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;

public class BulletController extends GameController{
    private long lastMovementBullet;

    public BulletController(Arena arena) {
        super(arena);
        this.lastMovementBullet = 0;
    }

    public boolean HaveWalls(Position position){
        List<Wall> walls = getModel().getWalls();
        for (Wall wall : walls) {
            boolean positionEquals = wall.getPosition().equals(position);
            if (positionEquals) return true;
        }
        return false;
    }

    public boolean HaveMonster(Position position, Game game){
        for (int i = 0; i < getModel().getMonsters().size() ; i++){
            Monster monster = getModel().getMonsters().get(i);
            boolean bulletHitsMonster = monster.position.equals(position);

            if (bulletHitsMonster) {
                monster.decreaseEnergy(1);
                if(monster.getEnergy() <= 0){
                    SoundControl.getInstance().start(Sound.ENEMYDEATH);
                    getModel().eraseMonster(i);
                    game.incrementScore(5);
                    int score = game.getScore();
                    getModel().setScore(score);
                }
                return true;
            }
        }
        return false;
    }

    public boolean HaveKings(Position position, Game game){
        for (int i = 0; i < getModel().getKings().size() ; i++){
            King king = getModel().getKings().get(i);
            boolean bulletHitsKing = king.position.equals(position);

            if (bulletHitsKing) {
                king.decreaseEnergy(1);
                if(king.getEnergy() <= 0){
                    SoundControl.getInstance().start(Sound.ENEMYDEATH);
                    getModel().eraseKing(i);
                    game.incrementScore(10);
                    int score = game.getScore();
                    getModel().setScore(score);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (time - lastMovementBullet > 30) {
            for (int i = 0; i < getModel().getBullets().size(); i++){
                Bullet bullet = getModel().getBullets().get(i);

                Position position = bullet.move(getModel().getHero().position, getModel().getWalls());
                bullet.setPosition(position);

                boolean bulletHitsWall = HaveWalls(bullet.position);
                if (bulletHitsWall) {
                    getModel().eraseBullet(i);
                }
                boolean BulletHitsMonster = HaveMonster(bullet.position, game);
                if (BulletHitsMonster) {
                    getModel().eraseBullet(i);
                }
                boolean BulletHitsKing = HaveKings(bullet.position, game);
                if (BulletHitsKing) {
                    getModel().eraseBullet(i);
                }
                boolean BulletHitsHero = bullet.position.equals(getModel().getHero().position);
                if (BulletHitsHero) {
                    SoundControl.getInstance().stop(Sound.HERODEATH);
                    SoundControl.getInstance().start(Sound.HERODEATH);
                    getModel().eraseBullet(i);
                    getModel().getHero().decreaseEnergy(1);
                }
            }
            this.lastMovementBullet = time;
        }
    }
}
