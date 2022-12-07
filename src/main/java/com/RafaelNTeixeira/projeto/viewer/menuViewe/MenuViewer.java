package com.RafaelNTeixeira.projeto.viewer.menuViewe;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 9), "menu", "#FFFFFF");

        int numberEntries = getModel().getNumberEntries();
        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);

            gui.drawText(new Position(12, 12 + i), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}
