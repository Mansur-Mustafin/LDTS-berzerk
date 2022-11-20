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
        gui.drawText(new Position(45, 28), "Enter your name:", "#FFFFFF");

        gui.drawText(new Position(42, 31), "Youe Score: 999", "#FFFFFF");

        gui.drawText(new Position(42, 33), getModel().getName(), "#FFFFFF");
    }
}
