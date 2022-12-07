package com.RafaelNTeixeira.projeto.viewer.menuViewe;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Pause;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class PauseViewer extends Viewer<Pause> {
    public PauseViewer(Pause pause) {
        super(pause);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 8), "pause", "#FFFFFF");

        int numberEntries = getModel().getNumberEntries();
        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);

            gui.drawText(new Position(12, 12 + i), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}

