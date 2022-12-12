package com.l12gr05.projeto.viewer.menuViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.menu.Lose;

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

            int x = 12 - i*3;
            int y = 14 + i;

            gui.drawText(new Position(x, y), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}

