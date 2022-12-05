package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.AddLeader;
import com.RafaelNTeixeira.projeto.model.menu.Lose;

public class AddLeaderViewer extends Viewer<AddLeader>{
    public AddLeaderViewer(AddLeader lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5,12 ), "Enter your name:", "#FFFFFF");

        gui.drawText(new Position(5, 10), "Your Score: " + getModel().getScore(), "#FFFFFF");

        String name = getModel().getName();
        gui.drawText(new Position(22, 12), name, "#FFFFFF");
    }
}
