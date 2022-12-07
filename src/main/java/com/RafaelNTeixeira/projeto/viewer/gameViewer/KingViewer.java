package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.viewer.gameViewer.ElementViewer;

public class KingViewer implements ElementViewer<King> {
    @Override
    public void draw(King king, GUI gui) {
        Position kingPosition = king.getPosition();
        gui.drawKing(kingPosition);
    }
}
