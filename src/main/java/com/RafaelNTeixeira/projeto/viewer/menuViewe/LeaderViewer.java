package com.RafaelNTeixeira.projeto.viewer.menuViewe;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.viewer.menuViewe.Viewer;

public class LeaderViewer extends Viewer<Leader> {
    public LeaderViewer(Leader lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(10, 4), "leader board", "#FFFFFF");

        int numberPlayers = getModel().getNumberOfplayers();
        for (int i = 0; i < 10 && i < numberPlayers ; i++) {
            String name = getModel().getPlayers().get(i).getName();
            String score = getModel().getPlayers().get(i).getScore();

            gui.drawText(new Position(5, 7 + i), name, "#FFFFFF");
            gui.drawText(new Position(5  + 20 , 7 + i ), score, "#FFFFFF");
        }
        gui.drawText(new Position(6, 22), "press enter to get menu", "#FFD700");

    }
}


