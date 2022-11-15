package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.io.IOException;

public class EnemyController extends GameController {
    private long lastMovement;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }


    public boolean canMonsterMove(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > getModel().getWidth() - 1 || position.getY() > getModel().getHeight() - 1)
            return false;
        for (Wall wall : getModel().getWalls()) if (wall.getPosition().equals(position)) return false;
        return true;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters()) {
                Position position;
                while(!canMonsterMove(position = monster.move())){}
                monster.setPosition(position);
            }
            for (King king : getModel().getKings()) {
                Position position;
                while(!canMonsterMove(position = king.move())){}
                king.setPosition(position);
            }
            this.lastMovement = time;
        }
    }
}
