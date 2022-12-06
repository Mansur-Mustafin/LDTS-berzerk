package com.RafaelNTeixeira.projeto.model.game.elements;

import com.RafaelNTeixeira.projeto.model.game.Position;

public class Wall extends Element {
    public Wall(int x, int y){
        super(x,y);
    }

    public Position getPosition() {
        return position;
    }

}
