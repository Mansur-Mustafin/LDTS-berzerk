package com.RafaelNTeixeira.projeto.viewer.menuViewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Leader;

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

            int y = 7+i;

            gui.drawText(new Position(5, y), name, "#FFFFFF");
            gui.drawText(new Position(25 , y ), score, "#FFFFFF");
        }
        gui.drawText(new Position(6, 22), "press enter to get menu", "#FFD700");

    }
}


