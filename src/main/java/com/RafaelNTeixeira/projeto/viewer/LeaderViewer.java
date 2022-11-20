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
        gui.drawText(new Position(45, 4), "Leader Board", "#FFFFFF");

        for (int i = 0; i < 10 && i < getModel().getNumberOfplayers() ; i++) {
            String str = getModel().getPlayers().get(i).getName();

            gui.drawText(
                    new Position(35, 14 + i),
                    str,
                    "#FFFFFF");

            gui.drawText(
                    new Position(35  + 30 , 14 + i ),
                    getModel().getPlayers().get(i).getScore(),
                    "#FFFFFF");

        }
        gui.drawText(new Position(40, 57), "Press ENTER to get Menu", "#FFD700");

    }
}


