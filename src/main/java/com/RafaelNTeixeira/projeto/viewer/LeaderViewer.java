package com.RafaelNTeixeira.projeto.viewer;

import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Lose;

public class LeaderViewer extends Viewer<Leader>{
    public LeaderViewer(Leader lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(10, 4), "leader board", "#FFFFFF");

        for (int i = 0; i < 10 && i < getModel().getNumberOfplayers() ; i++) {
            String str = getModel().getPlayers().get(i).getName();

            gui.drawText(
                    new Position(5, 7 + i),
                    str,
                    "#FFFFFF");

            gui.drawText(
                    new Position(5  + 20 , 7 + i ),
                    getModel().getPlayers().get(i).getScore(),
                    "#FFFFFF");

        }
        gui.drawText(new Position(6, 22), "press enter to get menu", "#FFD700");

    }
}


