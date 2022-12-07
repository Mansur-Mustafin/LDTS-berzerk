package com.RafaelNTeixeira.projeto.viewer.gameViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;
import com.RafaelNTeixeira.projeto.viewer.gameViewer.ElementViewer;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        Position wallPosition = wall.getPosition();
        gui.drawWall(wallPosition);
    }
}

