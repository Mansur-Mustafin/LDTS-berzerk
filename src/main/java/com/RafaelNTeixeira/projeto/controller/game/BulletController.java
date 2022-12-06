package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Bullet;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class BulletController extends GameController{

    private long lastMovementBullet;

    public BulletController(Arena arena) {
        super(arena);
        this.lastMovementBullet = 0;
    }

    public boolean HaveWalls(Position position){
        for (Wall wall : getModel().getWalls()) if (wall.getPosition().equals(position)) return true;
        return false;
    }

    public boolean HaveMonster(Position position, Game game){
        for (int i = 0; i < getModel().getMonsters().size() ; i++){
            Monster monster = getModel().getMonsters().get(i);
            if(monster.position.equals(position)){
                monster.decreaseEnergy(1);
                if(monster.getEnergy() <= 0){
                    getModel().eraseMonster(i);
                    game.incrementScore(5);
                    getModel().setScore(game.getScore());
                }
                return true;
            }
        }
        return false;
    }

    public boolean HaveKings(Position position, Game game){
        for (int i = 0; i < getModel().getKings().size() ; i++){
            King king = getModel().getKings().get(i);
            if(king.position.equals(position)){
                king.decreaseEnergy(1);
                if(king.getEnergy() <= 0){
                    getModel().eraseKing(i);
                    game.incrementScore(10);
                    getModel().setScore(game.getScore());
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
                if(HaveWalls(bullet.position)){
                    getModel().eraseBullet(i);
                }
                if(HaveMonster(bullet.position, game)){
                    getModel().eraseBullet(i);
                }
                if(HaveKings(bullet.position, game)){
                    getModel().eraseBullet(i);
                }
                if(bullet.position.equals(getModel().getHero().position)){
                    getModel().getHero().decreaseEnergy(1);
                }
            }
            this.lastMovementBullet = time;
        }
    }
}
