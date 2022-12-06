package com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.util.List;

public class EMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position position, Position position_hero , List<Wall> walls){
        int x = position.getX() + 1;
        int y = position.getY();
        return new Position(x, y);
    }
}
