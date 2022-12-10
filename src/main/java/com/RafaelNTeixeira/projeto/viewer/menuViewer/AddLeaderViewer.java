package com.RafaelNTeixeira.projeto.viewer.menuViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.AddLeader;

public class AddLeaderViewer extends Viewer<AddLeader> {
    public AddLeaderViewer(AddLeader lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5,12 ), "enter your name:", "#FFFFFF");
        gui.drawText(new Position(5, 10), "your Score: " + getModel().getScore(), "#FFFFFF");

        String name = getModel().getName();
        gui.drawText(new Position(22, 12), name, "#FFFFFF");
    }
}
