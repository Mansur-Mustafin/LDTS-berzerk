package com.RafaelNTeixeira.projeto.viewer.menuViewe;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class LoseViewer extends Viewer<Lose> {
    public LoseViewer(Lose lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(10, 10), "game over", "#ff0000");
        gui.drawText(new Position(8, 11), "your score:" + getModel().getScore(), "#FFFFFF");

        int numberEntries = getModel().getNumberEntries();
        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);

            gui.drawText(new Position(12 - i*3, 13 + i + 1), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}

