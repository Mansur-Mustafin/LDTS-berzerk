package com.RafaelNTeixeira.projeto.viewer.menuViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Win;

public class WinViewer extends Viewer<Win> {
    public WinViewer(Win win) {
        super(win);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(13, 7), "you win!", "#FFD700");
        gui.drawText(new Position(5, 9), "i think you can do better", "#FFFFFF");
        gui.drawText(new Position(10, 10), "let's try again!", "#FFFFFF");

        gui.drawText(new Position(8, 11), "your score:" + getModel().getScore(), "#FFFFFF");

        int numberEntries = getModel().getNumberEntries();
        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);

            gui.drawText(new Position(12 - i*3, 13 + i + 1), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}
