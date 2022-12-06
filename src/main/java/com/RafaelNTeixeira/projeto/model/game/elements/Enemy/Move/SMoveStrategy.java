package com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.util.List;

public class SMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position position, Position position_hero , List<Wall> walls){
        int x = position.getX();
        int y = position.getY() + 1;
        return new Position(x, y);
    }
}
