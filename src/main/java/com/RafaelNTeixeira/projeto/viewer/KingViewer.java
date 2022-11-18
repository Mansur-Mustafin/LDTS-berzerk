package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;

public class KingViewer implements ElementViewer<King>{
    @Override
    public void draw(King king, GUI gui) {
        gui.drawKing(king.getPosition());
    }
}
