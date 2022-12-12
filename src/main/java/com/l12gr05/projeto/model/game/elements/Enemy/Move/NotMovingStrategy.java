package com.l12gr05.projeto.model.game.elements.Enemy.Move;

import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.util.List;

public class NotMovingStrategy implements Move {
    @Override
    public Position move(Position position, Position position_hero , List<Wall> walls){
        return position;
    }
}
