package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Enemy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.KingMoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;

public class EnemyController extends GameController {
    private long lastMovement;
    private Position position_hero;
    private List<Wall> walls;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    public void setPosition_hero(Position position_hero) {
        this.position_hero = position_hero;
    }
    public void setWalls(List<Wall> walls){
        this.walls = walls;
    }

    public boolean canMonsterMove(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > getModel().getWidth() - 1 || position.getY() > getModel().getHeight() - 1)
            return false;
        for (Wall wall : getModel().getWalls()) if (wall.getPosition().equals(position)) return false;
        for (Enemy enemy : getModel().getMonsters()) if (enemy.getPosition().equals(position)) return false;
        for (Enemy enemy : getModel().getKings()) if (enemy.getPosition().equals(position)) return false;
        return true;
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters()) {
                Position position;
                while(!canMonsterMove(position = monster.move(position_hero, walls))){}
                monster.setPosition(position);
                if(position.equals(getModel().getHero().position)){
                    getModel().getHero().decreaseEnergy(5);
                }
            }

            for (King king : getModel().getKings()) {
                if(king.position.getDistance(position_hero) < 20){
                    king.setMoveStrategy(new KingMoveStrategy());
                }
                Position position = king.move(position_hero ,walls );
                king.setPosition(position);
                if(position.equals(getModel().getHero().position)){
                    getModel().getHero().decreaseEnergy(10);
                }
            }
            this.lastMovement = time;
        }
    }
}
